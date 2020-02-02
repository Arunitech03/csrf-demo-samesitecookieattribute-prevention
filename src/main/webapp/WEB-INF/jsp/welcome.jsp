<html>

<head>
<title>VulnWeb</title>
</head>

<body>
	<p align="right"><a href="/logout">LOGOUT</a></p>
	<br><br><br><br><br><br><center>Welcome ${name}!!<br><br>
	<br>CSRF Demo<br>
	<a href="/getupdatefoiform">Click here</a> to update your Field of Interest in GET Form.
	&nbsp;&nbsp;
	<br><br>
	<a href="/postupdatefoiform">Click here</a> to update your Field of Interest in POST Form.
	<br><br>
	<a href="/viewfoi">Click here</a> to view the stored Field of Interest.
	<br><br><br><br>
	<br>XSS Demo <br>
	<a href="/sportsupdateform">Click here</a> to update your Favourite Sport.
	<br><br>
	<a href="/viewsports">Click here</a> to view the stored Favourite Sport.
	<br><br><br><br>
	<br>X-Frame-Options Demo<br><br>
	<a href="/Xframeoptions">X-Frame-Options Demo Page</a>.
	<br><br>
	<br><br><br><br>
	<br>CORS Demo<br><br>
	<a href="/cors">CORS Demo Page</a>.
	<br><br>
	
	<br><br><br><br>
	<br>CSP Demo<br><br>
	<a href="/csp">CORS Demo Page</a>.
	<br><br>
	</center>

</body>

</html>