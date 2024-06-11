package com.controller;

import com.controller.frontController.Controller;
import com.dto.ProductDto;
import com.service.ProductService;
import com.service.impl.IProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CartController implements Controller {
    private IProductService productService = new ProductService();

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
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add-to-cart":
                addToCart(request, response);
                break;
            case "get-total-money":
                calculateTotalMoney(request, response);
                break;
            default:
                request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
        }
    }

    void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) {
        ProductDto product = productService.getProductById(Integer.parseInt(request.getParameter("id")));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session = request.getSession();
        Map<ProductDto, Integer> cart = (Map<ProductDto, Integer>) session.getAttribute("cart");
        boolean flag = true;
        if (cart == null) {
            cart = new LinkedHashMap<>();
        } else {
            for (Map.Entry<ProductDto, Integer> entry : cart.entrySet()) {
                if (entry.getKey().equals(product)) {
                    cart.put(product, entry.getValue() + quantity);
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            cart.put(product, quantity);
        }
        session.setAttribute("cart", cart);
    }
    public void calculateTotalMoney(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Map<ProductDto, Integer> cart = (Map<ProductDto, Integer>) session.getAttribute("cart");
        BigDecimal total = new BigDecimal(0);
        for (Map.Entry<ProductDto, Integer> entry : cart.entrySet()) {
            total = total.add(entry.getKey().price.multiply(new BigDecimal(entry.getValue())));
        }
        response.setContentType("text/plain");
        response.getWriter().write(total.toString());
    }
}
