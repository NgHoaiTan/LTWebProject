package vn.hoaitan.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.hoaitan.services.IUserService;
import vn.hoaitan.services.imp.UserServiceImp;
import vn.hoaitan.utils.Constant;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/forgotPassword"})
public class ForgotPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constant.FORGOTPASSWORD).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("confirmPassword");
        IUserService service = new UserServiceImp();
        String alertMsg = "";
        if (!service.checkExistEmail(email)) {
            alertMsg = "Email không  tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.FORGOTPASSWORD).forward(req, resp);
            return;
        }
        if (!password.equals(rePassword)) {
            alertMsg = "Confirm Password không đúng!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.FORGOTPASSWORD).forward(req, resp);
            return;
        }
        boolean isSuccess;
        try {
            isSuccess = service.updatePassword(email, password);
            if (isSuccess) {
                req.setAttribute("alert", alertMsg);
                resp.sendRedirect(req.getContextPath() + "/login");
            } else {
                alertMsg = "System error!";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
