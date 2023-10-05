package com.codegym.democ06.service.impl;

import com.codegym.democ06.dao.IProductDAO;
import com.codegym.democ06.dao.impl.ProductDAO;
import com.codegym.democ06.model.Product;
import com.codegym.democ06.service.IProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ProductService implements IProductService {
    private final IProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean save(Product object) {
        productDAO.save(object);
        return false;
    }

    @Override
    public boolean update(Product object) {
        return false;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public boolean addProduct(HttpServletRequest req, HttpServletResponse resp) {
       String name = req.getParameter("name");
       String price = req.getParameter("price");
       String description = req.getParameter("description");
       String image = req.getParameter("image");
       Long subCategoryId = Long.valueOf(req.getParameter("subCategoryId"));
       Product product = new Product(name,price,description,image,subCategoryId);
       return save(product);
    }
}
