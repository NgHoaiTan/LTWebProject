package vn.hoaitan.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    // Khai báo các trường trong DB
    private int id;
    private String username;
    private String email;
    private String fullname;
    private String password;
    private String image;
    private int roleid;
    private String phone;
    private Date createDate;


    public UserModel() {
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getFullname() {
        return fullname;
    }


    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public int getRoleid() {
        return roleid;
    }


    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Date getCreateDate() {
        return createDate;
    }


    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", fullname=" + fullname
                + ", password=" + password + ", image=" + image + ", roleid=" + roleid + ", phone=" + phone
                + ", createDate=" + createDate + "]";
    }
}
