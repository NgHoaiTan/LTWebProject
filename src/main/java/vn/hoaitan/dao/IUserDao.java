package vn.hoaitan.dao;

import vn.hoaitan.models.UserModel;

import java.util.List;

public interface IUserDao {
    UserModel findByUsername(String username);

    List<UserModel> findAll();

    void insertUser(UserModel user);

    boolean checkExistEmail(String email);
    boolean checkExistUserName(String userName);
    boolean checkExistPhone(String phone);
}
