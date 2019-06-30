<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Dashboard</title>
<style type="text/css">
   	table, td, th {  
  		border: 1px solid #ddd;
  		text-align: left;
	}

	table {
  		border-collapse: collapse;
  		width: 100%;
	}

	th, td {
  		padding: 15px;
  		text-align: center;
	}
	
	div {
		text-align: center;
		font-family: "Times New Roman", Times, serif;
	}
	
	h2 {
		text-align: center;
		color: white;
		font-family: "Times New Roman", Times, serif;
	}
	
	body {
		background: linear-gradient(to top, #808080 0%, #3fada8 100%);
	}
	
	html {
		height: 100%;
	}
	
	input[type=text], select {
  		width: 30%;
  		padding: 12px 20px;
  		margin: 8px 0;
  		display: inline-block;
  		border: 1px solid #ccc;
  		border-radius: 4px;
  		box-sizing: border-box;
	}
	
	input[type=submit] {
  		width: 15%;
  		background-color: #4CAF50;
  		color: white;
  		padding: 14px 20px;
  		margin: 8px 0;
  		border: none;
  		border-radius: 4px;
  		cursor: pointer;
	}

	input[type=submit]:hover {
  		background-color: #45a049;
	}
</style>
</head>
<body>
<h2>Welcome, ${customerName}</h2>
<div><b> Accounts for ${customerName} </b></div>
<br>
<table>
	<tr>
		<th>Amount</th>
		<th>Account Type</th>
		<th>Deposit</th>
		<th>Withdraw</th>
	</tr>
<c:forEach items="${accData}" var="acc" varStatus="loopStatus">
	<tr>
		<td>${acc.balance}</td>
		<td>${acc.accType}</td>
		<td>
			<form method="POST" action="/deposit">
    			<label for="deposit">Deposit Amt: </label>
    			<input type="text" id="deposit" name="dep" placeholder="Amount">
    			<input type="hidden" id="custId" name="custId" value="${customerName}">
    			<input type="submit" value="Add!">
    		</form>
		</td>
		<td>
			<form method="POST" action="/withdraw">
    			<label for="withdraw">Withdraw Amt: </label>
    			<input type="text" id="withdraw" name="wit" placeholder="Amount">
    			<input type="hidden" id="custId" name="custId" value="${customerName}">
    			<input type="submit" value="Subtract!">
    		</form>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>