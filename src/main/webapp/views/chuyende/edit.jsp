<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="card">
    <div class="header">
        <h4 class="title">Quản Lý Chuyên Đề</h4>
    </div>
    <div class="content">
        <form action="/ChuyenDe/update?id=${chuyende.id}" method="post">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label>Tên Chuyên Đề</label>
                        <input type="text" class="form-control" placeholder="Tên Chuyên Đề" name="tenCD" value="${chuyende.tenCD}">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Học Phí</label>
                        <input type="number" class="form-control" placeholder="Học Phí" name="hocPhi" value="${chuyende.hocPhi}">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Thời Lượng</label>
                        <input type="number" class="form-control" placeholder="Thời Lượng" name="thoiLuong" value="${chuyende.thoiLuong}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Mô Tả</label>
                        <textarea name="moTa"  cols="30" rows="10" class="form-control"  >${chuyende.moTa}</textarea>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-info btn-fill ">Cập Nhật </button>
            <button type="reset" class="btn btn-info btn-fill ">Làm Mới</button>
            <div class="clearfix"></div>
        </form>
    </div>
</div>