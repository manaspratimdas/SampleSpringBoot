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
	<div class="panel-group">
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" href="#collapse1">Collapsible panel</a>
      </h4>
    </div>
    <div id="collapse1" class="panel-collapse collapse">
      <div class="panel-body">Panel Body</div>
      <div class="panel-footer">Panel Footer</div>
    </div>
  </div>
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