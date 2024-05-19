package com.controller;

import com.controller.frontController.Controller;
import com.service.CategoryService;
import com.service.impl.ICategoryService;
import com.validation.PagingValidation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
@MultipartConfig(location = "C:\\Upload")
public class CategoryController implements Controller {
    private ICategoryService categoryService = new CategoryService();
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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


    void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            default:
                getProductSearchImage(request, response);
        }
    }

    private void getProductSearchImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
        FileItem fileItem = sf.parseRequest(request).get(0);
        File uploadDir = new File("C:/upload");
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        fileItem.write(new File("C:/upload/" + fileItem.getName()));
        request.setAttribute("informationProduct", categoryService.getProductSearchByImage("C:\\upload\\" + fileItem.getName()));
        request.getRequestDispatcher("shop-grid.jsp").forward(request, response);
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
