package vn.hoaitan.dao;

import vn.hoaitan.models.UserModel;

import java.util.List;

public interface IUserDao {
    UserModel findByUsername(String username);
    UserModel findById(int id);
    List<UserModel> findAll();
    void insertUser(UserModel user);
    boolean updatePassword(String username, String password);
    boolean updateImage(String username, String imageName);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    UserModel findByUsernameAndEmail(String username, String email);

}
