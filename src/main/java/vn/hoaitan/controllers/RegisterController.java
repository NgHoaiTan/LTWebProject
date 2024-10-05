package vn.hoaitan.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import vn.hoaitan.services.IUserService;
import vn.hoaitan.services.imp.UserServiceImp;
import vn.hoaitan.utils.Constant;
@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        String password = req.getParameter("psw");
        String password_repeat = req.getParameter("psw-repeat");
        String email = req.getParameter("email");
        int roleid = Integer.parseInt(req.getParameter("roleid"));
        IUserService service = new UserServiceImp();
        String alertMsg = "";
        if (service.checkExistEmail(email)) {
            alertMsg = "Email đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }
        if (service.checkExistUsername(username)) {
            alertMsg = "Tài khoản đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }
        if(!password.equals(password_repeat)) {
            alertMsg = "Xác nhận mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }
        boolean isSuccess = service.register(username, email, fullname, password, roleid);
        if (isSuccess) {
            alertMsg = "Thành công";
            req.setAttribute("alert", alertMsg);
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            alertMsg = "System error!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }

    }

}

