<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改图书信息</title>
</head>
<body>
    <form action="/bookstore/updateBook" method="post">
        <input type="hidden" name="bookId" value="${book.bookId}">
        <input type="hidden" name="categoryId" value="${book.categoryId}">
        书&nbsp;&nbsp;名 <input type="text" name="bookName" value="${book.bookName}"><br>
        作&nbsp;&nbsp;者 <input type="text" name="author" value="${book.author}"><br>
        出版社&nbsp;<input type="text" name="publisher" value="${book.publisher}"><br>
        出版时间  <input type="text" name="publishTime" value="${book.publishTime}"><br>
        所属类别
        <select name="categoryName">
            <c:forEach items="${categories}" var="category">
                <option value="${category.categoryName}">${category.categoryName}</option>
            </c:forEach>
        </select>
        <br>
        价格&nbsp;&nbsp;<input type="text" name="price" value="${book.price}"><br>
        数量&nbsp;&nbsp;<input type="text" name="counts" value="${book.counts}"><br>
            <input type="submit" value="提交">
    </form>
    <a href="/bookstore/${book.bookId}/id/detail">放弃修改</a>
</body>
</html>
