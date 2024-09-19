package vn.hoaitan.dao.imp;

import vn.hoaitan.configs.DBConnectMySQL;
import vn.hoaitan.configs.DBConnectSQL;
import vn.hoaitan.dao.IUserDao;
import vn.hoaitan.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

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
                user.setdatecreate(rs.getDate("createdate"));

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
        String sql = "Insert INTO Users(id, username, password, email, fullname, image, roleid, phone, datecreate) " +
                " Values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            conn = super.getDatabaseConnection(); // kết nối database
            ps = conn.prepareStatement(sql); // Ném câu lệnh sql vào cho thực thi

            ps.setInt(1,user.getId());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getFullname());
            ps.setString(6, user.getImage());
            ps.setInt(7,user.getRoleid());
            ps.setString(8,user.getPhone());
            

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            IUserDao userDao = new UserDaoImp();
            userDao.insertUser(new UserModel(2,"mynhk","admin123","mynhk@gmail.com","Nguyễn Hồ Kiều My",null,2,"0965276507",null));
            List<UserModel> list = userDao.findAll();

            //System.out.println(userDao.findByUsername("tannh"));


            for(UserModel user : list)
            {
                System.out.println(user);
            }


        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
