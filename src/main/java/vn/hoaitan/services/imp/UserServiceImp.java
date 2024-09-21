package vn.hoaitan.services.imp;

import vn.hoaitan.configs.DBConnectMySQL;
import vn.hoaitan.dao.IUserDao;
import vn.hoaitan.dao.imp.UserDaoImp;
import vn.hoaitan.models.UserModel;
import vn.hoaitan.services.IUserService;
import vn.hoaitan.utils.Constant;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserServiceImp implements IUserService {
    // Lấy toàn bộ hàm trong tầng Dao của User
    IUserDao userDao = new UserDaoImp();

    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.FindByUserName(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public UserModel FindByUserName(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public boolean register(String userName, String password, String email, String fullName,int roleid, String phone) {
        if(this.checkExistUsername(userName)){
            return false;
        }
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        this.insertUser(new UserModel(userName,email,fullName,password,null,roleid,phone, date));
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUserName(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public void insertUser(UserModel userModel) {
        userDao.insertUser(userModel);
    }

    @Override
    public boolean updatePassword(String email, String password) throws SQLException {
        try {
            String sql = "Update Users Set password = ? WHERE email = ?";
            Connection conn = DBConnectMySQL.getDatabaseConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setString(2,email);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
