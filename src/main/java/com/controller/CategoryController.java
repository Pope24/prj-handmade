package com.controller;

import com.controller.frontController.Controller;
import com.service.CategoryService;
import com.service.impl.ICategoryService;
import com.validation.PagingValidation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class CategoryController implements Controller {
    private ICategoryService categoryService = new CategoryService();
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
            case "filter":
                getProductFilter(request, response);
                break;
            default:
                getProductSearch(request, response);
        }
    }


    void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
    private void getProductSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        if (search == null) search = "";
        String page = request.getParameter("page");
        request.setAttribute("informationProduct", categoryService.getInformationProductSearch(search, page));
        request.getRequestDispatcher("shop-grid.jsp").forward(request, response);
    }
    private void getProductFilter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryURL = request.getQueryString();
        String[] brands = request.getParameterValues("brands");
        String[] types = request.getParameterValues("types");
        String minPrice = request.getParameter("min-price");
        String maxPrice = request.getParameter("max-price");
        String page = request.getParameter("page");
        request.setAttribute("informationProduct", categoryService.getProductFilter(brands, types, minPrice, maxPrice, page, queryURL));
        request.getRequestDispatcher("shop-grid.jsp").forward(request, response);
    }
}
