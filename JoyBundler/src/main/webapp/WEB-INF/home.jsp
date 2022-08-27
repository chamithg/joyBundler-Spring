<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class= "m-5 p-5">
<h1>Hello <c:out value="${name}"/>,  Here are some name suggestions</h1>

<br/>
<a href="/process/logout">Log Out</a>
<br/>
<br/>

<h3>Baby Names</h3>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Gender</th>
      <th scope="col">Origin</th>
      <th scope="col">Votes</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${names}" var="name">
  <tr>
      <td><a href="names/${name.id }"><c:out value="${name.name}"/></a></td>
      <td><c:out value="${name.gender}"/></td>
      <td><c:out value="${name.origin}"/></td>
      <td>--</td>
    </tr>
  </c:forEach>
    <tr>
  </tbody>
</table>


<a href="/names/new"> Add Name</a>

</body>
</html>