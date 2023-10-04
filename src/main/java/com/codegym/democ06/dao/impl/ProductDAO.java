package com.codegym.democ06.dao.impl;

import com.codegym.democ06.dao.IProductDAO;
import com.codegym.democ06.dao.MyConnection;
import com.codegym.democ06.model.Product;
import com.codegym.democ06.model.SubCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String SELECT_ALL = "SELECT * FROM product WHERE is_delete = 0;";

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = MyConnection.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                Long subCategory_id = resultSet.getLong("sub_category_id");;
                productList.add(new Product(id,name,price,description,image,subCategory_id)) ;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productList;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean update(Product object) {
        return false;
    }

    @Override
    public boolean save(Product object) {
        return false;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }
}
