package vn.hoaitan.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.hoaitan.models.UserModel;
import vn.hoaitan.services.IUserService;
import vn.hoaitan.services.imp.UserServiceImp;
import vn.hoaitan.utils.Constant;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"//forgotpws"})
public class ForgotPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/forgotPassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("new_psw");
        String password_repeat = req.getParameter("confirm_new_psw");
        IUserService userService = new UserServiceImp();
        UserModel user = userService.findByUserNameAndEmail(username,email);
        String msg;

        if(user == null){
            msg = "Không tìm thấy người dùng";
            req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
            return;
        }

        if(!password.equals(password_repeat)){
            msg = "Xác nhận mật khẩu không đúng";
            req.setAttribute("alert", msg);
            req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
            return;
        }

        boolean isSuccess = userService.updatePassword(username,password);
        if(isSuccess){
            msg = "Đổi mật khẩu thành công";
            req.setAttribute("alert", msg);
            resp.sendRedirect(req.getContextPath() + "/home");
        }
        else {
            msg = "Đổi mật khẩu thất bại";
            req.setAttribute("alert", msg);
            req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
        }
    }
}
