<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../resources/style.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
        <h1>  First Spring boot VIEW PAGE using JSP</h1>
        <h3>Team</h3>
        <hr/>
        <ul>
          <c:forEach items="${team}" var="x">
              <li> ${x} </li>
          </c:forEach>
        </ul>
</body>
</html>