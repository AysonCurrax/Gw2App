<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#button').click(function() {
	    var text = $('#text').val();
	      $.ajax({ 
	        type: "POST", 
	        url: "/gw2app/api/v1/jspTest", 
	        data: { "text" : text },
	        success: function(response){ 
	          // we have the response 
	          $('#info').html(response);
	          var table = document.getElementById("dataTable");
	          var i = table.rows.length;
	          var row = table.insertRow(i);
	          var cell = row.insertCell(0);
	          cell.innerHTML = text;
	          $('#text').val('');
	          
	          
	        }, 
	        error: function(e){ 
	          alert('Error: ' + e); 
	        } 
	      });
	});
});
</script>
</head>
<body>
	<div id="info">${infoText}</div>
	<div id="stuff">
	<input type="text" id="text">
	<input type="button" id="button" value="Test Post">
	<table id="dataTable" border="1">
	<tr>
		<th>Text</th>	
	</tr>
	<c:forEach var="data" items="${dataList}">
		<tr>
			<td>${data.text}</td>
		</tr>
	</c:forEach>
	</table>
	</div>
</body>
</html>