package com.controller;

import com.controller.frontController.Controller;
import com.dto.AccountDTO;
import com.entity.Account;
import com.service.ProductService;
import com.service.UserService;
import com.service.impl.IProductService;
import com.service.impl.IUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckoutController implements Controller {
    private IProductService productService = new ProductService();
    private IUserService userService = new UserService();
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
        HttpSession session = request.getSession();
        AccountDTO account = (AccountDTO) session.getAttribute("account");
        if (account == null) {
            response.sendRedirect("/login");
        } else {
            request.setAttribute("user", userService.getUserById(account.getId()));
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        }
    }
    void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
