$(document).ready(function() {
	console.log("Inside document.ready function");
	$("select").change(function(){
		var getting = $.get("../viewinmap.do" , {s : $("select option:selected").val()});
		getting.done(function(records) {
			if(!jQuery.isEmptyObject(records)) {
				var locations = [];
				var parsedData = JSON.parse(records);
				for(var index in parsedData) {
					var hostel = [];
					hostel.push(parsedData[index].hostelName);
					hostel.push(parsedData[index].hostelFee);
					hostel.push(parsedData[index].hostelLat);
					hostel.push(parsedData[index].hostelLong);
					hostel.push(parsedData[index].hostelAddress);
					locations.push(hostel);
				}
				console.log(locations);
				var geocoder = new google.maps.Geocoder();
				var map = new google.maps.Map(document.getElementById('map'), {
			          zoom: 16,
			          center: new google.maps.LatLng(17.443650, 78.445826),
			          mapTypeId: google.maps.MapTypeId.ROADMAP
			     });
				var address = $("select option:selected").val();
				geocoder.geocode(
				   {'address': address},
				   function(results, status) {
				      if(status == google.maps.GeocoderStatus.OK) {
				    	  map.setCenter(results[0].geometry.location);
				      }
				});
		        var infowindow = new google.maps.InfoWindow();
		        var marker, i;
		        for (i = 0; i < locations.length; i++) {
		            marker = new google.maps.Marker({
		            position: new google.maps.LatLng(locations[i][2], locations[i][3]),
		            icon: "../images/indicator.png",
		            map: map
		          });
		          google.maps.event.addListener(marker, 'click', (function(marker, i) {
		            return function() {
		              infowindow.setContent(locations[i][0].concat(locations[i][1]));
		              infowindow.open(map, marker);
		            }
		          })(marker, i));
		        }
			}
		});
	});
});