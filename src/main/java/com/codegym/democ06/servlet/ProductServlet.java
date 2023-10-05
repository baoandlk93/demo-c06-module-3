package com.codegym.democ06.servlet;

import com.codegym.democ06.service.IProductService;
import com.codegym.democ06.service.ISubCategoryService;
import com.codegym.democ06.service.impl.ProductService;
import com.codegym.democ06.service.impl.SubCategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "productServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private final IProductService productService = new ProductService();
    private final ISubCategoryService subCategoryService = new SubCategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "delete":

                break;
            case "edit":
                break;
            default:
                findAllProduct(request, response);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/CreateProduct.jsp");
        try {
            request.setAttribute("categories",subCategoryService.findAll());
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void findAllProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/ProductList.jsp");
        request.setAttribute("products", productService.findAll());
        try {
            request.setAttribute("categories",subCategoryService.findAll());
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                if (productService.addProduct(req, resp)) {
                }
                break;
            case "edit":
                break;

        }
    }
}
