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
                <c:if test="${empty dsChuyenDe}">
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
                    <th>Tên Chuyên Đề</th>
                    <th>Học Phí</th>
                    <th>Thời Lượng</th>
                    <th>Mô Tả</th>
                    <th></th>
                    <th></th>
                    </thead>
                    <tbody>
                    <c:forEach items="${dsChuyenDe}" var="chuyende">
                    <tr>
                        <td>${chuyende.tenCD}</td>
                        <td><fmt:formatNumber value="${chuyende.hocPhi}" pattern="#,###"/> VND</td>
                        <td>${chuyende.thoiLuong} giờ</td>
                        <td>${chuyende.moTa}</td>
                        <td>
                            <form action="/ChuyenDe/edit" method="post">
                                <input type="hidden" value="${chuyende.id}" name="id">
                                <button class="btn btn-primary">Cập Nhật</button>
                            </form>
                        </td>
                        <c:if test="${sessionScope.sessionUser.vaiTro==1}">
                        <td>
                            <button class="btn btn-danger" data-toggle="modal" data-target="#b${chuyende.id}">Xóa</button>
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