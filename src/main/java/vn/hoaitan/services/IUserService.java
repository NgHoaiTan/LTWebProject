package vn.hoaitan.services;

import vn.hoaitan.models.UserModel;

public interface IUserService {
    UserModel login(String username, String password);

    UserModel FindByUserName(String username);
    boolean register(String userName, String password, String email, String fullName,int roleid, String phone);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
    void insertUser(UserModel userModel);
}
