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
                <c:if test="${empty dsKhoaHoc}">
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
                    <th>Chuyên Đề</th>
                    <th>Khóa Học</th>
                    <th>Học Phí</th>
                    <th>Thời Lượng</th>
                    <th>Ngày Khai Giảng</th>
                    <th>Người Tạo</th>
                    <th>Ngày Tạo</th>
                    <th></th>
                    <th></th>
                    <th></th>
                    </thead>
                    <tbody>
                    <c:forEach items="${dsKhoaHoc}" var="khoahoc">
                    <tr>
                        <td>${khoahoc.idCD.tenCD}</td>
                        <td>${khoahoc.tenKH}</td>
                        <td><fmt:formatNumber value="${khoahoc.hocPhi}" pattern="#,###"/> VND</td>
                        <td>${khoahoc.thoiLuong}</td>
                        <td><fmt:formatDate value="${khoahoc.ngayKG}" pattern="dd/MM/yyy"/> </td>
                        <td>${khoahoc.idNV.hoTen}</td>
                        <td><fmt:formatDate value="${khoahoc.ngayTao}" pattern="dd/MM/yyy"/> </td>
                        <td>
                            <form action="/KhoaHoc/edit" method="post">
                                <input type="hidden" value="${khoahoc.id}" name="id">
                                <button class="btn btn-primary">Cập Nhật</button>
                            </form>
                        </td>
                        <c:if test="${sessionScope.sessionUser.vaiTro==1}">
                        <td>
                            <button class="btn btn-danger" data-toggle="modal" data-target="#c${khoahoc.id}">Xóa</button>
                        </td>
                        </c:if>
                        <td>
                            <form action="/KhoaHoc/HocVien" method="post">
                                <input type="hidden" value="${khoahoc.id}" name="id">
                                <button class="btn btn-warning">Học Viên</button>
                            </form>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>
