<html>
<head>
  <title>JSF 2.1</title>
</head>
<body>
  <form action="<%= request.getContextPath() %>/MyServlet" method="post">
  	A: <input type="text" name="a" />
  	B: <input type="text" name="b" />
  	<input type="submit" value="Push" />
  </form>
</body>
</html>