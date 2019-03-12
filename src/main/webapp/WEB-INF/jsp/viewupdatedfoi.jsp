<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.util.Properties" %>

<!DOCTYPE html>
<html>

<head>
<title>FOI Display</title>
</head>

<body>
	<br><h2>Field of Interest Display Page</h2>
	<BR/>
	  <%
	  {
    FileReader reader=new FileReader("D:\\NewWorkplace\\Projects\\TodoApp\\src\\main\\resources\\FOI.properties");
    Properties p=new Properties();
    p.load(reader); %>
    The Stored Field of Interest is  <b><% out.println(p.getProperty("FOI")); 
    }
    %></b>
	</body>

</html>