package com.controller;

import com.controller.frontController.Controller;
import com.dto.ProductDto;
import com.service.ProductService;
import com.service.impl.IProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController implements Controller {
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
        Integer id = Integer.parseInt(request.getParameter("id"));
        ProductDto product = productService.getProductById(id);
        request.setAttribute("product", product);
        request.setAttribute("relatedProducts", productService.getTopRelatedProduct(product.type, product.brand));
        request.getRequestDispatcher("shop-details.jsp").forward(request, response);
    }
    void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
