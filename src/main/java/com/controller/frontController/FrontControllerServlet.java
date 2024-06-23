package com.controller.frontController;

import com.controller.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String uri = request.getRequestURI();
        Controller controller = getControllerForURI(uri);
        controller.handleRequest(request, response);
    }
    private Controller getControllerForURI(String uri) {
        switch (uri) {
            case "/":
                return new HomeController();
            case "/login":
                return new LoginController();
            case "/logout":
                return new LogoutController();
            case "/product":
                return new ProductController();
            case "/checkout":
                return new CheckoutController();
            case "/cart":
                return new CartController();
            case "/category":
                return new CategoryController();
            case "/payment":
                return new PaymentController();
            default:
                return new DefaultController();
        }
    }
}
