<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>::.Map-Locator.::</title>
<link type="text/css" rel="stylesheet" href="../css/viewinmap.css" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="../js/viewinmap.js"></script>
</head>
<body>
	<div id="aligncenter">
		<a href="home.jsp">Back</a><br>
		<form action="#" method="get" id="viewinmapform">
			Address: 
			<select id="area" name="area">
				<option>--select--</option>
				<option>Madhapur</option>
				<option>S.R.Nagar</option>
				<option>Ameerpet</option>
				<option>Jubilee Hills</option>
				<option>Banjara Hills</option>
				<option>Abids</option>
			</select>
			<br>
			<div id="map" style="width: 800px; height: 800px;"></div>
		</form>
	</div>
</body>
</html>