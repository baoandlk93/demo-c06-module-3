package com.codegym.democ06.service.impl;

import com.codegym.democ06.dao.ISubCategoryDAO;
import com.codegym.democ06.dao.impl.SubCategoryDAO;
import com.codegym.democ06.model.SubCategory;
import com.codegym.democ06.service.ISubCategoryService;

import java.util.List;

public class SubCategoryService implements ISubCategoryService {
    private static final ISubCategoryDAO subCategoryDAO = new SubCategoryDAO();


    @Override
    public List<SubCategory> findAll() {
        return subCategoryDAO.findAll();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean save(SubCategory object) {
        return false;
    }

    @Override
    public boolean update(SubCategory object) {
        return false;
    }

    @Override
    public SubCategory findById(Long id) {
        return null;
    }
}
