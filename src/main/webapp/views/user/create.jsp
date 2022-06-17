<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="card">
        <div class="header">
            <h4 class="title">Quản Lý Tài Khoản</h4>
        </div>
    <div class="content">
        <form action="/User/store" method="post">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Họ Tên</label>
                        <input type="text" class="form-control" placeholder="Họ Tên" name="hoTen">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" placeholder="Email" name="email">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" placeholder="Password" name="matKhau">
                    </div>
                </div>
                <div class=" col-md-6">
                    <label class="form-label fw-bold pe-4 me-3">Phân Quyền</label>
                    <input class="form-check-input" type="radio" value="0" checked name="vaiTro">
                    <label class="form-check-label me-5">Nhân Viên</label>
                    <input class="form-check-input" type="radio" value="1" name="vaiTro">
                    <label class="form-check-label me-3">Trưởng Phòng</label>
                </div>

            </div>
            <button type="submit" class="btn btn-info btn-fill ">Thêm </button>
            <button type="reset" class="btn btn-info btn-fill ">Làm Mới</button>
            <div class="clearfix"></div>
        </form>
    </div>
</div>