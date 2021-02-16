<%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 2/15/21
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="/ProductAct" method="post">
    <table>
        <tr>
            <td><input type="hidden" value="${requestScope.pro.id}" name="id"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" value="${requestScope.pro.name}" name="name"></td>
        </tr>
        <tr>
            <td>Countryid_fk:</td>
            <td><input type="number" value="${requestScope.pro.countryid_fk}" name="country"></td>
        </tr>
        <tr>
            <td>Count:</td>
            <td><input type="number" value="${requestScope.pro.count}" name="count"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" value="${requestScope.pro.price}" name="price"></td>
        </tr>
        <tr>
            <td>CreateDate:</td>
            <td><input type="date" value="${requestScope.pro.createdate}" name="date"></td>
        </tr>
    </table>
    <input type="submit" value="Update">
    <input type="hidden" name="crud" value="update">
    <input type="button" onclick="location.href='product.jsp'" value="Back">
</form>
</body>
</html>
