package vn.hoaitan.dao.imp;

import vn.hoaitan.configs.DBConnectMySQL;
import vn.hoaitan.configs.DBConnectSQL;
import vn.hoaitan.dao.IUserDao;
import vn.hoaitan.models.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp extends DBConnectMySQL implements IUserDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public UserModel findByUsername(String username) {
        String sql = "select * from Users where username = ?";
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            UserModel user = new UserModel();
            while(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setImage(rs.getString("image"));
                user.setCreateDate(rs.getDate("createDate"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
            }
            return user;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel findById(int id) {
        String sql = "select * from Users where username = ?";
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            UserModel user = new UserModel();
            while(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setImage(rs.getString("image"));
                user.setCreateDate(rs.getDate("createDate"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserModel> findAll(){
        List<UserModel> users = new ArrayList<>();
        String sql = "select * from Users";
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setImage(rs.getString("image"));
                user.setCreateDate(rs.getDate("createDate"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertUser(UserModel user) {
        String sql = "INSERT INTO Users(username, email, fullname, password, roleid, createDate) VALUES (?,?,?,?,?,?)";
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getRoleid());
            ps.setDate(6, user.getCreateDate());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        String sql = "UPDATE Users SET password = ? WHERE username = ?";
        boolean isUpdated = false;
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, username);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean updateImage(String username, String imageName) {
        String sql = "UPDATE Users SET image = ? WHERE username = ?";
        boolean isUpdated = false;
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, imageName);
            ps.setString(2, username);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean isDuplicate = false;
        String query = "select * from Users where email = ?";
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                isDuplicate = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isDuplicate;
    }

    @Override
    public boolean checkExistUsername(String username) {
        boolean isDuplicate = false;
        String query = "select * from Users where username = ?";
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                isDuplicate = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isDuplicate;
    }

    @Override
    public UserModel findByUsernameAndEmail(String username, String email) {
        String sql = "select * from Users where username = ? and email = ?";
        try {
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            UserModel user = new UserModel();
            while(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setImage(rs.getString("image"));
                user.setCreateDate(rs.getDate("createDate"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
            }
            return user;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        try {
            IUserDao userDao = new UserDaoImp();
            System.out.println(userDao.checkExistUsername("tannh"));
        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
