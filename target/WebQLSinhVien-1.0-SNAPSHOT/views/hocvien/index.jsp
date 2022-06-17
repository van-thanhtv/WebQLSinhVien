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
                <c:if test="${empty dsHocVien}">
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
                    <th>Mã Học Viên</th>
                    <th>Mã Người Học</th>
                    <th>Họ Và Tên </th>
                    <th>Điểm</th>
                    <th></th>
                    <th></th>
                    </thead>
                    <tbody>
                    <c:forEach items="${dsHocVien}" var="hv" varStatus="status">
                    <tr>
                        <td>#${status.count}</td>
                        <td>HV${hv.id}</td>
                        <td>NH${hv.idNH.id}</td>
                        <td>${hv.idNH.hoTen}</td>
                        <c:if test="${hv.diem !=null}">
                        <td style="color: red">${hv.diem}</td>
                        </c:if>
                        <c:if test="${hv.diem ==null}">
                            <td style="color: red">Chưa Cập Nhật</td>
                        </c:if>
                        <td>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#hvdiem${hv.id}">Cập Nhật Điểm</button>
                        </td>
                        <c:if test="${sessionScope.sessionUser.vaiTro==1}">
                        <td>
                            <button class="btn btn-danger" data-toggle="modal" data-target="#hv${hv.id}">Xóa</button>
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