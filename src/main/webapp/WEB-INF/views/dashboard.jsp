<%@page isELIgnored="false"%>
<%@page session="true"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Form</title>
<c:url var="home" value="/" scope="request" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome/css/font-awesome.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jquery-ui.min.css" />"	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<style type="text/css">
.success_header {
	border-radius: 3px;
	background-color: #00bcd4;
	color: #ffffff;
}

.error_header {
	border-radius: 3px;
	background-color: #f55145;
	color: #ffffff;
}
</style>
</head>

<body class="md-skin">
	<div id="wrapper">
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav metismenu" id="side-menu">
					<li class="nav-header"><img alt="Gati KWE Logo"
						class="img-responsive center-block logo"
						src="<c:url value="/resources/img/logo.png" />" />
						<div class="dropdown profile-element m-t-md">
							<span> <img alt="image" class="img-circle center-block"
								src="<c:url value="/resources/img/a6.jpg" />" />
							</span> <a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<span class="clear text-grey text-center"> <span
									class="block m-t-xs"> <strong class="font-bold">${user.cusName!=null ? user.cusName : 'Guset User'}</strong>
								</span> <span class="text-light text-xs block">Designation <b
										class="caret"></b></span>
							</span>
							</a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">
								<li><a href="#">Profile</a></li>
								<li><a href="#">Contacts</a></li>
								<li class="divider"></li>
								<li><a href="<c:url value="/user_logout" />">Logout</a></li>
							</ul>
						</div>
						<div class="logo-element"></div></li>
					<li class="active"><a href="${home}dashboard"><i class="fa fa-th-large fa-fw"></i> <span 
							class="nav-label">Dashboard</span></a></li>
					<li><a href="${home}user/pickuprequest"><i class="fa fa-edit fa-fw"></i> <span
							class="nav-label">Pickup Request Details</span></a></li>
					<li><a href="${home}user/docketprint"><i class="fa fa-print fa-fw"></i> <span
							class="nav-label">Docket Print</span></a></li>
					<li><a href="${home}user/lableprint"><i class="fa fa-print fa-fw"></i> <span
							class="nav-label">Lable Print</span></a></li>
				</ul>

			</div>
		</nav>

		<div id="page-wrapper" class="gray-bg">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top  " role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a
							class="navbar-minimalize minimalize-styl-2 btn text-white btn-link "
							href="#"><i class="fa fa-bars"></i> </a>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li><span class="m-r-sm text-white welcome-message"><i
								class="fa fa-phone"></i> 1800-180-4284</span></li>
						<c:choose>
						<c:when test="${user.cusName!=null}">
							<li><a class="text-white" href="<c:url value="/user_logout" />"><i
								class="fa fa-power-off"></i>Logout</a></li>
						</c:when>    
    					<c:otherwise>
							<li><a href="<c:url value="/login" />" class="text-white"> <i
								class="fa fa-power-off"></i> Log in</a></li>
						</c:otherwise>
						</c:choose>
					</ul>
				</nav>
			</div>
			<div class="wrapper wrapper-content">
				<div class="row">
					<div class="col-sm-12">
						
					</div>
				</div>
				<!-- row -->
			</div>
			<div class="footer">
				<div class="pull-right">
					10GB of <strong>250GB</strong> Free.
				</div>
				<div>
					<strong>Copyright</strong> Gati KWE &copy; 2016-2017
				</div>
			</div>
		</div>
	</div>
	<!-- Mainly scripts -->
	<script src="<c:url value="/resources/js/jquery-2.2.4.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.bootstrap.js"/>"></script>
	<script	src="<c:url value="/resources/js/metisMenu/jquery.metisMenu.js"/>"></script>
	<script	src="<c:url value="/resources/js/slimscroll/jquery.slimscroll.min.js"/>"></script>
	<script>
		var serverContext = "${home}";
	</script>
	<!-- Custom and plugin javascript -->
	<script src="<c:url value="/resources/js/inspinia.js"/>"></script>
	<script src="<c:url value="/resources/js/pace/pace.min.js"/>" type="text/javascript"></script>	
</body>
</html>

