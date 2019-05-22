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
						<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.css" rel="stylesheet">
<link href="../assets/dist/css/style.css" rel="stylesheet">
<link href="../assets/dist/css/sticky-footer-navbar.css" rel="stylesheet">
<!-- <link href="../assets/dist/css/sticky-footer.css" rel="stylesheet"> -->
<title>| LiZaRd | <decorator:title default="" /></title>

<!-- <link rel="stylesheet" type="text/css" href="assets/css/styles.css"> -->

<decorator:head />
</head>

<body>

	<%@ include file="/WEB-INF/views/header.jsp"%>
	<%@ include file="/WEB-INF/views/navigationLeft.jsp"%>
	<decorator:body />
	<%@ include file="/WEB-INF/views/footer.jsp"%>

</body>
</html>