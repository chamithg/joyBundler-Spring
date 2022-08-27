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
<h1><c:out value="${name.name}"/></h1>
<h3>(added by <c:out value="${name.getUser().name}"/>)</h3>
<h3>-------------------</h3>
<h3>Origin: <c:out value="${name.origin}"/></h3>
<h3>-------------------</h3>
<h3>Meaning: <c:out value="${name.meaning}"/></h3>
<h3>-------------------</h3>

<c:if test="${name.getUser().id == userId }">
<a href="/names/${name.id}/edit"> Edit Name</a>

</c:if>


</body>
</html>