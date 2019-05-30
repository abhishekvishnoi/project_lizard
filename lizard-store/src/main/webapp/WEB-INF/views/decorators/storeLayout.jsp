<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
    prefix="decorator"%>
 
<%@page contentType="text/html; charset=UTF-8"%>
 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
 
<head>
<%@ page session="true"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Abhishek Vishnoi">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">
 
 
<link href="./assets/dist/css/style.css" rel="stylesheet">
<link href="./assets/dist/css/bootstrap-theme.css" rel="stylesheet">
<!-- <link href="./assets/dist/css/sticky-footer-navbar.css" rel="stylesheet">
<link href="./assets/dist/css/sticky-footer.css" rel="stylesheet"> -->

<link href="./assets/dist/css/bootstrap.css" rel="stylesheet">
<link href="./assets/dist/css/jumbotron.css" rel="stylesheet">
<link href="./assets/dist/css/carousel.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="./assets/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./assets/dist/js/pager.js"></script>
<script type="text/javascript" src="./assets/dist/js/holder.js"></script> 

<!-- <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="./assets/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./assets/dist/js/holder.js"></script>

<link href="./assets/dist/css/bootstrap.css" rel="stylesheet">
<link href="./assets/dist/css/carousel.css" rel="stylesheet"> -->
	

 
<title>http://springMVC.wect.com | <decorator:title
    default="Sitemesh Example" /></title>
 
<!-- <link rel="stylesheet" type="text/css" href="assets/css/styles.css"> -->
 
<decorator:head />
 
</head>
 
<body>
<!-- <table class="mainTable" id="page-container" cellpadding="5" cellspacing="0" border="1"
    align="center"> -->
  <%@ include
            file="/WEB-INF/views/header.jsp"%>  
    
  
       <%-- <%@ include
            file="/WEB-INF/pages/navigationLeft.jsp"%> --%>
           
           <%--  <%@ include
            file="/WEB-INF/decorators/carousal.jsp"%> --%>
        <decorator:body />
    
        <%@ include
            file="/WEB-INF/views/decorators/footer_store.jsp"%>
   

</body>
</html>