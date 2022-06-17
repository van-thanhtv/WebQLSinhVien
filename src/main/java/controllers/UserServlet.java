package controllers;

import dao.nhanVienDao;
import entitys.NhanVien;
import utils.EncryptUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
@WebServlet({"/User/store", "/User/edit", "/User/update", "/User/delete", "/User/index"})
public class UserServlet extends HttpServlet {
    private nhanVienDao dao;

    public UserServlet() {
        this.dao = new nhanVienDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("uri",1);
        String uri = request.getRequestURI();
        request.setAttribute("uri",1);
        if (uri.contains("/User/index")) {
            this.create(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        request.setAttribute("uri",1);
        if (uri.contains("/User/store")) {
            this.store(request, response);
        } else if (uri.contains("/User/update")) {
            this.update(request, response);
        } else if (uri.contains("/User/edit")) {
            this.edit(request, response);
        } else if (uri.contains("/User/delete")) {
            this.delete(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listAlL(request, response);
        request.setAttribute("view", "/views/user/create.jsp");
        request.setAttribute("view1", "/views/user/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void listAlL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        NhanVien user = (NhanVien) session.getAttribute("sessionUser");
            List<NhanVien> list = this.dao.findAll();
            request.setAttribute("ds", list);
    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            NhanVien before = this.dao.findById(id);
            NhanVien entity = new NhanVien();
            BeanUtils.populate(entity,request.getParameterMap());
            entity.setMatKhau(before.getMatKhau());
            entity.setStatus(before.getStatus());
            this.dao.update(entity);
            session.setAttribute("message", "Cập Nhật Thành Công");
            response.sendRedirect("/User/index");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Cập Nhật Thất Bại");
            response.sendRedirect("/User/index");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            NhanVien entity = this.dao.findById(id);
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setStatus(0);
            this.dao.update(entity);
            session.setAttribute("message", "Xóa Thành Công");
            response.sendRedirect("/User/index");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Xóa Thất Bại");
            response.sendRedirect("/User/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        NhanVien entity = new NhanVien();
        List<NhanVien> list = new ArrayList<>();
        String email = request.getParameter("email");
        NhanVien users = this.dao.findByEmail(email);
        try {
                if (users != null) {
                    session.setAttribute("error", "Email Đã Tồn Tại");
                    response.sendRedirect("/User/index");
                    return;
                } else {
                    BeanUtils.populate(entity, request.getParameterMap());
                    String encrypted = EncryptUtil.encrypt(request.getParameter("matKhau"));
                    entity.setMatKhau(encrypted);
                    entity.setStatus(1);
                    this.dao.create(entity);
                    session.setAttribute("message", "Thêm Mới Thành Công");
                    list.add(entity);
                    request.setAttribute("ds", list);
                    listAlL(request, response);
                    response.sendRedirect("/User/index");
                }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm Mới Thất Bại");
        }

    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        NhanVien entity = this.dao.findById(id);
        request.setAttribute("user", entity);
        listAlL(request, response);
        request.setAttribute("view", "/views/user/edit.jsp");
        request.setAttribute("view1", "/views/user/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
}
