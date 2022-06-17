<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="card">
    <div class="header">
        <h4 class="title">Quản Lý Người Học</h4>
    </div>
    <div class="content">
        <form action="/NguoiHoc/update?id=${nguoihoc.id}" method="post">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Họ Tên</label>
                        <input type="text" class="form-control" placeholder="Họ Tên" name="hoTen" value="${nguoihoc.hoTen}">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" placeholder="Email" name="email" value="${nguoihoc.email}">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Điện Thoại</label>
                        <input type="text" class="form-control" placeholder="Phone" name="sdt" value="${nguoihoc.sdt}">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Ngày Sinh</label>
                        <input type="date" class="form-control" name="ngaySinh" value="${nguoihoc.ngaySinh}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-5 me-4">
                    <label class="form-label fw-bold pe-4 me-3">Giới Tính</label>
                    <input class="form-check-input  " type="radio" value="true" ${nguoihoc.gioiTinh==true ? "checked" : ""} name="gioiTinh">
                    <label class="form-check-label me-5">Nam</label>
                    <input class="form-check-input" type="radio" value="false" ${nguoihoc.gioiTinh==false ? "checked" : ""} name="gioiTinh">
                    <label class="form-check-label me-3">Nữ</label>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Ghi Chú</label>
                        <textarea name="ghiChu"  cols="30" rows="10" class="form-control" >${nguoihoc.ghiChu}</textarea>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-info btn-fill ">Cập Nhật </button>
            <button type="reset" class="btn btn-info btn-fill ">Làm Mới</button>
            <div class="clearfix"></div>
        </form>
    </div>
</div>