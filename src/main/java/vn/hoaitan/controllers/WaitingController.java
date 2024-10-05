package vn.hoaitan.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.hoaitan.models.UserModel;

import java.io.IOException;
@WebServlet(urlPatterns = {"/waiting"})
public class WaitingController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        HttpSession session= req.getSession();
        if(session != null && session.getAttribute("account") != null) {

            UserModel u=(UserModel) session.getAttribute("account");
            session.setAttribute("uname", u.getUsername());
            if(u.getRoleid()==1) {
                resp.sendRedirect(req.getContextPath()+"/home");
            }else if(u.getRoleid()==2) {
                resp.sendRedirect(req.getContextPath()+"/admin/home");
            }else if(u.getRoleid()==3) {
                resp.sendRedirect(req.getContextPath()+"/seller/home");
            }else if(u.getRoleid()==4) {
                resp.sendRedirect(req.getContextPath()+"/shipper/home");
            }else if(u.getRoleid()==5) {
                resp.sendRedirect(req.getContextPath()+"/home");
            }else {
                resp.sendRedirect(req.getContextPath()+"/home");
            }
        }else {
            resp.sendRedirect(req.getContextPath()+"/login");
        }}
}
