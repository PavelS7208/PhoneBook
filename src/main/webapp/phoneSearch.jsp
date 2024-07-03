<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="ru.pavel.model.PhoneNumber" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>PhoneBook</title>
</head>

<body>
<%
    @SuppressWarnings("unchecked")
    List<PhoneNumber> phoneNumberList = (List<PhoneNumber>) request.getAttribute("phoneNumbers");
    String name = (String) request.getAttribute("searchName");
%>
<div class="container-sm">
    <div class="pb-4"></div>
    <div class="pb-4"></div>
    <nav class="navbar navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand">Записная книжка</a>
            <form action="close" class="d-flex" method="post">
                <button type="submit" class="btn-close" aria-label="Close"></button>
            </form>
        </div>
    </nav>



    <table class="table table-sm table-striped">
        <thead>
        <tr>
<%
    String title;
    if(phoneNumberList.isEmpty()) {
        title = "Для имени " + name + " нет номеров в записной книжке";
    } else {
        title = "Список номеров для записи с именем: " + name;
    }
%>
            <th scope="col"><%=title%></th>
            <!-- <th scope="col">Действия</th>  -->
        </tr>
        </thead>
        <tbody>
        <% for (PhoneNumber number : phoneNumberList) {%>
        <tr>
            <td><%= number.toString() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
