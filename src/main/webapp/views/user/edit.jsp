<%--
  Created by IntelliJ IDEA.
  User: thongpro
  Date: 3/31/22
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="card">
        <div class="header">
            <h4 class="title">Quản Lý Tài Khoản</h4>
        </div>
    <div class="content">
        <form action="/User/update?id=${user.id}" method="post">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Họ Tên</label>
                        <input type="text" class="form-control" placeholder="Họ Tên" name="hoTen" value="${user.hoTen}">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" placeholder="Email" name="email" value="${user.email}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class=" p-3 mt-4 col-md-6">
                    <label class="form-label fw-bold pe-4 me-3">Phân Quyền</label>
                    <input class="form-check-input" type="radio" value="0" ${user.vaiTro==0 ? "checked" : ""} name="vaiTro">
                    <label class="form-check-label me-5">Nhân Viên</label>
                    <input class="form-check-input" type="radio" value="1" ${user.vaiTro==1 ? "checked" : ""} name="vaiTro">
                    <label class="form-check-label me-3">Trưởng Phòng</label>
                </div>
            </div>

            <button  class="btn btn-success">Cập Nhật</button>
            <button type="reset" class="btn btn-primary">Làm mới</button>
            <div class="clearfix"></div>
        </form>
    </div>
</div>

