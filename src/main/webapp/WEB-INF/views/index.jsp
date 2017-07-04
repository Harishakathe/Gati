<%@page session="false"%>
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
        
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/font-awesome/css/font-awesome.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
        
		<link href="<c:url value="/resources/css/jquery-ui.min.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/wizard/material-bootstrap-wizard.css" />" rel="stylesheet" type="text/css"/>
    </head>

    <body class="md-skin">
        <div id="wrapper">
            <nav class="navbar-default navbar-static-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav metismenu" id="side-menu">
                        <li class="nav-header">
                            <img alt="Gati KWE Logo" class="img-responsive center-block logo" src="<c:url value="/resources/img/logo.png" />" />
                            <div class="dropdown profile-element m-t-md"> 
                                <span>
                                    <img alt="image" class="img-circle center-block" src="<c:url value="/resources/img/a6.jpg" />" />
                                </span>
                                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                    <span class="clear text-grey text-center"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>
                                        </span> <span class="text-light text-xs block">Designation <b class="caret"></b></span> </span> </a>
                                <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                    <li><a href="profile.html">Profile</a></li>
                                    <li><a href="contacts.html">Contacts</a></li>
                                    <li class="divider"></li>
                                    <li><a href="login.html">Logout</a></li>
                                </ul>
                            </div>
                            <div class="logo-element">
                               
                            </div>
                        </li>
                        <li class="active">
                            <a href="#"><i class="fa fa-th-large fa-fw"></i> <span class="nav-label">Dashboard</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-diamond fa-fw"></i> <span class="nav-label">GST KYC</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-ellipsis-h fa-fw"></i> <span class="nav-label">Change Password</span></a>

                        </li>
                        <li>
                            <a href="#"><i class="fa fa-envelope fa-fw"></i> <span class="nav-label">Docket Summary </span></a>

                        </li>
                        <li>
                            <a href="#"><i class="fa fa-pie-chart fa-fw"></i> <span class="nav-label">Docket Status</span>  </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-shirtsinbulk fa-fw"></i> <span class="nav-label">COD Shipment Details</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> <span class="nav-label">Pickup Request Details</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bell-o fa-fw"></i> <span class="nav-label">Claim Registration</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-clone fa-fw"></i> <span class="nav-label">Invoice Details</span></a>

                        </li>
                        <li>
                            <a href="#"><i class="fa fa-print fa-fw"></i> <span class="nav-label">Docket Print</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-file-powerpoint-o fa-fw"></i> <span class="nav-label">Proof of Delivery (POD)</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-user fa-fw"></i> <span class="nav-label">Vendor Details</span></a>
                        </li>
                    </ul>

                </div>
            </nav>

            <div id="page-wrapper" class="gray-bg">
                <div class="row border-bottom">
                    <nav class="navbar navbar-static-top  " role="navigation" style="margin-bottom: 0">
                        <div class="navbar-header">
                            <a class="navbar-minimalize minimalize-styl-2 btn btn-link " href="#"><i class="fa fa-bars"></i> </a>
                        </div>
                        <ul class="nav navbar-top-links navbar-right">
                            <li>
                                <span class="m-r-sm text-light welcome-message"><i class="fa fa-phone"></i> 1800-180-4284</span>
                            </li>
                            <li>
                                <a href="login.html" class="text-light">
                                    <i class="fa fa-power-off"></i> Log out
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>

                <div class="wrapper wrapper-content">
                    <div class="row">
                        <div class="col-sm-12">
                            <!--      Wizard container        -->
                            <div class="wizard-container">
                                <div class="card wizard-card" data-color="blue" id="wizard">
                                    <form action="${get}validate_xml" method="post" id="PickupDetailsForm" >
                                        <!--	You can switch " data-color="rose" "  with one of the next bright colors: "blue", "green", "orange", "purple"        -->
                                        <div class="wizard-navigation">
                                            <ul class="no-border-li">
                                                <li><a href="#tab1" data-toggle="tab">Receivers Details</a></li>
                                                <li><a href="#tab2" data-toggle="tab">Shipper Details</a></li>
                                                <li><a href="#tab3" data-toggle="tab">Shipment Details</a></li>
                                                <li><a href="#tab4" data-toggle="tab">Confirm Details</a></li>
                                            </ul>
                                        </div>

                                        <div class="tab-content">
                                            <div class="tab-pane" id="tab1">
                                                <div class="row" id="slim">
                                                    <div class="col-sm-5 col-sm-offset-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Receiver Code <small>(requird)</small></label>
                                                            <input type="text" class="form-control" name="receiver_code" id="receiver_code">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Name <small>(requird)</small></label>
                                                            <input type="text" class="form-control" name="receiver_name" id="receiver_name" >
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5 col-sm-offset-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Phone No <small>(requird)</small></label>
                                                            <input type="text" class="form-control" name="receiver_phone" id="receiver_phone">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Mobile No <small>(requird)</small></label>
                                                            <input type="text" class="form-control" name="receiver_mobile" id="receiver_mobile">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5 col-sm-offset-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Address Line 1 <small>(requird)</small></label>
                                                            <input type="text" class="form-control" name="receiver_address1" id="receiver_address1">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Address Line 2 <small>(requird)</small></label>
                                                            <input type="text" class="form-control" name="receiver_address2" id="receiver_address2">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5 col-sm-offset-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Address Line 3 <small>(requird)</small></label>
                                                            <input type="text" class="form-control" name="receiver_address3" id="receiver_address3">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Address Line 4</label>
                                                            <input type="text" class="form-control" name="receiver_address4" id="receiver_address4">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5 col-sm-offset-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">City <small>(requird)</small></label>
                                                            <input type="text" class="form-control" name="receiver_city" id="receiver_city">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Pin Code <small>(requird)</small></label>
                                                            <input type="text" class="form-control" name="receiver_pincode" id="receiver_pincode">
                                                            <input type="hidden" id="delivery_ou" name="delivery_ou">
															<input type="hidden" id="ess_code" name="ess_code">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5 col-sm-offset-1">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Email <small>(requird)</small></label>
                                                            <input type="text" class="form-control" name="receiver_email" id="receiver_email">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">GSTIN NO<small>(requird)</small></label>
                                                            <input type="text" class="form-control" name="receiver_tin" id="receiver_tin">                                                                
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="tab2">
                                                <div class="row">
                                                    <div class="row" id="slim2">
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Shipper Code <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="shipper_code" id="shipper_code">
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Name <small>(requird)</small></label>
                                                                <input type="text" class="form-control"name="shipper_name" id="shipper_name" >
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Phone No <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="shipper_phone" id="shipper_phone" >
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Mobile No <small>(requird)</small></label>
                                                                <input type="text" class="form-control"name="shipper_mobile" id="shipper_mobile">
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Address Line 1 <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="shipper_address1" id="shipper_address1">
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Address Line 2 <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="shipper_address2" id="shipper_address2">
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Address Line 3 <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="shipper_address3" id="shipper_address3">
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Address Line 4</label>
                                                                <input type="text" class="form-control" name="shipper_address4" id="shipper_address4">
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">City <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="shipper_city" id="shipper_city" >
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Pin Code <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="shipper_pincode" id="shipper_pincode" >
                                                                 <input type="hidden" id="booking_ou" name="booking_ou">
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Email <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="shipper_email" id="shipper_email" >
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">GSTIN NO <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="shipper_tin" id="shipper_tin" >                                                                    
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="tab3">
                                                <div id="slim3">
                                                    <div class="row">
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Product <small>(requird)</small></label>
                                                                <select class="form-control" name="product" id="product">
                                                                    <option disabled="" selected=""></option>
                                                                    <option value="25">Surface Express</option>
																	<option value="20">Express Plus</option>
																	<option value="5">Gati-Laabh</option>
																	<option value="67">Gati-D2DC</option>
																	<option value="65">Gati-Light</option>
																	<option value="80">Secure Box</option>
																	<option value="2">Standard</option>
																	<option value="14_1">Preminum</option>
																	<option value="14_2">Premium Plus-12 hrs</option>
																	<option value="14_3">Premium Plus-24 hrs</option>
                                                                </select>
                                                                <input type="hidden" name="docket_type" id="docket_type" value="NR"  >
																<input type="hidden" name="docket_category" id="docket_category" value="D"  >
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">BKG Basis <small>(requird)</small></label>
                                                                <select class="form-control" name="booking_basis" id="booking_basis">
                                                                    <option disabled="" selected=""></option>
                                                                    <option value="1">PAID</option>
																	<option value="2">TBB</option>
																	<option value="4">FOD</option>
																	<option value="6">BOD</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Goods Type <small>(requird)</small></label>
                                                                <select class="form-control" id="goods_code" name="goods_code">
                                                                    <option disabled="" selected=""></option>                                                                    
                                                                </select>
                                                                <input type="hidden" name="goods_desc" id="goods_desc"  >
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Packing Type <small>(requird)</small></label>
                                                                <select class="form-control" id="package_type" name="package_type">
                                                                    <option disabled="" selected=""></option>
                                                                    <option value="0">Package</option>
                                                                    <option value="CV">Cover</option>
                                                                    <option value="CB">Cartoon Box</option>
                                                                    <option value="GB">Gunny Bag</option>
                                                                    <option value="WB">Wooden Box</option>
                                                                    <option value="WC">Wooden Crate</option>
                                                                    <option value="PC">Plastic Crane</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">No. of Packages <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="no_of_packages" id="no_of_packages" readonly>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <button type="button" class="btn btn-primary" id="add"><i class="fa fa-plus"></i>&emsp;Add Packages</button>
                                                        </div>
                                                    </div>
                                                    <div class="row" id="package_details_div">                                                        
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Shipment value <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="shipment_value" id="shipment_value">
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">Risk <small>(requird)</small></label>
                                                                <select class="form-control" name="risk" id="risk">
                                                                    <option disabled="" selected=""></option>
                                                                    <option value="CR">Gati</option>
																	<option value="OR">Owner</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label" >Volume <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="volume" id="volume">
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">UOM <small>(requird)</small></label>
                                                                <select class="form-control" name="uom" id="uom">
                                                                    <option disabled="" selected=""></option>
                                                                    <option value="0">Unit</option>
                                                                    <option value="ft">Feet</option>
                                                                    <option value="in">Inches</option>
                                                                    <option value="cmet">CentiMeter</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">ACT.WT <small>(requird)</small></label>
                                                                <input type="text" class="form-control" name="actual_weight" id="actual_weight">
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">COD/DOD Flag <small>(requird)</small></label>
                                                                <select class="form-control" name="cod_flag" id="cod_flag">
                                                                    <option disabled="" selected=""></option>
                                                                    <option value="Y">Yes</option>
																	<option value="N">No</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5 col-sm-offset-1">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">COD/DOD in Fav <small>(requird)</small></label>
                                                                <select class="form-control" name="cod_dod_in_favor" id="cod_dod_in_favor">
                                                                    <option disabled="" selected=""></option>
                                                                    <option value="G">Gati</option>
																	<option value="S">Shipper</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-group label-floating">
                                                                <label class="control-label">COD/DOD Amt <small>(requird)</small></label>
                                                                <input type="text" class="form-control" id="cod_dod_amount" name="cod_dod_amount">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="tab4">
                                                <div class="row" id="slim4">
                                                    <div class="col-sm-10 col-sm-offset-1">
                                                        <div class="ibox float-e-margins">
                                                            <div class="ibox-title">
                                                                <h5>Receivers Details </h5>
                                                                <div class="ibox-tools">
                                                                    <a class="collapse-link">
                                                                        <i class="fa fa-chevron-up"></i>
                                                                    </a>
                                                                    <a class="close-link">
                                                                        <i class="fa fa-times"></i>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <div class="ibox-content">
                                                                <div>
                                                                    <div class="row">
                                                                        <div class="col-sm-5 col-sm-offset-1 labels">
                                                                            <label><strong>Receiver Code</strong> : <span id="lbl_receiver_code"></span></label>
                                                                            <label><strong>Name</strong> : <span id="lbl_receiver_name"></span></label>
                                                                            <label><strong>Address Line 1</strong> : <span id="lbl_receiver_address1"></span></label>
                                                                            <label><strong>Address Line 3</strong> : <span id="lbl_receiver_address3"></span></label>
                                                                            <label><strong>City</strong> : <span id="lbl_receiver_city"></span></label>
                                                                            <label><strong>Email</strong> : <span id="lbl_receiver_email"></span></label>
                                                                        </div>
                                                                        <div class="col-sm-5 labels">
                                                                            <label><strong>Mobile</strong> : <span id="lbl_receiver_mobile"></span></label>
                                                                            <label><strong>Phone</strong> : <span id="lbl_receiver_phone"></span></label>
                                                                            <label><strong>Address Line 2</strong> : <span id="lbl_receiver_address2"></span></label>
                                                                            <label><strong>Address Line 4</strong> : <span id="lbl_receiver_address4"></span></label>
                                                                            <label><strong>Pin Code</strong> : <span id="lbl_receiver_pincode"></span></label>
                                                                            <label><strong>GSTIN NO</strong> : <span id="lbl_receiver_tin"></span></label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="ibox float-e-margins">
                                                            <div class="ibox-title">
                                                                <h5>Shippers Details</h5>
                                                                <div class="ibox-tools">
                                                                    <a class="collapse-link">
                                                                        <i class="fa fa-chevron-up"></i>
                                                                    </a>
                                                                    <a class="close-link">
                                                                        <i class="fa fa-times"></i>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <div class="ibox-content">
                                                                <div>
                                                                    <div class="row">
                                                                        <div class="col-sm-5 col-sm-offset-1 labels">
                                                                            <label><strong>Shipper Code</strong> : <span id="lbl_shipper_code"></span></label>
                                                                            <label><strong>Name</strong> : <span id="lbl_shipper_name"></span></label>
                                                                            <label><strong>Address Line 1</strong> : <span id="lbl_shipper_address1"></span></label>
                                                                            <label><strong>Address Line 3</strong> : <span id="lbl_shipper_address3"></span></label>
                                                                            <label><strong>City</strong> : <span id="lbl_shipper_city"></span></label>
                                                                            <label><strong>Email</strong> : <span id="lbl_shipper_email"></span></label>
                                                                        </div>
                                                                        <div class="col-sm-5 labels">
                                                                            <label><strong>Mobile</strong> : <span id="lbl_shipper_mobile"></span></label>
                                                                            <label><strong>Phone</strong> : <span id="lbl_shipper_phone"></span></label>
                                                                            <label><strong>Address Line 2</strong> : <span id="lbl_shipper_address2"></span></label>
                                                                            <label><strong>Address Line 4</strong> : <span id="lbl_shipper_address4"></span></label>
                                                                            <label><strong>Pin Code</strong> : <span id="lbl_shipper_pincode"></span></label>
                                                                            <label><strong>GSTIN NO</strong> : <span id="lbl_shipper_tin"></span></label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="ibox float-e-margins">
                                                            <div class="ibox-title">
                                                                <h5>Shipment Details</h5>
                                                                <div class="ibox-tools">
                                                                    <a class="collapse-link">
                                                                        <i class="fa fa-chevron-up"></i>
                                                                    </a>
                                                                    <a class="close-link">
                                                                        <i class="fa fa-times"></i>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <div class="ibox-content">
                                                                <div>
                                                                    <div class="row">
                                                                        <div class="col-sm-5 col-sm-offset-1 labels">
                                                                            <label><strong>Docket No</strong> : Not Avaliable</label>
                                                                            <label><strong>BKG. Basis</strong> : <span id="lbl_booking_basis"></span></label>
                                                                            <label><strong>BKG Pin Code</strong> : <span id="lbl_booking_pincode"></span></label>
                                                                            <label><strong>No Of Packages</strong> : <span id="lbl_no_of_packages"></span></label>
                                                                            <label><strong>Shipment Value</strong> : <span id="lbl_shipment_value"></span></label>
                                                                            <label><strong>Risk </strong> : <span id="lbl_risk"></span></label>
                                                                            <label><strong>ACT. WT</strong> : <span id="lbl_actual_weight"> KG</span></label>
                                                                            <label><strong>COD/DOD in Fav</strong> : <span id="lbl_cod_dod_in_favor"></span></label>
                                                                        </div>
                                                                        <div class="col-sm-5 labels">
                                                                            <label><strong>Product</strong> : <span id="lbl_product"></span></label>
                                                                            <label><strong>Goods Type</strong> : <span id="lbl_goods_code"></span></label>
                                                                            <label><strong>DLY Pin Code</strong> : <span id="lbl_delivery_pincode"></span></label>                                                                            
                                                                            <label><strong>Packing Type</strong> : <span id="lbl_package_type"></span></label>
                                                                            <label><strong>Volume</strong> : <span id="lbl_volume"> LBS</span></label>
                                                                            <label><strong>UOM</strong> : <span id="lbl_uom"></span></label>
                                                                            <label><strong>COD/DOD Flag</strong> : <span id="lbl_cod_flag"></span></label>
                                                                            <label><strong>COD/DOD Amt</strong> : <span id="lbl_cod_dod_amount"></span></label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="wizard-footer">
                                            <div class="pull-right">
                                                <input type='button' class='btn btn-next btn-fill btn-info btn-wd' name='next' value='Next' />
                                                <input type='button' class='btn btn-finish btn-fill btn-primary btn-wd' name='finish' value='Finish' />
                                            </div>
                                            <div class="pull-left">
                                                <input type='button' class='btn btn-previous btn-fill btn-default btn-wd' name='previous' value='Previous' />
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                        <textarea style="display:none" id="template">
	                                       	<div class="col-sm-5 col-sm-offset-1">
		                                         <div class="row">
		                                             <div class="col-sm-6">
		                                                 <div class="form-group label-floating is-empty">
		                                                     <label class="control-label">Length <small>(requird)</small></label>
		                                                     <input type="text" class="form-control pkg pkg_ln" name="package_details[{0}].pkg_ln">
		                                                 </div>
		                                             </div>
		                                             <div class="col-sm-6">
		                                                 <div class="form-group label-floating is-empty">
		                                                     <label class="control-label">Breadth <small>(requird)</small></label>
		                                                     <input type="text" class="form-control pkg pkg_br" name="package_details[{0}].pkg_br">
		                                                 </div>
		                                             </div>
		                                         </div>
		                                     </div>
		                                     <div class="col-sm-5">
		                                         <div class="row">
		                                             <div class="col-sm-6">
		                                                 <div class="form-group label-floating is-empty">
		                                                     <label class="control-label">Height <small>(requird)</small></label>
		                                                     <input type="text" class="form-control pkg pkg_ht" name="package_details[{0}].pkg_ht">
		                                                 </div>
		                                             </div>
		                                             <div class="col-sm-6">
		                                                 <div class="form-group label-floating is-empty">
		                                                     <label class="control-label">Weight <small>(requird)</small></label>
		                                                     <input type="text" class="form-control pkg pkg_wt " name="package_details[{0}].pkg_wt">
		                                                 </div>
		                                             </div>
		                                         </div>
		                                     </div>
	                                     </textarea>
                                    </form>
                                </div>
                            </div> <!-- wizard container -->
                        </div>
                    </div> <!-- row -->

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
        <script src="<c:url value="/resources/js/jquery-2.2.4.min.js"/>" ></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery.bootstrap.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/metisMenu/jquery.metisMenu.js"/>"></script>
        <script src="<c:url value="/resources/js/slimscroll/jquery.slimscroll.min.js"/>"></script>

        <!-- Custom and plugin javascript -->
        <script src="<c:url value="/resources/js/inspinia.js"/>"></script>
        <script src="<c:url value="/resources/js/pace/pace.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/wizard/material-bootstrap-wizard.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/wizard/jquery.validate.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery-ui.min.js"/>" type="text/javascript"></script>
        <script>
            $(function () {
                $('#slim, #slim2, #slim3, #slim4').slimScroll({
                    height: '380px'
                });
                
                $("#cod_flag").change(function(){
               		$("#cod_dod_amount").val('');
               		if($("#cod_flag").val()=='Y'){
               			$("#cod_dod_amount").attr("readonly",false);
               		}else{                            			
               			$("#cod_dod_amount").attr("readonly",true);           			
               		}
               	});
                
                $("#goods_code").change(function(){
               		$("#goods_desc").val($("#goods_code option:selected").text());
               	});                
            	
            	 function fillGoodType(){
            		 $("#goods_code").html="";
    	       		 $.ajax( {
    		              method:"get",
    		              headers: {
    		            	    Accept: "application/json"
    		            	  },
    		              url: "${get}getGoodType",
    		              success: function( data ) {
    		            	  $.each(data.items, function(index, element) {		            	  
    		            	  	$("#goods_code").append("<option value='"+element.good_code+"'>"+element.good_name+"</option>");
    		            	  });		            	  		                  
    		              },
    		              error: function() {
    		                  alert("Failed to load Good Type");
    		              }
    		              
    		            } );
            	 }
            	 
            	 function getEsscode(receiver_pincode){
            		 console.log("Function Call getEsscode:"+receiver_pincode);
            		 $("#esscode").val="";        		 
    	       		 $.ajax( {
    		              method:"get",
    		              headers: {
    		            	    Accept: "application/json"
    		            	  },
    		              url: "${get}getEsscode/"+receiver_pincode,
    		              success: function( data ) {
    		            	  console.log(data.ess_code);
    		            	  $("#ess_code").val(data.ess_code);		            	  		                  
    		              },
    		              error: function() {
    		                  alert("Failed to load Esscode");
    		              }		              
    		            });
            	 }
            	 
            	 fillGoodType();
    	        
    		      $( "#shipper_code" ).autocomplete({
    		    	  delay: 500,
    			        minLength: 3,
    			        source: function( request, response ) {
    			            $.ajax( {
    			              method:"get",
    			              headers: {
    			            	    Accept: "application/json"
    			            	  },
    			              url: "${get}getCustomerDetails/"+request.term,
    			              success: function( data ) {
    			                response( data.customers );
    			              }
    			            } );
    			          },       
    			        focus: function( event, ui ) {
    			          $("#shipper_code").val( ui.item.custCode );
    			          return false;
    			        },
    			        change: function(event, ui){
    			        	if(ui.item == null){
    			        		$("#shipper_name").val('');    		        	
              		        	$("#shipper_address1").val('');
              		        	$("#shipper_address2").val('');
              		        	$("#shipper_address3").val('');
              		        	$("#shipper_address4").val('');
              		        	$("#shipper_city").val('');
              		        	$("#shipper_pincode").val('');
              		        	$("#shipper_phone").val('');
              		        	$("#shipper_mobile").val('');
              		        	$("#shipper_email").val('');
              		        	$("#shipper_tin").val('');
              		        	$("#shipper_ou").val('');
              		        	
              		        	$("#shipper_name").trigger("change");
            		        	$("#shipper_address1").trigger("change");
            		        	$("#shipper_address2").trigger("change");
            		        	$("#shipper_address3").trigger("change");
            		        	$("#shipper_address4").trigger("change");
            		        	$("#shipper_city").trigger("change");
            		        	$("#shipper_pincode").trigger("change");
            		        	$("#shipper_phone").trigger("change");
            		        	$("#shipper_mobile").trigger("change");
            		        	$("#shipper_email").trigger("change");
            		        	$("#shipper_tin").trigger("change");
    			        	}
          		        	
          		        	
          		        	return false;
          		        	
          		        },
    			        select: function( event, ui ) {
    			        	$("#shipper_code").val( ui.item.custCode );
    			        	$("#shipper_name").val( ui.item.custName );
    			        	$("#shipper_address1").val( ui.item.custAdd1 );
    			        	$("#shipper_address2").val( ui.item.custAdd2 );
    			        	$("#shipper_address3").val( ui.item.custAdd3 );
    			        	$("#shipper_address4").val( ui.item.custAdd4 );
    			        	$("#shipper_city").val( ui.item.custCity );
    			        	$("#shipper_pincode").val( ui.item.custPincode );
    			        	$("#shipper_phone").val( ui.item.custPhone );
    			        	$("#shipper_mobile").val( ui.item.custMobile );
    			        	$("#shipper_email").val( ui.item.custEmail );
    			        	$("#shipper_tin").val( ui.item.custTIN ); 
    			        	$("#booking_ou").val( ui.item.custOU );
    			        	
    			        	$("#shipper_name").trigger("change");
        		        	$("#shipper_address1").trigger("change");
        		        	$("#shipper_address2").trigger("change");
        		        	$("#shipper_address3").trigger("change");
        		        	$("#shipper_address4").trigger("change");
        		        	$("#shipper_city").trigger("change");
        		        	$("#shipper_pincode").trigger("change");
        		        	$("#shipper_phone").trigger("change");
        		        	$("#shipper_mobile").trigger("change");
        		        	$("#shipper_email").trigger("change");
        		        	$("#shipper_tin").trigger("change");
    			          return false;
    			        }
    			      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
    			        return $( "<li>" )
    			          .append( "<span class='list-custcode'>"+ item.custCode + "</span>" + item.custName )
    			          .appendTo( ul );
    			      };
    		      
    		      $( "#receiver_code" ).autocomplete({
    		    	  delay: 500,
    		        minLength: 3,
    		        source: function( request, response ) {
    		            $.ajax( {
    		              method:"get",
    		              headers: {
    		            	    Accept: "application/json"
    		            	  },
    		              url: "${get}getCustomerDetails/"+request.term,
    		              success: function( data ) {
    		                response( data.customers );
    		              }
    		            } );
    		          },       
    		        focus: function( event, ui ) {
    		          $("#receiver_code").val( ui.item.custCode );
    		          return false;
    		        },
    		        change: function(event, ui){
    		        	
    		        	if(ui.item == null){
    		        		$("#receiver_name").val('');    		        	
        		        	$("#receiver_address1").val('');
        		        	$("#receiver_address2").val('');
        		        	$("#receiver_address3").val('');
        		        	$("#receiver_address4").val('');
        		        	$("#receiver_city").val('');
        		        	$("#receiver_pincode").val('');
        		        	$("#receiver_phone").val('');
        		        	$("#receiver_mobile").val('');
        		        	$("#receiver_email").val('');
        		        	$("#receiver_tin").val('');
        		        	$("#delivery_ou").val('');
        		        	
        		        	$("#receiver_name").trigger("change");
        		        	$("#receiver_address1").trigger("change");
        		        	$("#receiver_address2").trigger("change");
        		        	$("#receiver_address3").trigger("change");
        		        	$("#receiver_address4").trigger("change");
        		        	$("#receiver_city").trigger("change");
        		        	$("#receiver_pincode").trigger("change");
        		        	$("#receiver_phone").trigger("change");
        		        	$("#receiver_mobile").trigger("change");
        		        	$("#receiver_email").trigger("change");
        		        	$("#receiver_tin").trigger("change");
    		        	}    		        	
    		        	return false;
    		        },    		        
    		        select: function( event, ui ) {
    		        	$("#receiver_code").val( ui.item.custCode );
    		        	$("#receiver_name").val( ui.item.custName );    		        	
    		        	$("#receiver_address1").val( ui.item.custAdd1 );
    		        	$("#receiver_address2").val( ui.item.custAdd2 );
    		        	$("#receiver_address3").val( ui.item.custAdd3 );
    		        	$("#receiver_address4").val( ui.item.custAdd4 );
    		        	$("#receiver_city").val( ui.item.custCity );
    		        	$("#receiver_pincode").val( ui.item.custPincode );
    		        	$("#receiver_phone").val( ui.item.custPhone );
    		        	$("#receiver_mobile").val( ui.item.custMobile );
    		        	$("#receiver_email").val( ui.item.custEmail );
    		        	$("#receiver_tin").val( ui.item.custTIN );
    		        	$("#delivery_ou").val( ui.item.custOU );
    		        	
    		        	$("#receiver_name").trigger("change");
    		        	$("#receiver_address1").trigger("change");
    		        	$("#receiver_address2").trigger("change");
    		        	$("#receiver_address3").trigger("change");
    		        	$("#receiver_address4").trigger("change");
    		        	$("#receiver_city").trigger("change");
    		        	$("#receiver_pincode").trigger("change");
    		        	$("#receiver_phone").trigger("change");
    		        	$("#receiver_mobile").trigger("change");
    		        	$("#receiver_email").trigger("change");
    		        	$("#receiver_tin").trigger("change");
    		          return false;
    		        }
    		      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
    		        return $( "<li>" )
    		          .append( "<span class='list-custcode'>"+ item.custCode + "</span>" + item.custName )
    		          .appendTo( ul );
    		      };
    			      
    		      $( "#shipper_pincode" ).autocomplete({
    		    	  delay: 500,
    		        minLength: 3,
    		        source: function( request, response ) {
    		            $.ajax( {
    		              method:"get",
    		              headers: {
    		            	    Accept: "application/json"
    		            	  },
    		              url: "${home}getPinCodes/"+request.term,
    		              success: function( data ) {
    		            	  response(data.items);
    		              }
    		            } );
    		          },
    		        change: function( event, ui ){
    		        	if(ui.item == null){
    		        		$( "#booking_ou" ).val('');
    		        	}    		        	  
    		        },
    		        focus: function( event, ui ) {
    		          $( "#shipper_pincode" ).val( ui.item.pincode );
    		          return false;
    		        },
    		        select: function( event, ui ) {
    		          $( "#shipper_pincode" ).val( ui.item.pincode );
    		          $( "#booking_ou" ).val( ui.item.ou_code );
    		          return false;
    		        }
    		      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
    		        return $( "<li>" )
    		          .append( "<span class='list-pin'>"+ item.pincode +"</span>"+item.location+"<span class='list-ou'>"+item.ou_code + "</span>" )
    		          .appendTo( ul );
    		      };
    		      
    		      $( "#receiver_pincode" ).autocomplete({
    		    	  	delay: 500,
    			        minLength: 3,
    			        source: function( request, response ) {
    			            $.ajax( {
    			              method:"get",
    			              headers: {
    			            	    Accept: "application/json"
    			            	  },
    			              url: "${home}getPinCodes/"+request.term,
    			              success: function( data ) {
    			            	  response(data.items);
    			              }
    			            } );
    			          },
   			          change: function(event, ui){
   			        	if(ui.item == null){
   	    		        	$( "#delivery_ou" ).val('');
   	    		        	$( "#ess_code" ).val('');
   	    		        	return false;
   			        	  }
   	    		        	
   	    		        },
    			        focus: function( event, ui ) {
    			          $( "#receiver_pincode" ).val( ui.item.pincode );			          
    			          return false;
    			        },
    			        select: function( event, ui ) {
    			          $( "#receiver_pincode" ).val( ui.item.pincode );    			          
    			          $( "#delivery_ou" ).val( ui.item.ou_code );    			          
    			          getEsscode(ui.item.pincode);
    			          return false;
    			        }
    			      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
    			        return $( "<li>" )
    			          .append( "<span class='list-pin'>"+ item.pincode +"</span>"+item.location+"<span class='list-ou'>"+item.ou_code + "</span>" )
    			          .appendTo( ul );
    			      };
                
                
            });
        </script>
    </body>

</html>

