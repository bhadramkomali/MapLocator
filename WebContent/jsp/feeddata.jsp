<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/feeddata.css"/>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>::.Feed-Data.::</title>
</head>
<body>
	<span class="aligncenter">${msg}</span>
	<a href="home.jsp">Back</a>
	<h2 align="center">Feed the data for the map locations</h2>
	<form action="../feeddata.do" name="feeddataform" method="post">
	<table align="center">
		<tr>
			<td class="alnright">AreaName:</td>
			<td>
				<select name="area" id="area">
					<option>--select--</option>
					<option>Madhapur</option>
					<option>S.R.Nagar</option>
					<option>Ameerpet</option>
					<option>Jubilee Hills</option>
					<option>Banjara Hills</option>
					<option>Abids</option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="alnright">Hostel Name:</td>
			<td><input type="text" name="hostelname" id="hostelname"/></td>
		</tr>
		<tr>
			<td class="alnright">Hostel Address:</td>
			<td><textarea rows="10" cols="19" name="address" id="address"></textarea></td>
		</tr>
		<tr>
			<td class="alnright">Hostel Contact:</td>
			<td><input type="text" name="phoneno" id="phoneno"/></td>
		</tr>
		<tr>
			<td class="alnright">Owner Name:</td>
			<td><input type="text" name="ownername" id="ownername"/></td>
		</tr>
		<tr>
			<td class="alnright">Hostel Fee:</td>
			<td><input type="text" name="hostelfee" id="hostelfee"/></td>
		</tr>
		<tr>
			<td class="alnright"><input type="submit" name="Feed"></td>
			<td><input type="reset" name="Cancel" /></td>
		</tr>
	</table>
	</form>
</body>
</html>