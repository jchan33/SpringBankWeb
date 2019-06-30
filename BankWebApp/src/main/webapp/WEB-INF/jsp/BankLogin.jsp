<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<style>

html { 
	height: 100%;
}

body {
	height: 100%;
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background: linear-gradient(to top, #bdc3c7 0%, #2c3e50 100%);
	background-repeat: no-repeat;
	background-attachment: fixed;
}

input[type=text], input[type=password] {
  width: 20%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 20%;
}

.container {
  padding: 16px;
}

div {
	text-align: center;
}

#rightfloat {
	text-align: center;
}

#leftfloat {
	text-align: center;
}

</style>
<body>
	<div><h1>Welcome to Login Page</h1></div>
	<b></b>

	<form method="post" action="/login">
  		<div class="container">
  			<label for="firstName"><b>Username</b></label>
  			<div>
    			<input id="firstName" type="text" placeholder="Enter Username" name="username" required>
			</div>
			<label for="lastName"><b>Password</b></label>
			<div>
    			<input id="lastName" type="password" placeholder="Enter Password" name="password" required>
        	</div>
        	<div>
    		<input type="submit" id="submit" name = "submit" value="Login" />
    		</div>
  		</div>
  	</form>
</body>