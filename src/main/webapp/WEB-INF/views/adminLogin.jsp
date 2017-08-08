<%@page session="false"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>GATI | Login</title>
	<c:url var="home" value="/" scope="request" />

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome/css/font-awesome.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/style.css" />"	rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div style="margin-top:50px;">
        	<img alt="Gati KWE Logo" class="img-responsive center-block logo" src="<c:url value="/resources/img/logo.png" />">
            <h2 style="margin-bottom:40px;" >Welcome to Gati KWE GA login</h2>
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    <p>Invalid username and password.</p>
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    <p>You have been logged out successfully.</p>
                </div>
            </c:if>
            <form class="m-t" role="form" method="post" action="${home}loginAdmin">
                <div class="form-group">
                    <input type="text" class="form-control" name="username" id="username" placeholder="Username" >
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" id="password"  placeholder="Password" >
                </div>
                <button type="submit" class="btn btn-info block full-width m-b">Login</button>

                <a href="#"><small>Forgot password?</small></a>
                <!-- <p class="text-muted text-center"><small>Do not have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a> -->
            </form>
            <p class="m-t" style="margin-top:30px;"> <strong>Copyright</strong> Gati KWE &copy; 2016-2017 </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="<c:url value="/resources/js/jquery-2.2.4.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
