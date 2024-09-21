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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.sendRedirect(req.getContextPath() + "/admin");
            return;

        }
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/admin");
                    return;
                }
            }
        }
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");
        String phone = req.getParameter("phone");
        req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
    }

    @SuppressWarnings("static-access")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");
        String phone = req.getParameter("phone");
        String confirmPassword = req.getParameter("cPassword");
        String role = req.getParameter("role");
        int roleid = 1;
        if (role.equals("admin"))
            roleid = 2;
        else if (role.equals("manager"))
            roleid = 3;
        else if (role.equals("seller"))
            roleid = 4;
        else
            roleid = 5;


        IUserService service = new UserServiceImp();
        String alertMsg = "";
        if(!password.equals(confirmPassword))
        {
            alertMsg = "ConfirmPassword không đúng!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            return;
        }
        if (service.checkExistEmail(email)) {
            alertMsg = "Email đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            return;
        }
        if (service.checkExistUsername(username)) {
            alertMsg =
                    "Tài khoản đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            return;
        }
        boolean isSuccess = service.register(username, password, email, fullname,roleid, phone);
        if (isSuccess) {
//SendMail sm = new SendMail();
//sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Login to us service. Thanks !");
            req.setAttribute("alert", alertMsg);
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            alertMsg = "System error!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
        }
    }

}

