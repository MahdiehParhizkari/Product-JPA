<%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 2/15/21
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<form action="/ProductAct" method="post">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="number" name="id"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Countryid_fk:</td>
            <td><input type="number" name="country"></td>
        </tr>
        <tr>
            <td>Count:</td>
            <td><input type="number" name="count"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <td>CreateDate:</td>
            <td><input type="date" name="date"></td>
        </tr>
    </table>
    <input type="submit" value="Add">
    <input type="hidden" name="crud" value="add">
    <input type="button" onclick="location.href='product.jsp'" value="Back">
</form>
</body>
</html>
