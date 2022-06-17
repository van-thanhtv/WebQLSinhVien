<%--
  Created by IntelliJ IDEA.
  User: thongpro
  Date: 3/31/22
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="card">
    <div class="header">
        <h4 class="title">Quản lý Khóa Học</h4>
    </div>
    <div class="content">
        <form action="/KhoaHoc/update?id=${khoahoc.id}" method="post">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Chuyên Đề</label>
                        <select class="form-select" name="idChuyenDe">
                            <c:forEach items="${ dsChuyenDe }" var="cd">
                                <option ${khoahoc.idCD.id==cd.id ? "selected" : ""} value="${ cd.id }">
                                        ${ cd.tenCD }
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Ngày Khai Giảng</label>
                        <input type="date" class="form-control"  name="ngayTao" value="${khoahoc.ngayTao}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label>Tên Khóa Học</label>
                        <input type="text" class="form-control" placeholder="Tên Khoá Học" name="tenKH" value="${khoahoc.tenKH}" >
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Học Phí</label>
                        <input disabled type="number" class="form-control" placeholder="Học Phí" name="hocPhi" value="${khoahoc.hocPhi}">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Thời Lượng</label>
                        <input disabled type="number" class="form-control" placeholder="Thời Lượng" name="thoiLuong" value="${khoahoc.thoiLuong}">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Ghi Chú</label>
                        <textarea name="ghiChu"  cols="30" rows="10" class="form-control"  >${khoahoc.ghiChu}</textarea>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-info btn-fill ">Cập Nhật</button>
            <button type="reset" class="btn btn-info btn-fill ">Làm Mới</button>
            <div class="clearfix"></div>
        </form>
    </div>
</div>




