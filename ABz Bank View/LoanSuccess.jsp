<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

      session = request.getSession();
      out.println("Dear,"+session.getAttribute("name")+ " thank you for Showing your interest on the  loans from ABzBank");
    		  
    		  out.println("</br>");
      out.println("Our  executive will conatact you soon on your email address mentioned below");	  
              out.println("</br>");
              
      out.println(session.getAttribute("email"));;
%>

</body>
</html>