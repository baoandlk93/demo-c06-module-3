package com.codegym.democ06.service.impl;

import com.codegym.democ06.dao.IProductDAO;
import com.codegym.democ06.dao.impl.ProductDAO;
import com.codegym.democ06.model.Product;
import com.codegym.democ06.service.IProductService;

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
}
