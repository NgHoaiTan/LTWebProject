package vn.hoaitan.services;

import vn.hoaitan.models.UserModel;

public interface IUserSerivice {
    UserModel login(String username, String password);

    UserModel FindByUserName(String username);
}
