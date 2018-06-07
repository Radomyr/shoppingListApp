<%--
  Created by IntelliJ IDEA.
  User: Radomyr
  Date: 06.06.2018
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome to on-line shop</title>
</head>
<body>
<h1>To jest sklep on-line</h1>
<h1>Wprowadź nazwy oraz cene produktów które chcesz kupić:</h1>
<form method="post" action="/shop" >
  <input type="text" name="firstProductName">
  <input type="number" name="firstPrice"><br>
  <input type="text" name="secondProductName">
  <input type="number" name="secondPrice"><br>
  <input type="text" name="thirdProductName">
  <input type="number" name="thirdPrice"><br>
  <input type="text" name="fourthProductName">
  <input type="number" name="fourthPrice"><br>
  <input type="submit" value="kup">
</form>
</body>
</html>