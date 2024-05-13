package com.controller;

import com.controller.frontController.Controller;
import com.service.HomeService;
import com.service.impl.IHomeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController implements Controller {
    private IHomeService homeService = new HomeService();
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
        request.setAttribute("productMap", homeService.getAllProductListForHomePage());
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
    void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
