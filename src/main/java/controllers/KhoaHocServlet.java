package controllers;

import dao.*;
import entitys.*;
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
@WebServlet({"/KhoaHoc/store","/KhoaHoc/show", "/KhoaHoc/edit", "/KhoaHoc/update", "/KhoaHoc/delete", "/KhoaHoc/index", "/KhoaHoc/HocVien", "/HocVien/storeNH", "/HocVien/updateDiem","/HocVien/deleteHV"})
public class KhoaHocServlet extends HttpServlet {
    private khoaHocDao khoaHocDao;
    private nhanVienDao userDao;
    private chuyenDeDao chuyenDeDao;
    private hocVienDao hocVienDao;
    private nguoiHocDao nguoiHocDao;
    private int idCu,idCuKH;

    public KhoaHocServlet() {
        this.khoaHocDao = new khoaHocDao();
        this.userDao = new nhanVienDao();
        this.chuyenDeDao = new chuyenDeDao();
        this.hocVienDao = new hocVienDao();
        this.nguoiHocDao = new nguoiHocDao();
        idCu = -1;
        idCuKH=-1;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        request.setAttribute("uri", 4);
        if (uri.contains("/KhoaHoc/index")) {
            this.create(request, response);
        } else if (uri.contains("/KhoaHoc/show")) {
        this.show(request, response);
        }else if (uri.contains("/KhoaHoc/HocVien")) {
            this.hocVien(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("uri", 4);
        String uri = request.getRequestURI();
        if (uri.contains("/KhoaHoc/store")) {
            this.store(request, response);
        } else if (uri.contains("/KhoaHoc/update")) {
            this.update(request, response);
        } else if (uri.contains("/KhoaHoc/edit")) {
            this.edit(request, response);
        } else if (uri.contains("/KhoaHoc/delete")) {
            this.delete(request, response);
        } else if (uri.contains("/KhoaHoc/HocVien")) {
            this.hocVien(request, response);
        } else if (uri.contains("/HocVien/storeNH")) {
            this.storeNH(request, response);
        } else if (uri.contains("/HocVien/updateDiem")) {
            this.updateDiem(request, response);
        } else if (uri.contains("/HocVien/deleteHV")) {
            this.deleteHV(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listALl(request, response);
        request.setAttribute("view", "/views/khoahoc/create.jsp");
        request.setAttribute("view1", "/views/khoahoc/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void listALl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChuyenDe> listCD = this.chuyenDeDao.findAll();
        request.setAttribute("dsChuyenDe", listCD);
        String idCD = request.getParameter("id");
        if (idCD!=null){
            int idti = Integer.parseInt(idCD);
            this.idCu=idti;
            ChuyenDe cd = this.chuyenDeDao.findById(idti);
            request.setAttribute("c",cd);
        }else {
            if (this.idCu!=-1){
                request.setAttribute("c","");
            }
                ChuyenDe chuyenDe = listCD.get(0);
                ChuyenDe cd = this.chuyenDeDao.findById(chuyenDe.getId());
                request.setAttribute("cd1", cd);
        }
        List<KhoaHoc> list = this.khoaHocDao.findAll();
        request.setAttribute("dsKhoaHoc", list);
    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            KhoaHoc before = this.khoaHocDao.findById(id);
            BeanUtils.populate(before, request.getParameterMap());
            this.khoaHocDao.update(before);
            session.setAttribute("message", "Cập Nhật Thành Công");
            response.sendRedirect("/KhoaHoc/index");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Cập Nhật Thất Bại");
            response.sendRedirect("/KhoaHoc/index");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            KhoaHoc entity = this.khoaHocDao.findById(id);
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setStatus(0);
            this.khoaHocDao.update(entity);
            session.setAttribute("message", "Xóa Thành Công");
            response.sendRedirect("/KhoaHoc/index");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Xóa Thất Bại");
            response.sendRedirect("/KhoaHoc/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idCD = Integer.parseInt(request.getParameter("idChuyenDe"));
        NhanVien nv = (NhanVien) session.getAttribute("sessionUser");
        KhoaHoc entity = new KhoaHoc();
        try {
            ChuyenDe chuyenDe = this.chuyenDeDao.findById(idCD);
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setIdCD(chuyenDe);
            entity.setHocPhi(chuyenDe.getHocPhi());
            entity.setThoiLuong(chuyenDe.getThoiLuong());
            entity.setIdNV(nv);
            entity.setNgayTao(new java.sql.Date(new java.util.Date().getTime()));
            entity.setStatus(1);
            System.out.println(entity.getNgayKG().toString());
            this.khoaHocDao.create(entity);
            listALl(request, response);
            session.setAttribute("message", "Thêm Mới Thành Công");
            response.sendRedirect("/KhoaHoc/index");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/KhoaHoc/index");
            session.setAttribute("error", "Thêm Mới Thất Bại");
        }

    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listALl(request, response);
        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        KhoaHoc entity = this.khoaHocDao.findById(id);
        request.setAttribute("khoahoc", entity);
        List<KhoaHoc> list = this.khoaHocDao.findAll();
        request.setAttribute("dsKhoaHoc", list);
        request.setAttribute("view", "/views/khoahoc/edit.jsp");
        request.setAttribute("view1", "/views/khoahoc/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChuyenDe> listCD = this.chuyenDeDao.findAll();
        request.setAttribute("dsChuyenDe", listCD);
        String idCD = request.getParameter("id");
        if (idCD == null) {
            ChuyenDe chuyenDe = listCD.get(0);
            ChuyenDe cd = this.chuyenDeDao.findById(chuyenDe.getId());
            request.setAttribute("cd", cd);
        } else {
            ChuyenDe chuyenDe = this.chuyenDeDao.findById(Integer.parseInt(idCD));
            request.setAttribute("cd1", chuyenDe);
        }
        this.create(request,response);
    }

    protected void hocVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        KhoaHoc entity = this.khoaHocDao.findById(id);
        idCuKH = id;
        request.setAttribute("khoahoc", entity);
        List<NguoiHoc> dsNguoiHoc = this.nguoiHocDao.findAll();
        List<HocVien> dsHocVien = this.hocVienDao.findByKH(id);
        NguoiHoc t = new NguoiHoc();
        for (HocVien hv : dsHocVien) {
            for (NguoiHoc u : dsNguoiHoc) {
                if (hv.getIdNH().getId() == u.getId()) {
                    t = u;
                }
            }
            dsNguoiHoc.remove(t);
        }
        if (dsNguoiHoc.isEmpty()) {
            session.setAttribute("error", "Đã Hết Người Học");
        }
        request.setAttribute("dsNguoiHoc", dsNguoiHoc);
        request.setAttribute("dsHocVien", dsHocVien);
        request.setAttribute("view", "/views/hocvien/create.jsp");
        request.setAttribute("view1", "/views/hocvien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void storeNH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HocVien entity = new HocVien();
        List<HocVien> list = new ArrayList<>();
        String idNguoiHoc = request.getParameter("idNguoiHoc");
        try {
            NguoiHoc nguoiHoc = this.nguoiHocDao.findById(Integer.parseInt(idNguoiHoc));
            KhoaHoc khoaHoc = this.khoaHocDao.findById(idCuKH);
            BeanUtils.populate(entity, request.getParameterMap());
            entity.setDiem(null);
            entity.setIdNH(nguoiHoc);
            entity.setIdKH(khoaHoc);
            this.hocVienDao.create(entity);
            session.setAttribute("message", "Thêm Mới Thành Công");
            list.add(entity);
            request.setAttribute("ds", list);
            response.sendRedirect("/KhoaHoc/HocVien?id="+khoaHoc.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm Mới Thất Bại");
        }
    }
    protected void updateDiem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        int diem= Integer.parseInt(request.getParameter("diem"));
        try {
            int id = Integer.parseInt(s);
            HocVien entity = this.hocVienDao.findById(id);
            entity.setDiem(diem);
            this.hocVienDao.update(entity);
            session.setAttribute("message", "Cập Nhật Thành Công");
            response.sendRedirect("/KhoaHoc/HocVien?id="+entity.getIdKH().getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Cập Nhật Thất Bại");
            response.sendRedirect("/KhoaHoc/index");
        }

    }
    protected void deleteHV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = request.getParameter("id");
        try {
            int id = Integer.parseInt(s);
            HocVien entity = this.hocVienDao.findById(id);
            this.hocVienDao.delete(entity);
            session.setAttribute("message", "Xóa Thành Công");
            response.sendRedirect("/KhoaHoc/HocVien?id="+entity.getIdKH().getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Xóa Thất Bại");
            response.sendRedirect("/KhoaHoc/index");
        }
    }
}
