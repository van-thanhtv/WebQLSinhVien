package controllers;

import dao.nguoiHocDao;
import dao.nhanVienDao;
import entitys.NguoiHoc;
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
@WebServlet({"/NguoiHoc/store", "/NguoiHoc/edit", "/NguoiHoc/update", "/NguoiHoc/delete", "/NguoiHoc/index"})
public class NguoiHocServlet extends HttpServlet {
    private nguoiHocDao dao;

    public NguoiHocServlet() {
        this.dao = new nguoiHocDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("uri", 3);
        String uri = request.getRequestURI();
        if (uri.contains("/NguoiHoc/index")) {
            this.create(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        request.setAttribute("uri", 3);
        if (uri.contains("/NguoiHoc/store")) {
            this.store(request, response);
        } else if (uri.contains("/NguoiHoc/update")) {
            this.update(request, response);
        } else if (uri.contains("/NguoiHoc/edit")) {
            this.edit(request, response);
        } else if (uri.contains("/NguoiHoc/delete")) {
            this.delete(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listAlL(request, response);
        request.setAttribute("view", "/views/nguoihoc/create.jsp");
        request.setAttribute("view1", "/views/nguoihoc/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void listAlL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NguoiHoc> list = this.dao.findAll();
        request.setAttribute("dsNguoiHoc", list);
    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            NguoiHoc before = this.dao.findById(id);
            NguoiHoc entity = new NguoiHoc();
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setStatus(before.getStatus());
            entity.setIdNV(before.getIdNV());
            entity.setNgayDK(before.getNgayDK());
            this.dao.update(entity);
            session.setAttribute("message", "Cập Nhật Thành Công");
            response.sendRedirect("/NguoiHoc/index");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Cập Nhật Thất Bại");
            response.sendRedirect("/NguoiHoc/index");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            NguoiHoc entity = this.dao.findById(id);
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setStatus(0);
            this.dao.update(entity);
            session.setAttribute("message", "Xóa Thành Công");
            response.sendRedirect("/NguoiHoc/index");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Xóa Thất Bại");
            response.sendRedirect("/NguoiHoc/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        NguoiHoc entity = new NguoiHoc();
        List<NguoiHoc> list = new ArrayList<>();
        String email = request.getParameter("email");
        NguoiHoc nguoiHoc = this.dao.findByEmail(email);
        String phone = request.getParameter("sdt");
        NguoiHoc nguoiHoc1 = this.dao.findByPhone(phone);
        NhanVien nv= (NhanVien) session.getAttribute("sessionUser");
        try {
            if (nguoiHoc != null) {
                session.setAttribute("error", "Email Đã Tồn Tại");
                response.sendRedirect("/NguoiHoc/index");
                return;
            } else {
                if (nguoiHoc1 != null) {
                    session.setAttribute("error", "Số Điện Thoại Đã Tồn Tại");
                    response.sendRedirect("/NguoiHoc/index");
                    return;
                } else {
                    BeanUtils.populate(entity, request.getParameterMap());
                    entity.setStatus(1);
                    entity.setIdNV(nv);
                    entity.setNgayDK(new java.sql.Date(new java.util.Date().getTime()));
                    this.dao.create(entity);
                    session.setAttribute("message", "Thêm Mới Thành Công");
                    list.add(entity);
                    request.setAttribute("ds", list);
                    listAlL(request, response);
                    response.sendRedirect("/NguoiHoc/index");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm Mới Thất Bại");
        }

    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        NguoiHoc entity = this.dao.findById(id);
        request.setAttribute("nguoihoc", entity);
        listAlL(request, response);
        request.setAttribute("view", "/views/nguoihoc/edit.jsp");
        request.setAttribute("view1", "/views/nguoihoc/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
}
