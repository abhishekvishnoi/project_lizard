<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css"
	href="../assets/wect/css/login_style.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/wect/css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/wect/css/bootstrap.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript" src="../assets/wect/js/bootstrap.js"></script>

<style type="text/css">
body {


	/* background: url(http://lorempixel.com/1920/1920/city/9/) no-repeat center transparent; */
		/* center center fixed; */
	/* -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover; */
}

.panel-default {
	opacity: 0.9;
	margin-top: 30px;
}

.form-group.last {
	margin-bottom: 0px;
}
</style>

<title>Register User</title>
</head>
<body>


<div class="container" style="width: 95%;">
		<div class="row">
			<div class="col-md-4 col-md-offset-7">
				<div class="panel panel-default">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-lock"></span> Register New User
					</div>
					<div class="panel-body">
					
					<div class="error">${userForm.error_message}</div>
						<form:form commandName="userForm" action="./RegisterUserSubmit.do"
							method="post" cssClass="form-horizontal">
							<span style="font-size: 14px; font-style: normal; ">  &nbsp;&nbsp; ${login_error}</span>
							<%-- <form class="form-horizontal" role="form"> --%>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 control-label">
									Name</label>
								<div class="col-sm-9">
									<form:input path="user_name" class="form-control"
										style="width:300px;" maxlength="256" placeholder="Email" />
									<!-- <input type="email" class="form-control" id="inputEmail3" placeholder="Email" required> -->
								</div>
							</div>
							
							
							
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 control-label">
									Email</label>
								<div class="col-sm-9">
									<form:input path="user_email" type="email" class="form-control"
										style="width:300px;" maxlength="256" placeholder="Email" />
									<!-- <input type="email" class="form-control" id="inputEmail3" placeholder="Email" required> -->
								</div>
							</div>
							<div class="form-group">
							
							
								<label for="inputPassword3" class="col-sm-3 control-label">
									Password</label>
								<div class="col-sm-9">
								<form:errors path="user_password" class="error"/>
									<form:input path="user_password" type="password"
										class="form-control" style="width:300px;" maxlength="256"
										placeholder="Password" />
									<!--  <input type="password" class="form-control" id="inputPassword3" placeholder="Password" required> -->
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">
									Confirm Password</label>
								<div class="col-sm-9">

									<form:input path="confirm_user_password" type="password"
										class="form-control" style="width:300px;" maxlength="256"
										placeholder="Password" />
									<!--  <input type="password" class="form-control" id="inputPassword3" placeholder="Password" required> -->
								</div>
							</div>
							
							<div class="form-group last">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-success btn-sm">
										Register User</button>
								
								</div>
							</div>
						</form:form>
					</div>
					
				</div>
			</div>
		</div>
	</div>






</body></html>