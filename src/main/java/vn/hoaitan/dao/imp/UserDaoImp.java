package vn.hoaitan.dao.imp;

import vn.hoaitan.configs.DBConnectMySQL;
import vn.hoaitan.configs.DBConnectSQL;
import vn.hoaitan.dao.IUserDao;
import vn.hoaitan.models.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp extends DBConnectMySQL implements IUserDao {

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public UserModel findByUsername(String username) {
        String sql = "Select * From Users Where Username = ? ";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            rs = ps.executeQuery();
            UserModel user = new UserModel();
            while (rs.next()) {

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setImage(rs.getString("image"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
                user.setdatecreate(rs.getDate("datecreate"));

            }

            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserModel> findAll() {
        String sql = "Select * from Users";

        List<UserModel> list = new ArrayList<>(); // Tạo list để lưu truyền dữ liệu

        try {
            conn = super.getDatabaseConnection(); // Kết nối database
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) { // Next từng dòng tới cuối bảng
                list.add(new UserModel(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("image"),
                        rs.getInt("roleid"),
                        rs.getString("phone"),
                        rs.getDate("datecreate")));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertUser(UserModel user) {
        String sql = "Insert INTO Users(username, password, email, fullname, image, roleid, phone, datecreate) " +
                " Values(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            conn = super.getDatabaseConnection(); // kết nối database
            ps = conn.prepareStatement(sql); // Ném câu lệnh sql vào cho thực thi

            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getFullname());
            ps.setString(5, user.getImage());
            ps.setInt(6,user.getRoleid());
            ps.setString(7,user.getPhone());
            ps.setDate(8, user.getdatecreate());


            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
        String query = "Select * FROM Users Where Email = ? ";
        try{
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,email);
            rs = ps.executeQuery();
            if(rs.next()){
                duplicate = true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return duplicate;
    }

    @Override
    public boolean checkExistUserName(String userName) {
        boolean duplicate = false;
        String query = "Select * FROM Users Where username = ? ";
        try{
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,userName);
            rs = ps.executeQuery();
            if(rs.next()){
                duplicate = true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return duplicate;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        boolean duplicate = false;
        String query = "Select * FROM Users Where phone = ? ";
        try{
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,phone);
            rs = ps.executeQuery();
            if(rs.next()){
                duplicate = true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return duplicate;
    }

    public static void main(String[] args) {

        try {
            IUserDao userDao = new UserDaoImp();
            List<UserModel> list = userDao.findAll();

            //System.out.println(userDao.findByUsername("tannh"));
            if(userDao.checkExistEmail("tannh3108@gmail.com"))
            {
                System.out.println("Exist");
            }
            else {
                System.out.println("New");
            }


        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
