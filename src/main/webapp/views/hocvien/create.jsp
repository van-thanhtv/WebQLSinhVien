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
        <h4 class="title">Quản lý Học Viên Khóa Học : ${khoahoc.tenKH} (<fmt:formatDate value="${khoahoc.ngayKG}" pattern="dd/MM/yyyy"></fmt:formatDate>) </h4>
    </div>
    <div class="content">
        <form action="/HocVien/storeNH" method="post">
            <div class="row">
                <div class="col-md-10">
                    <div class="form-group">
                        <label>Học Viên Khác</label>
                        <select class="form-select form-control" name="idNguoiHoc">
                            <c:forEach items="${ dsNguoiHoc }" var="nh">
                                <option value="${ nh.id }">
                                        ${ nh.hoTen }
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <br>
                <div class="col-md-2">
                    <div class="form-group ">
<%--                        <input type="hidden" value="" name="kh">--%>
                        <button type="submit" class="btn btn-info btn-fill ">Thêm</button>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
        </form>
    </div>
</div>




