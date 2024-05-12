package com.controller;

import com.dto.ProductDto;
import com.service.ProductService;
import com.service.impl.IProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ProductDto product = productService.getProductById(id);
        request.setAttribute("product", product);
        request.setAttribute("relatedProducts", productService.getTopRelatedProduct(product.type, product.brand));
        request.getRequestDispatcher("shop-details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
