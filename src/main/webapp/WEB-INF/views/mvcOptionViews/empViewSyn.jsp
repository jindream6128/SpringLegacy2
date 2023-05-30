<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    //버튼을 눌렀을때 해당경로로 이동하도록
    $(function(){
        $('#subbtn').click(function (){
            $('#formdata').submit();
        })
    });
</script>
<div class="container">
    <h2>Contextual Classes</h2>
    <p>Contextual classes can be used to color the table, table rows or table cells. The classes that can be used are: .table-primary, .table-success, .table-info, .table-warning, .table-danger, .table-active, .table-secondary, .table-light and .table-dark:</p>

    <button type="button" id="subbtn" class="btn btn-success" >DELETE</button>
    <form action="${pageContext.request.contextPath}/deleteCheck" id="formdata" method="post">
        <table class="table">

            <thead>
            <tr>
                <th>NO</th>
                <th>EMPNO</th>
                <th>ENAME</th>
                <th>JOB</th>
                <th>MGR</th>
                <th>HIREDATE</th>
                <th>SAL</th>
                <th>COMM</th>
                <th>DEPTNO</th>
            </tr>
            </thead>
            <tbody>
            <!--     private int empno;
                private String ename;
                private String job;
                private int mgr;
                private String hiredate;
                private int sal;
                private int comm;
                private int deptno; -->
            <c:forEach var="i" items="${empList}" varStatus="cnt">
                <c:choose>
                    <c:when test="${cnt.count mod 2 eq 0 }">
                        <tr class="table-primary">
                    </c:when>
                    <c:otherwise>
                        <tr class="table-success">
                    </c:otherwise>
                </c:choose>
                <td><input type="checkbox" name="empnoCh" value="${i.EMPNO}">
                ${cnt.count}</td>
                <td>${i.EMPNO}</td>
                <td>${i.ENAME}</td>
                <td>${i.JOB}</td>
                <td>${i.MGR}</td>
                <td>${i.HIREDATE}</td>
                <td>${i.SAL}</td>
                <td>${i.COMM}</td>
                <td>${i.DEPTNO}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>


</body>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
</html>


</body>
</html>