<html>

<head>
<title>VulnWeb</title>
<style>
body{
margin: 0;
padding: 0;
background: beige;
}
.container {
margin: 0 auto;
 max-width: 960px;
 width: 100%;
}

.logout-link {
	float: right;
}

.content {
	clear: both;
	
}

.content ul {
	list-style: none;
}

.content ul li {
	margin-bottom: 15px;
}

 .center {
 	text-align: center;
 }
</style>
</head>

<body>
	<div class="container">
		<p class="logout-link"><a href="/logout">LOGOUT</a></p>
		<div class="content">
			<h2 class="center">Welcome!!</h2>
			
			<h3>CSRF Demo</h3>
			<ul>
				<li>
					<a href="/getupdatefoiform">Click here</a> to update your Field of Interest in GET Form.
				</li>
				<li>
					<a href="/postupdatefoiform">Click here</a> to update your Field of Interest in POST Form.
				</li>
				<li>
					<a href="/viewfoi">Click here</a> to view the stored Field of Interest.
				</li>				
			</ul>
			
			<h3>XSS Demo</h3>
			<ul>
				<li>
					<a href="/sportsupdateform">Click here</a> to update your Favourite Sport.
				</li>
				<li>
					<a href="/viewsports">Click here</a> to view the stored Favourite Sport.
				</li>
				<li>
					<a href="/viewsportsencoded">Click here</a> to view the Encoded Favourite Sport.
				</li>			
			</ul>
			<h3>X-Frame-Options Demo</h3>
			<ul>
				<li>
					<a href="/Xframeoptions">X-Frame-Options Demo Page</a>
				</li>						
			</ul>
			<h3>CORS Demo</h3>
			<ul>
				<li>
					<a href="/cors">CORS Demo Page</a>
				</li>						
			</ul>
			<h3>CSP Demo</h3>
			<ul>
				<li>
					<a href="/csp">CSP Demo Page</a>.
				</li>						
			</ul>
		</div>	
		
	</div>


<!--
	<p align="right"><a href="/logout">LOGOUT</a></p>
	<br><br><br><br><br><br><center>Welcome!!<br><br>
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
 -->
</body>

</html>