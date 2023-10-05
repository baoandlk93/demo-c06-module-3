package com.codegym.democ06.service;

import com.codegym.democ06.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IProductService extends IUtilService<Product> {
    boolean addProduct(HttpServletRequest req, HttpServletResponse resp);
}
