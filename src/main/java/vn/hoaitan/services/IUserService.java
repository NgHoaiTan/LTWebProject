package vn.hoaitan.services;

import vn.hoaitan.models.UserModel;

import java.sql.SQLException;

public interface IUserService {
    UserModel findByUserName(String username);
    UserModel login(String username, String password);
    UserModel findByUserNameAndEmail(String username, String email);
    boolean updatePassword(String username, String newPassword);
    boolean updateImage(String username, String newIamge);
    void insertUser(UserModel user);
    boolean register(String username, String email, String fullname, String password, int roleid);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
}
