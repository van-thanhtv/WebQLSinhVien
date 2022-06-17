<%--
  Created by IntelliJ IDEA.
  User: thanhkali
  Date: 5/8/22
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="content table-responsive table-full-width">
                <c:if test="${empty dsNguoiHoc}">
                    <p class="alert alert-warning">
                        Vui Lòng Thêm Mới Dữ Liệu
                    </p>
                </c:if>
                <c:if test="${!empty sessionScope.error}">
                    <div class="alert alert-danger">
                            ${sessionScope.error}
                    </div>
                    <c:remove var="error" scope="session"/>
                </c:if>
                <c:if test="${!empty sessionScope.message}">
                    <div class="alert alert-success">
                            ${sessionScope.message}
                    </div>
                    <c:remove var="message" scope="session"/>
                </c:if>
                <table class="table table-hover table-striped">
                    <thead>
                    <th>STT</th>
                    <th>Mã Người Học</th>
                    <th>Họ Tên</th>
                    <th>Giới Tính</th>
                    <th>Ngày Sinh</th>
                    <th>Điện Thoại</th>
                    <th>Email</th>
                    <th>MÃ NV</th>
                    <th>Ngày Đăng Ký</th>
                    <th></th>
                    <th></th>
                    </thead>
                    <tbody>
                    <c:forEach items="${dsNguoiHoc}" var="nh" varStatus="status">
                    <tr>
                        <td>#${status.count}</td>
                        <td>NH${nh.id}</td>
                        <td>${nh.hoTen}</td>
                        <td>
                            <c:choose>
                                <c:when test="${nh.gioiTinh==true}">Nam</c:when>
                                <c:when test="${nh.gioiTinh==false}">Nữ</c:when>
                                <c:otherwise>-</c:otherwise>
                            </c:choose>
                        </td>
                        <td> <fmt:formatDate value="${nh.ngaySinh}" pattern="dd/MM/yyyy"></fmt:formatDate> </td>
                        <td>${nh.sdt}</td>
                        <td>${nh.email}</td>
                        <td>NV${nh.idNV.id}</td>
                        <td> <fmt:formatDate value="${nh.ngayDK}" pattern="dd/MM/yyyy"></fmt:formatDate> </td>
                        <td>
                            <form action="/NguoiHoc/edit" method="post">
                                <input type="hidden" value="${nh.id}" name="id">
                                <button class="btn btn-primary">Cập Nhật</button>
                            </form>
                        </td>
                        <c:if test="${sessionScope.sessionUser.vaiTro==1}">
                            <td>
                                <button class="btn btn-danger" data-toggle="modal" data-target="#nh${nh.id}">Xóa</button>
                            </td>
                        </c:if>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>