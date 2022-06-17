package controllers;

import dao.chuyenDeDao;
import dao.nhanVienDao;
import entitys.ChuyenDe;
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
@WebServlet({"/ChuyenDe/store", "/ChuyenDe/edit", "/ChuyenDe/update", "/ChuyenDe/delete", "/ChuyenDe/index"})
public class ChuyenDeServlet extends HttpServlet {
    private chuyenDeDao dao;

    public ChuyenDeServlet() {
        this.dao = new chuyenDeDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("uri",2);
        String uri = request.getRequestURI();
        if (uri.contains("/ChuyenDe/index")) {
            this.create(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        request.setAttribute("uri",2);
        if (uri.contains("/ChuyenDe/store")) {
            this.store(request, response);
        } else if (uri.contains("/ChuyenDe/update")) {
            this.update(request, response);
        } else if (uri.contains("/ChuyenDe/edit")) {
            this.edit(request, response);
        } else if (uri.contains("/ChuyenDe/delete")) {
            this.delete(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listAlL(request, response);
        request.setAttribute("view", "/views/chuyende/create.jsp");
        request.setAttribute("view1", "/views/chuyende/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void listAlL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChuyenDe> list = this.dao.findAll();
        request.setAttribute("dsChuyenDe", list);
    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            ChuyenDe before=this.dao.findById(Integer.parseInt(s));
            ChuyenDe entity = new ChuyenDe();
            BeanUtils.populate(entity,request.getParameterMap());
            entity.setStatus(before.getStatus());
            this.dao.update(entity);
            session.setAttribute("message", "Cập Nhật Thành Công");
            response.sendRedirect("/ChuyenDe/index");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Cập Nhật Thất Bại");
            response.sendRedirect("/ChuyenDe/index");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            ChuyenDe entity = this.dao.findById(id);
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setStatus(0);
            this.dao.update(entity);
            session.setAttribute("message", "Xóa Thành Công");
            response.sendRedirect("/ChuyenDe/index");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Xóa Thất Bại");
            response.sendRedirect("/ChuyenDe/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ChuyenDe entity = new ChuyenDe();
        List<ChuyenDe> list = new ArrayList<>();
        try {
                BeanUtils.populate(entity, request.getParameterMap());
                entity.setStatus(1);
                this.dao.create(entity);
                session.setAttribute("message", "Thêm Mới Thành Công");
                list.add(entity);
                request.setAttribute("dsChuyenDe", list);
                listAlL(request, response);
                response.sendRedirect("/ChuyenDe/index");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm Mới Thất Bại");
        }

    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        ChuyenDe entity = this.dao.findById(id);
        request.setAttribute("chuyende", entity);
        listAlL(request, response);
        request.setAttribute("view", "/views/chuyende/edit.jsp");
        request.setAttribute("view1", "/views/chuyende/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
}
