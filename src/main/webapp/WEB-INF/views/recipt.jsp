<%@page session="true"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form</title>
<c:url var="home" value="/" scope="request" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/css/font-awesome/css/font-awesome.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/animate.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/jquery-ui.min.css" />"
	rel="stylesheet" type="text/css" />
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
@media print {
    .withoutprint{
        display: none;
    }
    .printonly{
        display:block;
        color: red;
    }
</style>
      <style>      	 
         .tdess {
         font-size: 10px; font-family: Arial, Helvetica, sans-serif; color: #000000
         }
         .td1 {
         font-size: 10px; border-top: #000000 1px solid; font-family: Arial, Helvetica, sans-serif; border-right: #000000 1px solid; border-bottom: #000000 1px solid; color: #000000; border-left: #000000 1px solid
         }
         .tdnew1 {
         font-size: 8px; font-family: Arial, Helvetica, sans-serif; font-weight: bold; color: #000000
         }
         .td_span {
         font-size: 5px; font-family: Arial, Helvetica, sans-serif
         }
         .td32 {
         border-top: #000000 1px solid; font-family: Arial, Helvetica, sans-serif; border-right: #000000 1px solid; border-bottom: #000000 1px solid; color: #000000; border-left: #000000 1px solid
         }
         .head {
         font-size: 11px; font-family: Arial, Helvetica, sans-serif; font-weight: bold; color: #000000
         }
         .td2 {
         font-size: 15px; font-family: Arial, Helvetica, sans-serif; font-weight: bold; color: #000000
         }
         .td3 {
         font-size: 8px; border-top: #000000 1px solid; font-family: Arial, Helvetica, sans-serif; border-right: #000000 1px solid; border-bottom: #000000 1px solid; font-weight: bold; color: #000000; border-left: #000000 1px solid
         }
         .td4 {
         font-size: 12px; font-family: Arial, Helvetica, sans-serif; font-weight: bold; color: #ffffff; background-color: #000000
         }
         .codeSnippet {
         border-top: #000000 1px dashed; border-right: #000000 1px dashed; border-bottom: #000000 1px dashed; border-left: #000000 1px dashed
         }
         P.breakhere {
         PAGE-BREAK-AFTER: always
         }
         hr.m5{
    		margin-top: 10px;
    		margin-bottom: 10px;
    		}

      </style>
      <style type="text/css" media="screen,print">
         @font-face {
         font-family: MyCustomFont;
         src: url(/Gati/resources/fonts/IDAutomationHC39MBarcode.eot);
         }
         @font-face {
         font-family: MyCustomFont;
         src: url(/Gati/resources/fonts/IDAutomationHC39MBarcode.ttf);
         }
         .barcode {
         font-size: medium; font-family: MyCustomFont, Verdana, Arial, sans-serif; color: black
         }
      </style>
      <script>function click(e){if(document.all){if(event.button == 2){alert('sorry');return false;}}if (document.layers){if(e.which == 3){alert(message);return false;}}}if (document.layers){document.captureEvents(Event.MOUSEDOWN);}document.onmousedown=click;</script>
      <meta name="GENERATOR" content="MSHTML 11.00.9600.18698">
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
					<li><a href="${home}dashboard"><i
							class="fa fa-th-large fa-fw"></i> <span class="nav-label">Dashboard</span></a></li>
					<li><a href="${home}user/pickuprequest"><i
							class="fa fa-edit fa-fw"></i> <span class="nav-label">Pickup
								Request Details</span></a></li>
					<li class="active"><a href="${home}user/docketprint"><i
							class="fa fa-print fa-fw"></i> <span class="nav-label">Docket
								Print</span></a></li>
					<li><a href="${home}user/lableprint"><i
							class="fa fa-print fa-fw"></i> <span class="nav-label">Lable
								Print</span></a></li>
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
						<li><a class="text-white"
							href="<c:url value="/user_logout" />"><i
								class="fa fa-power-off"></i>Logout</a></li>
					</ul>
				</nav>
			</div>
			<div class="wrapper wrapper-content">
				<div class="row">
					<div class="col-sm-12">
						<table class="td1" height="315" cellspacing="0" cellpadding="0" width="668" align="center">
         <tbody>
            <tr>
               <td height="315" valign="top" width="255">
                  <table height="100%" cellspacing="0" cellpadding="0" width="254">
                     <tbody>
                        <tr>
                           <td class="td1" height="34" valign="top" colspan="2" align="left">&nbsp;You 
                              can track Your shipments at<br>&nbsp;www.gatikwe.com.You can also 
                              reach us<br>&nbsp;at TOLL FREE NO 1800-180-4284
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="94" valign="top" colspan="2">
                           <span class="head">&nbsp;Shipper Address &emsp;&emsp;Code:</span>${pickupDetails.shipper_code}
	                          <br/>&nbsp;${pickupDetails.shipper_address1}, ${pickupDetails.shipper_address2}
		                      <br/>&nbsp;${pickupDetails.shipper_address3}, ${pickupDetails.shipper_address4}
		                      <br/>&nbsp;${pickupDetails.shipper_city}-${pickupDetails.shipper_pincode},
		                      <br/>&nbsp;PH:${pickupDetails.shipper_phone}, EMAIL: ${pickupDetails.shipper_email}
		                      <br/>
                              <br>&nbsp;Policy No: 
                              <br>&nbsp;GSTIN No: ${pickupDetails.shipper_tin}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="16" colspan="2">
                           	<span class="head">&nbsp;Pkg Nos : </span> ${pickupDetails.package_number_from} - ${pickupDetails.package_number_to}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Ref No : </span> 0
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Contains : </span> ${pickupDetails.goods_desc} 
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;FOD Amount :</span> ${pickupDetails.cod_dod_amount}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="20">
                           	<span class="head">&nbsp;Basis : </span>
                           	<c:choose>
                           		<c:when test="${pickupDetails.booking_basis=='1'}">PAID</c:when>
                           		<c:when test="${pickupDetails.booking_basis=='2'}">TBB</c:when>
                           		<c:when test="${pickupDetails.booking_basis=='4'}">FOD</c:when>
                           		<c:when test="${pickupDetails.booking_basis=='6'}">BOD</c:when>                           		
                           	</c:choose>
                           	
                           </td>
                           <td class="td1" valign="top" width="130">
                           	<span class="head">&nbsp;No. of Pkgs : </span> ${pickupDetails.no_of_packages}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="23">
                           	<span class="head">&nbsp;COD : </span>${pickupDetails.cod_flag} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;COD in Fav : </span> ${pickupDetails.cod_dod_in_favor=="G"?"Gati":"Shipper"}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="24">
                           	<span class="head">&nbsp;ACT Wt(Kgs): </span> ${pickupDetails.actual_weight} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;Wt(Kgs): </span> ${pickupDetails.actual_weight}
                           	</td>
                        </tr>
                        <tr>
                           <td class="td1" height="22" width="122">
                           	<span class="head">&nbsp;Service : </span> ${pickupDetails.product} 
                           </td>
                           <td class="td1" width="130"><span class="head">&nbsp;Cargo Value : </span> ${pickupDetails.volume} 
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="315" valign="top" width="208">
                  <table height="100%" cellspacing="0" cellpadding="0">
                     <tbody>
                        <tr>
                           <td class="td1" height="38" align="center">
                              <img src="/Gati/resources/img/gati_logo.png" width="205" height="34">
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="113" valign="top" width="210"><span class="head">&nbsp;Receiver Address 
                              &emsp;Code:</span> ${pickupDetails.receiver_code} 
                              <br>&nbsp;${pickupDetails.receiver_address1}, ${pickupDetails.receiver_address2}
                              <br>&nbsp;${pickupDetails.receiver_address3}, ${pickupDetails.receiver_address4}
                              <br>&nbsp;${pickupDetails.receiver_city}-${pickupDetails.receiver_pincode}, 
                              <br>&nbsp;PH: ${pickupDetails.receiver_phone},Email : ${pickupDetails.receiver_email}
                              <br>&nbsp;GSTIN No: ${pickupDetails.receiver_tin}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="163" valign="top" align="left">
                              <table height="160" cellspacing="0" cellpadding="0" width="212">
                                 <tbody>
                                    <tr>
                                       <td align="center"><span class="barcode">!${pickupDetails.docket_no}!</span></td>
                                    </tr>
                                 </tbody>
                              </table>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="315" valign="top" width="215">
                  <table height="100%" cellspacing="0" cellpadding="0" width="100%">
                     <tbody>
                        <tr>
                           <td class="td1" height="38">&nbsp;Docket No <span class="td2"> ${pickupDetails.docket_no} </span>
                           <br>(NON-NEGOTIABLE DOCKET)
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="54" valign="top">
	                           <span class="head">&nbsp;Bkg OU : </span><span class="td2"> ${pickupDetails.booking_ou} </span><br>
	                           <span class="head">&nbsp;Dly OU :</span><span class="td2"> ${pickupDetails.delivery_ou} -[ESS] </span><br>
	                           <span class="head">&nbsp;Dly/ESS Nm: </span><span class="tdess"> ${pickupDetails.ess_code} </span>
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="56" valign="top">
	                           <span class="head">&nbsp;Booking Date :</span> 
	                           <fmt:formatDate pattern="dd-MMM-yyyy HH:mm" value="${pickupDetails.pickup_date}"/> <br>
	                           <span class="head">&nbsp;Assured Dly Date:</span> <fmt:formatDate pattern="dd-MMM-yyyy HH:mm" value="${pickupDetails.pickup_date}"/> <br>
	                           <span class="head">&nbsp;Risk Coverage :</span> ${pickupDetails.risk=="CR"? "Gati" :"Owner"} Risk
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="31" valign="bottom" align="left"><span class="head"><br>&nbsp;Shipper's Sign</span>&nbsp;</td>
                        </tr>
                        <tr>
                           <td class="td1" height="130" valign="bottom" align="left">
                              <br>&nbsp;Signature&nbsp;&nbsp;<span class="head">&nbsp;<br>&nbsp;(For Gati KWE)</span>&nbsp; &nbsp; 
                              <hr>
                              <!--Service Tax Reg No.-->
                              <br>&nbsp;Gati GSTIN NO:33AADCG2096A1Z4
                              <br>&nbsp;PAN :AADCG2096A<br>
                              <!--PAN NO.AADCG2096A-->. 
                              <br><br>
                              <div class="td4" align="right">&nbsp;SHIPPER COPY&emsp;</div>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
            </tr>
            <tr>
               <td class="td3" height="12" valign="top" colspan="3">Spl.Instruction:&nbsp;<br>Your obtaining this docket signifies 
                  your consent to the terms and conditions of the company for carrying the 
                  shipment as mentioned on 
                  www.gatikwe.com {HSRT_30811}
               </td>
            </tr>
         </tbody>
      </table>
      <hr class="codeSnippet">
      <table class="td1" height="322" cellspacing="0" cellpadding="0" width="668" align="center">
         <tbody>
            <tr>
               <td height="308" valign="top" width="255">
                  <table height="100%" cellspacing="0" cellpadding="0" width="254">
                     <tbody>
                        <tr>
                           <td class="td1" height="36" valign="top" colspan="2" align="left">&nbsp;You can track Your shipments at
                           <br>&nbsp;www.gatikwe.com.You can also reach us
                           <br>&nbsp;at TOLL FREE NO 1800-180-4284
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="97" valign="top" colspan="2">
                           <span class="head">&nbsp;Shipper Address &emsp;Code:</span>${pickupDetails.shipper_code}
                           <br/>&nbsp;${pickupDetails.shipper_address1}, ${pickupDetails.shipper_address2}
                           <br/>&nbsp;${pickupDetails.shipper_address3}, ${pickupDetails.shipper_address4}
                           <br/>&nbsp;${pickupDetails.shipper_city}-${pickupDetails.shipper_pincode},
                           <br/>&nbsp;PH:${pickupDetails.shipper_phone}, EMAIL: ${pickupDetails.shipper_email}<br/>
                           <br>&nbsp;Policy No: 
                           <br>&nbsp;GSTIN No: ${pickupDetails.shipper_tin}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="16" colspan="2">
                           	<span class="head">&nbsp;Pkg Nos : </span> ${pickupDetails.package_number_from} - ${pickupDetails.package_number_to}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Ref No : </span> 0
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Contains : </span> ${pickupDetails.goods_desc} 
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;FOD Amount :</span> ${pickupDetails.cod_dod_amount}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="20">
                           	<span class="head">&nbsp;Basis : </span>
                           	<c:choose>
                           		<c:when test="${pickupDetails.booking_basis=='1'}">PAID</c:when>
                           		<c:when test="${pickupDetails.booking_basis=='2'}">TBB</c:when>
                           		<c:when test="${pickupDetails.booking_basis=='4'}">FOD</c:when>
                           		<c:when test="${pickupDetails.booking_basis=='6'}">BOD</c:when>                           		
                           	</c:choose>
                           </td>
                           <td class="td1" valign="top" width="130">
                           	<span class="head">&nbsp;No. of Pkgs : </span> ${pickupDetails.no_of_packages}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="23">
                           	<span class="head">&nbsp;COD : </span>${pickupDetails.cod_flag} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;COD in Fav : </span> ${pickupDetails.cod_dod_in_favor=="G"?"Gati":"Shipper"}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="24">
                           	<span class="head">&nbsp;ACT Wt(Kgs): </span> ${pickupDetails.actual_weight} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;Wt(Kgs): </span> ${pickupDetails.actual_weight}
                           	</td>
                        </tr>
                        <tr>
                           <td class="td1" height="22" width="122">
                           	<span class="head">&nbsp;Service : </span> ${pickupDetails.product} 
                           </td>
                           <td class="td1" width="130"><span class="head">&nbsp;Cargo Value : </span> ${pickupDetails.volume} 
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="308" valign="top" width="208">
                  <table height="100%" cellspacing="0" cellpadding="0" width="100%" >
                     <tbody>
                        <tr>
                           <td class="td1" height="38" align="center">
                              <img src="/Gati/resources/img/gati_logo.png" width="205" height="34">
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="107" valign="top" width="210"><span class="head">&nbsp;Receiver&nbsp;Address 
                              &emsp;Code:</span> ${pickupDetails.receiver_code} 
                              <br>&nbsp;${pickupDetails.receiver_address1}, ${pickupDetails.receiver_address2}
                              <br>&nbsp;${pickupDetails.receiver_address3}, ${pickupDetails.receiver_address4}
                              <br>&nbsp;${pickupDetails.receiver_city}-${pickupDetails.receiver_pincode}, 
                              <br>&nbsp;PH: ${pickupDetails.receiver_phone},Email : ${pickupDetails.receiver_email}
                              <br>&nbsp;GSTIN No: ${pickupDetails.receiver_tin}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="163" valign="top" align="left">
                              <table height="160" cellspacing="0" cellpadding="0" width="212">
                                 <tbody>
                                    <tr>
                                       <td align="center"><span class="barcode">!${pickupDetails.docket_no}!</span></td>
                                    </tr>
                                 </tbody>
                              </table>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="308" valign="top" width="215">
                  <table height="100%" cellspacing="0" cellpadding="0" width="100%">
                     <tbody>
                        <tr>
                           <td class="td1" height="38">&nbsp;Docket No <span class="td2"> ${pickupDetails.docket_no} </span> 
                           <br>&nbsp;(NON-NEGOTIABLE DOCKET)
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="54" valign="top">
	                           <span class="head">&nbsp;Bkg OU : </span><span class="td2"> ${pickupDetails.booking_ou} </span><br>
	                           <span class="head">&nbsp;Dly OU :</span><span class="td2"> ${pickupDetails.delivery_ou} -[ESS] </span><br>
	                           <span class="head">&nbsp;Dly/ESS Nm: </span><span class="tdess"> ${pickupDetails.ess_code} </span>
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="50" valign="top">
                               <span class="head">&nbsp;Booking Date :</span> <fmt:formatDate pattern="dd-MMM-yyyy HH:mm" value="${pickupDetails.pickup_date}"/> <br>
	                           <span class="head">&nbsp;Assured Dly Date:</span> <fmt:formatDate pattern="dd-MMM-yyyy HH:mm" value="${pickupDetails.pickup_date}"/> <br>
	                           <span class="head">&nbsp;Risk Coverage :</span> ${pickupDetails.risk=="CR"? "Gati" :"Owner"} Risk                           
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="31" valign="bottom" align="left"><span class="head"><br>&nbsp; Shipper's Sign</span>&nbsp;</td>
                        </tr>
                        <tr>
                           <td class="td1" height="130" valign="bottom" align="left">
                              <br>&nbsp;Signature&nbsp;&nbsp;<span class="head">&nbsp;<br>(For Gati KWE)</span>&nbsp; &nbsp; 
                              <hr>
                              <br>&nbsp;Gati GSTIN NO:33AADCG2096A1Z4 <!--Service Tax Reg No.-->
                              <br>&nbsp;PAN :AADCG2096A<!--PAN NO. AADCG2096A-->. 
                              <br><br><br>
                              <div class="td4" align="right">&nbsp;RECEIVER COPY&emsp;</div>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
            </tr>
            <tr>
               <td class="td3" height="12" valign="top" colspan="3">Spl.Instruction:&nbsp;<br>Your obtaining this docket signifies 
                  your consent to the terms and conditions of the company for carrying the 
                  shipment as mentioned on 
                  www.gatikwe.com&nbsp;{HSRT_30811}
               </td>
            </tr>
         </tbody>
      </table>
      <hr class="codeSnippet">
      <table class="td1" height="332" cellspacing="0" cellpadding="0" width="669" align="center">
         <tbody>
            <tr>
               <td height="318" valign="top" width="255">
                  <table height="100%" cellspacing="0" cellpadding="0" width="253">
                     <tbody>
                        <tr>
                           <td class="td1" height="34" valign="top" colspan="2" align="left">&nbsp;You 
                              can track Your shipments at<br>&nbsp;www.gatikwe.com.You can also 
                              reach us<br>&nbsp;at TOLL FREE NO 1800-180-4284
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="95" valign="top" colspan="2">
                           <span class="head">&nbsp;Shipper Address &emsp;Code:</span>${pickupDetails.shipper_code}<br/>
	                           &nbsp;${pickupDetails.shipper_address1}, ${pickupDetails.shipper_address2}<br/>
	                           &nbsp;${pickupDetails.shipper_address3}, ${pickupDetails.shipper_address4}<br/>
	                           &nbsp;${pickupDetails.shipper_city}-${pickupDetails.shipper_pincode}, <br/>
	                           &nbsp;PH:${pickupDetails.shipper_phone}, EMAIL: ${pickupDetails.shipper_email}<br/>
                              <br>&nbsp;Policy No: 
                              <br>&nbsp;GSTIN No: ${pickupDetails.shipper_tin}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="16" colspan="2">
                           	<span class="head">&nbsp;Pkg Nos : </span> ${pickupDetails.package_number_from} - ${pickupDetails.package_number_to}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Ref No : </span> 0
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Contains : </span> ${pickupDetails.goods_desc} 
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;FOD Amount :</span> ${pickupDetails.cod_dod_amount}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="20">
                           	<span class="head">&nbsp;Basis : </span>
                           	<c:choose>
                           		<c:when test="${pickupDetails.booking_basis=='1'}">PAID</c:when>
                           		<c:when test="${pickupDetails.booking_basis=='2'}">TBB</c:when>
                           		<c:when test="${pickupDetails.booking_basis=='4'}">FOD</c:when>
                           		<c:when test="${pickupDetails.booking_basis=='6'}">BOD</c:when>                           		
                           	</c:choose>
                           </td>
                           <td class="td1" valign="top" width="130">
                           	<span class="head">&nbsp;No. of Pkgs : </span> ${pickupDetails.no_of_packages}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="23">
                           	<span class="head">&nbsp;COD : </span>${pickupDetails.cod_flag} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;COD in Fav : </span> ${pickupDetails.cod_dod_in_favor=="G"?"Gati":"Shipper"}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="24">
                           	<span class="head">&nbsp;ACT Wt(Kgs): </span> ${pickupDetails.actual_weight} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;Wt(Kgs): </span> ${pickupDetails.actual_weight}
                           	</td>
                        </tr>
                        <tr>
                           <td class="td1" height="22" width="122">
                           	<span class="head">&nbsp;Service : </span> ${pickupDetails.product} 
                           </td>
                           <td class="td1" width="130"><span class="head">&nbsp;Cargo Value : </span> ${pickupDetails.volume} 
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="318" valign="top" width="208">
                  <table height="100%" cellspacing="0" cellpadding="0">
                     <tbody>
                        <tr>
                           <td class="td1" height="38" align="center">
                              <img src="/Gati/resources/img/gati_logo.png" width="205" height="34">
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="110" valign="top" width="212"><span class="head">&nbsp;Receiver&nbsp;Address 
                              &emsp;Code:</span> ${pickupDetails.receiver_code} 
                              <br>&nbsp;${pickupDetails.receiver_address1}, ${pickupDetails.receiver_address2}
                              <br>&nbsp;${pickupDetails.receiver_address3}, ${pickupDetails.receiver_address4}
                              <br>&nbsp;${pickupDetails.receiver_city}-${pickupDetails.receiver_pincode}, 
                              <br>&nbsp;PH: ${pickupDetails.receiver_phone},Email : ${pickupDetails.receiver_email}
                              <br>&nbsp;GSTIN No: ${pickupDetails.receiver_tin}
                           </td>
                        </tr>
                        <tr>
                           <td class="td32" height="157" valign="bottom" >
                           <table height="157" cellspacing="0" cellpadding="0">
                                 <tbody>
                                    <tr>
                                       <td align="center"><span class="barcode">!${pickupDetails.docket_no}!</span> 
                              <hr class="m5">
                              <span class="tdnew1">&nbsp;Receiver's&nbsp;Signature,Stamp&nbsp;&amp;Comments:</span><br><br><br><br><br><br><span class="tdnew1">I/We&nbsp;received&nbsp;the&nbsp;cargo/documents&nbsp;in&nbsp;good&nbsp;conditions</span></td>
                                    </tr>
                                 </tbody>
                              </table>                              
                           </td>
                        </tr>
                        <tr class="tdnew1">
                           <td height="10">NAME&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DATE&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TIME</td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="318" valign="top" width="215">
                  <table height="96%" cellspacing="0" cellpadding="0" width="100%">
                     <tbody>
                        <tr>
                           <td class="td1" height="38">&nbsp;Docket No <span class="td2"> ${pickupDetails.docket_no} </span>
                           <br>&nbsp;(NON-NEGOTIABLE DOCKET)
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="54" valign="top">
                              <span class="head">&nbsp;Origin : </span><span class="td2"> ${pickupDetails.booking_ou} </span><br>
	                           <span class="head">&nbsp;Dly OU :</span><span class="td2"> ${pickupDetails.delivery_ou} -[ESS] </span><br>
	                           <span class="head">&nbsp;Dly. Stn/ESS: </span><span class="tdess"> ${pickupDetails.ess_code} </span>
                           </td>                           
                        </tr>
                        <tr>
                           <td class="td1" height="50" valign="top">
                               <span class="head">&nbsp;Booking Date :</span> <fmt:formatDate pattern="dd-MMM-yyyy HH:mm" value="${pickupDetails.pickup_date}"/> <br>
	                           <span class="head">&nbsp;Assured Dly Date:</span> <fmt:formatDate pattern="dd-MMM-yyyy HH:mm" value="${pickupDetails.pickup_date}"/> <br>
	                           <span class="head">&nbsp;Risk Coverage :</span> ${pickupDetails.risk=="CR"? "Gati" :"Owner"} Risk
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="30" valign="bottom" align="left"><span class="head"><br>&nbsp; Shipper's Sign</span>&nbsp;</td>
                        </tr>
                        <tr>
                           <td class="td1" height="141" align="left">
                              <br>&nbsp;Signature&nbsp;&nbsp;<span class="head">&nbsp;<br>(For Gati KWE)</span>&nbsp; 
                              <table class="tdnew1" cellspacing="0" cols="3" cellpadding="0" width="202" border="1">
                                 <tbody>
                                    <tr>
                                       <th class="head" width="70">&nbsp;</th>
                                       <th class="head" width="72">Date Time</th>
                                       <th class="head" width="48">Undld cd</th>
                                    </tr>
                                    <tr>
                                       <td class="head">1st Attempt</td>
                                       <td>&nbsp;</td>
                                       <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                       <td class="head">2nd Attempt</td>
                                       <td>&nbsp;</td>
                                       <td>&nbsp;</td>
                                    </tr>
                                 </tbody>
                              </table>
                              <br><!--Service Tax Reg No.-->
                              <br>&nbsp;Gati GSTIN NO:33AADCG2096A1Z4
                              <br>&nbsp;PAN :AADCG2096A
                              <br><!--PAN NO. AADCG2096A.-->
                              <br>
                              <div class="td4" align="right">POD COPY&emsp;</div>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
            </tr>
            <tr>
               <td class="td3" height="12" valign="top" colspan="3">Your obtaining this docket 
                  signifies your consent to the terms and conditions of the company for 
                  carrying the shipment as mentioned on 
                  www.gatikwe.com&nbsp;{HSRT_30811}
               </td>
            </tr>
         </tbody>
      </table>
					</div>
				</div>
				<div class="footer withoutprint">
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

		<script type="text/javascript">
		var serverContext = "${home}";
	$(document).ready(function() {
		
	});

        
    </script>
		<!-- Custom and plugin javascript -->
		<script src="<c:url value="/resources/js/inspinia.js"/>"></script>
		<script src="<c:url value="/resources/js/pace/pace.min.js"/>"
			type="text/javascript"></script>
</body>
</html>