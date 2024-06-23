package com.controller;

import com.controller.frontController.Controller;
import com.dto.AccountDTO;
import com.service.LoginService;
import com.service.SendEmailService;
import com.service.impl.ILoginService;
import com.service.impl.ISendEmailService;
import com.validation.AccountValidation;
import com.validation.UserValidation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class LoginController implements Controller {
    private ILoginService loginService = new LoginService();
    private ISendEmailService sendEmailService = new SendEmailService();
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase("GET")) {
            doGet(request, response);
        } else if (request.getMethod().equalsIgnoreCase("POST")) {
            doPost(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
    }
    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "verify-email":
                request.getRequestDispatcher("verifyEmail.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "verify-email":
                sendEmailToGetCode(request, response);
                break;
            case "change-password":
                changePassword(request, response);
                break;
            default:
                loginUser(request, response);
        }
    }
    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountDTO account = loginService.getAccountByUserNameAndPassword(username, password);
        if (account != null) {
            if (account.getIsActive()) {
                HttpSession session = request.getSession(true);
                session.setAttribute("account", account);
                session.setMaxInactiveInterval(1800);
                response.sendRedirect("/");
            } else {
                request.setAttribute("accountNotActive", "Tài khoản này đã bị vô hiệu hóa. Vui lòng tạo tài khoản mới để tiếp tục.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorLogin", "Tên đăng nhập hoặc mật khẩu không đúng.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        String code = request.getParameter("code");
        Map<String, String> errors = AccountValidation.checkChangePassword(newPassword, confirmPassword, code, request);
        if (errors.size() > 0) {
            request.setAttribute("errorsChangePassword", errors);
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession(true);
            loginService.updatePasswordByEmail(newPassword, String.valueOf(session.getAttribute("emailForgetPassword")));
            response.sendRedirect("/login?change-password=success");
        }
    }

    protected void sendEmailToGetCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        if (!UserValidation.validateEmailUser(email)) {
            request.setAttribute("errorEmail", "Email không hợp lệ, vui lòng thử lại.");
            request.getRequestDispatcher("verifyEmail.jsp").forward(request, response);
        } else if (!UserValidation.checkExistEmailUser(email)) {
            request.setAttribute("errorEmail", "Email không tồn tại. Vui lòng tạo tài khoản mới để sử dụng");
            request.getRequestDispatcher("verifyEmail.jsp").forward(request, response);
        }
        else {
            int code = sendEmailService.sendCodeChangePassword(email);
            HttpSession session = request.getSession(true);
            session.setAttribute("code", code);
            session.setAttribute("emailForgetPassword", email);
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }
    }
}
