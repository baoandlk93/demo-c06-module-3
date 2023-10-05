package com.codegym.democ06.dao.impl;

import com.codegym.democ06.dao.ISubCategoryDAO;
import com.codegym.democ06.dao.MyConnection;
import com.codegym.democ06.model.Product;
import com.codegym.democ06.model.SubCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryDAO implements ISubCategoryDAO {
    private static final String SELECT_ALL = "SELECT * FROM sub_category WHERE is_delete = 0;";

    @Override
    public List<SubCategory> findAll() {
        Connection connection = MyConnection.getConnectDB();
        List<SubCategory> subCategories = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                subCategories.add(new SubCategory(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subCategories;
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
