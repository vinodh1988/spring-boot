<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%-- <%@ taglib prefix="c"  uri="jakarta.tags.core"%> --%> 
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
       <%-- <ul>
        
          <c:forEach items="${team}" var="x">
              <li> ${x} </li>
          </c:forEach>
        </ul>
        --%>
        <ul>
        <%
          String[] team= (String[]) request.getAttribute("team");
          for(String x:team) {
        %>
          <li><%out.println(x); %> </li>
          <% 
          } 
          %>
          </ul>
          
          <h3>Counters</h3>
          <hr/>
          <% out.println("Number of requests this session: "+request.getAttribute("scount")); %>
          <br/>
          <% out.println("Number of requests to this app: "+request.getAttribute("acount")); %>
          
</body>
</html>