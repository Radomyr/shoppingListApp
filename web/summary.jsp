<%@ page import="pl.javastart.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Radomyr
  Date: 07.06.2018
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Podsumowanie</title>
</head>
<body>
<h1>Podsumowanie zakupów:</h1>
<table>
    <% Object list = request.getAttribute("listOfProducts");
     Object totalPrice = request.getAttribute("totalPrice");
     Object medianPrice = request.getAttribute("medianPrice");
        List<Product> listOfProducts = (List<Product>) list;
        for (int i=0;i<listOfProducts.size();i++){%>
            <tr>
                <td>
                    <%=listOfProducts.get(i).getName()%>
                </td>
                <td>
                    <%=listOfProducts.get(i).getPrice()%>
                </td>
            </tr>
    <%}
    %>
</table>
<h1>Suma: <%out.print(totalPrice);%> zł</h1>
<h1>Średnia cena produktu: <%out.print(medianPrice);%> zł</h1>
<a href="index.jsp">zrób nowe zakupy</a>
</body>
</html>
