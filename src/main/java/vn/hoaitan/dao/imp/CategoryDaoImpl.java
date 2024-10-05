package vn.hoaitan.dao.imp;

import vn.hoaitan.configs.DBConnectMySQL;
import vn.hoaitan.dao.ICategoryDao;
import vn.hoaitan.models.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<CategoryModel> findAll() {

        String sql = "select * from Categories";
        List<CategoryModel> list = new ArrayList<CategoryModel>();
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImage(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                list.add(category);
            }
            conn.close();
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CategoryModel findById(int id) {
        String sql = "select * from Categories where categoryid = ?";
        CategoryModel category = new CategoryModel();
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImage(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
            }
            conn.close();
            ps.close();
            rs.close();
            return category;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CategoryModel findByName(String name) {
        String sql = "select * from Categories where categoryname = ?";
        CategoryModel category = new CategoryModel();
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {

                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImage(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
            }
            conn.close();
            ps.close();
            rs.close();
            return category;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CategoryModel> searchByName(String keyword) {
        String sql = "select * from Categories where categoryname like ?";
        List<CategoryModel> list = new ArrayList<CategoryModel>();
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImage(rs.getString("image"));
                category.setStatus(rs.getInt("status"));
                list.add(category);
                conn.close();
                ps.close();
                rs.close();
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(CategoryModel category) {
        String sql = "INSERT INTO Categories (categoryname, images, status) VALUES (?, ?, ?)";
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImage());
            ps.setInt(3, category.getStatus());
            ps.executeUpdate();

            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CategoryModel category) {
        String sql = "UPDATE Categories SET categoryname = ?, images =?, status = ? WHERE categoryId = ?";
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImage());
            ps.setInt(3, category.getStatus());
            ps.setInt(4, category.getCategoryid());
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Categories WHERE categoryId = ?";
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(int id, int status) {
        String sql = "UPDATE Categories SET status = ? WHERE categoryId = ?";
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
