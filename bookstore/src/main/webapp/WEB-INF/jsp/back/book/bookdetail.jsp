<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 17-3-12
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台图书详情页</title>
</head>
<body>
    <table style="width: 800px">
        <thead>
            <tr>
                <td>书名</td>
                <td>作者</td>
                <td>出版社</td>
                <td>出版时间</td>
                <td>所属类别</td>
                <td>售价</td>
                <td>数量</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${book.bookName}</td>
                <td>${book.author}</td>
                <td>${book.publisher}</td>
                <td>${book.publishTime}</td>
                <td>${book.categoryName}</td>
                <td>${book.price}</td>
                <td>${book.counts}</td>
            </tr>
        </tbody>
    </table>
    <a href="/bookstore/${book.bookId}/updateView">去修改</a>
    <a href="/bookstore/${book.bookId}/delete">删除</a>
    <a href="/bookstore/index">首页</a>
</body>
</html>
