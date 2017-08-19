<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<%-- <c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" /> --%>

</head>
<body>
		<div class="container">

<jsp:include page="header.jsp"></jsp:include>
<div class="col-sm-10">
<form class="form-horizontal" method="post" name="event" id="event" action="/api/event/" enctype="application/x-www-form-urlencoded">
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Event Name </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" id="name" placeholder="Name of the event">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="description">Event Description </label>
    <div class="col-sm-10"> 
		  <textarea class="form-control" rows="5" id="description" name="description" placeholder="Detailed description of the event &lt Min 50 characters &gt"></textarea>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="location">Event Location</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="location" id="location" placeholder="Location of the event">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="date">Event Date</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" name="date" id="date" placeholder="Date of the event">
    </div>
  </div>

  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label><input type="checkbox" name="isDeal" id="isDeal"> Deals</label>
      </div>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Create Event</button>
    </div>
  </div>
</form>
</div>
</div>
</body>


	<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<script type="text/javascript">

$(function() {
	
	$("#event").validate({
	    // Specify validation rules
	    rules: {
	     
	    	name: {
		        required: true,
		        minlength: 3
		      },
		      description: {
		        required: true,
		        minlength: 50
		      },
		      location:"required",
		      date:{
	          required: true,
	          date: true
	        },
	    },
	    // Specify validation error messages
	    messages: {
	    	name: "Event name is required",
	    	description: "Event description is required and needs at least 50 charactes",
	    	location: "Event location is required",
	    	date:"Event date is required"
	    },
	    // Make sure the form is submitted to the destination defined
	    // in the "action" attribute of the form when valid
	    submitHandler: function(form) {
	      form.submit();
	    }
	  });
	
	
	
	
});

</script>

</html>