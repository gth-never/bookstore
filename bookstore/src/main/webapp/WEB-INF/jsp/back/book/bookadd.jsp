<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 17-3-19
  Time: 下午6:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
    <form action="/bookstore/addBook" method="post">
        <input type="hidden" name="bookId" value="-1">
        <input type="hidden" name="categoryId" value="-1">
        书&nbsp;&nbsp;名 <input type="text" name="bookName"><br>
        作&nbsp;&nbsp;者 <input type="text" name="author"><br>
        出版社&nbsp;<input type="text" name="publisher"><br>
        出版时间  <input type="text" name="publishTime"><br>
        所属类别
        <select name="categoryName">
             <c:forEach items="${categories}" var="category">
                 <option value="${category.categoryName}">${category.categoryName}</option>
             </c:forEach>
        </select>
        <br>
        价格&nbsp;&nbsp;<input type="text" name="price"><br>
        数量&nbsp;&nbsp;<input type="text" name="counts"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
