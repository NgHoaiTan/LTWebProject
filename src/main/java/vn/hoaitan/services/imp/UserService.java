package vn.hoaitan.services.imp;

import vn.hoaitan.dao.IUserDao;
import vn.hoaitan.dao.imp.UserDaoImp;
import vn.hoaitan.models.UserModel;
import vn.hoaitan.services.IUserSerivice;

public class UserService implements IUserSerivice {
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
}
