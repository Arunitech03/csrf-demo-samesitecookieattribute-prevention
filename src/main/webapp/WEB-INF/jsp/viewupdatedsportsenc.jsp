<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.File" %>

<!DOCTYPE html>
<html>

<head>
<title>FOI Display</title>
</head>

<body>
	<p align="right"><a href="/logout">LOGOUT</a></p>
	<center><br><h2>Favourite Display Page</h2>
	<BR/>
	<form name='form1'>
	The Stored Favourite Sport is
	<p id="sportsvalue"></p>
	  <%
	  {
		String basePath = new File("").getAbsolutePath();
		System.out.println(basePath);

		String path = new File("src/main/resources/FOI.properties")
		                                                           .getAbsolutePath();
		System.out.println(path);
    	FileReader reader=new FileReader(path);
   	 	Properties p=new Properties();
    	p.load(reader);
    	String spvalue=p.getProperty("sports");
    	%>
    	<input type='hidden' name='sports' value="<%=spvalue%>" />
    	<script>
    	function loadsports(){
    	var formsports=document.form1.sports.value;
    	return formsports;
    	}
    	<%--The Stored Favourite Sport is  <b><% out.println(p.getProperty("sports"));  --%>
    	document.getElementById("sportsvalue").innerHTML = encodeURI(loadsports());
    	</script>
    <%}%>
    </b>
    
    <br><br><br>
    <a href="/index">Index Page</a> </center>
	</body>

</html>