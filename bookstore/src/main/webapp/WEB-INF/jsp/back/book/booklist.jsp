<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 17-3-19
  Time: 下午5:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书列表</title>
    <script>
        function tiaozhuan()
        {
            var currentPage=document.getElementById("currentPage").value;
            document.getElementById("tiaozhuan").setAttribute("href","/bookstore/surePage/"+currentPage);
        }
    </script>
</head>
<body>
    <table style="width: 400px">
        <thead>
            <tr>
                <td>书名</td>
                <td>作者</td>
            </tr>
        </thead>
        <tbody>
                <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.bookName}</td>
                    <td>${book.author}</td>
                    <td><a href="/bookstore/${book.bookId}/id/detail">详情</a></td>
                </tr>
                </c:forEach>
        </tbody>
    </table>
    <br><br><br>
    <a href="/bookstore/addView">添加图书</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="#">${page.currentPage}/${page.totalPage}</a>&nbsp;&nbsp;
    <c:if test="${page.currentPage>1}"><a href="/bookstore/prePage">上一页</a>&nbsp;&nbsp;</c:if>
    <c:if test="${page.currentPage<page.totalPage}"><a href="/bookstore/nextPage">下一页</a>&nbsp;&nbsp;</c:if>
    <input type="text" id="currentPage" style="width: 50px" value="${page.currentPage}"><a href="/bookstore/2/surePage" onclick="tiaozhuan()" id="tiaozhuan">跳转</a>
</body>
</html>
