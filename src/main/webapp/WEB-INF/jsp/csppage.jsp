<!DOCTYPE html>
<html>
<head>
<title>VulnWeb</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("button").click(function(){
    $("p").hide();
  });
});
</script>
</head>
<body>
<center>
<br><br><br><br><br><br>Welcome to Content Security Policy Demo<br><br>
<h2>This is a heading</h2>

<p>This is a paragraph.</p>
<p>This is another paragraph.</p>

<button>Click me to hide paragraphs</button>
</center>
</body>
</html>
