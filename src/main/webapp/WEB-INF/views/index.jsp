<%@page session="false"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>GATI FORM</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <c:url var="home" value="/" scope="request" />
        <link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/css/jquery.steps.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css"/>
        <style type="text/css">
	        .ui-autocomplete {
			    position: absolute;
			    z-index: 1000;
			    cursor: default;
			    padding: 0;
			    margin-top: 2px;
			    list-style: none;
			    background-color: #ffffff;
			    border: 1px solid #ccc
			    -webkit-border-radius: 5px;
			       -moz-border-radius: 5px;
			            border-radius: 5px;
			    -webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
			       -moz-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
			            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
			}
			.ui-autocomplete > li {
			  padding: 3px 20px;
			}
			.ui-autocomplete > li.ui-state-focus {
			  background-color: #DDD;
			}
			.ui-helper-hidden-accessible {
			  display: none;
			}
			.list-pin{
				display: inline-block;
				min-width: 70px;				
			}
			.list-ou{
				float: right;
			}
			.list-custcode{
				display: inline-block;
				min-width: 100px;
			}
        </style>
        <script src="<c:url value="/resources/js/jquery-1.12.4.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery-ui.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery.steps.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/XMLWriter.js" />" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <section class="border">
                    <div class="content">
                        <script>
                            $(function ()
                            {
                                $("#wizard").steps({
                                    headerTag: "h2",
                                    bodyTag: "section",
                                    transitionEffect: "slideLeft",
                                 	// Triggered when clicking the Previous/Next buttons
                                     /*onStepChanging: function(e, currentIndex, newIndex) {
                                        var fv         = $('#profileForm').data('formValidation'), // FormValidation instance
                                            // The current step container
                                            $container = $('#profileForm').find('section[data-step="' + currentIndex +'"]');

                                        // If user click on "Previous" button, we just normally let he/she goes
                                        if (newIndex < currentIndex) {
                                            return true;
                                        }

                                        // Validate the container
                                        fv.validateContainer($container); 

                                    },*/
                                    onFinished: function(e, currentIndex) {
                                    	
                                        e.preventDefault();
                                        var form = $("#PickupDetailsForm");
                                        var xml = ConvertFormToXML(form);
                                        var json = ConvertFormToJSON(form);
                                        
                                        console.log(JSON.stringify(json));
                                        console.log(xml);
                                        
                                        $.ajax({
                                            type: 'post',
                                            url: '${get}validate_xml',
                                            data: xml,
                                            contentType: 'application/xml',
                                            dataType: 'xml',
                                            success: function (data) {
                                            	console.log(data);
                                            	alert(data);
                                            	
                                            },
                                            error:function(e){
                                            	alert(e);
                                            }
                                        });   
                                        
                                    }
                                });
                                
                                
                                function ConvertFormToJSON(form){
                                	
                                	var json = {};
                                	var ele = ''; var p_ele='';                                	
                                    var array = jQuery(form).serializeArray();
                                    
                                    jQuery.each(array, function() {
                                        
                                        var f_name = this.name;                                        		
                                		
                                        if(f_name.includes('.')){ 
                                        	
                                			var array_str = f_name.split('.');                                        			
                                			if(ele != array_str[0]){                                				
                                				ele = array_str[0];                                        				
                                				var ele_json_str = {};                                				
                                				if(p_ele != ele.substr(0,ele.length-3)){
                                					p_ele = ele.substr(0,ele.length-3);
                                				}                                				
                                				$.each($("input[name^='"+ele+"']"),function() {                                        					
                                					var e_name = this.name.substr(this.name.indexOf(".")+1);
                                					ele_json_str[e_name] = this.value || '';                                					
                                				});                                				
                                				json[p_ele] = (json[p_ele] || []).concat(ele_json_str);
                                			}                                			
                                		}
                                		else{
                                			json[this.name] = this.value || '';  
                                		}
                                    });                                    
                                    return json;
                                }
                                
                                function ConvertFormToXML(form){
                                    var array = jQuery(form).serializeArray();
                                    try{
	                                    var xml = $($.parseXML('<?xml version="1.0" encoding="utf-8" ?><PickupDetails />'));      //Main Root Name                          	
	                                	var ele = ''; var p_ele='';
	                                	
	                                    jQuery.each(array, function() {
	                                    	var f_name = this.name;                                        		
	                                		if(f_name.includes('.')){                                        			
	                                			
	                                			var array_str = f_name.split('.');                                        			
	                                			if(ele != array_str[0]){
	                                				
	                                				ele = array_str[0];
	                                				
	                                				if(p_ele != ele.substr(0,ele.length-3)){
	                                					p_ele = ele.substr(0,ele.length-3);
	                                					$('PickupDetails',xml).append($('<'+p_ele+' />', xml));
	                                				}
	                                				
	                                				$(p_ele,xml).append($('<PKG_INFO />', xml));
	                                				$.each($("input[name^='"+ele+"']"),function() {                                        					
	                                					var e_name = this.name.substr(this.name.indexOf(".")+1);
	                                					$('PKG_INFO',xml).last().append($('<'+e_name+' />', xml).text(this.value || ''));                                        					
	                                				});                                				
	                                			}
	                                			
	                                		}
	                                		else{
	                                			$('PickupDetails',xml).append($('<'+this.name+' />', xml).text(this.value || ''));                                   		    
	                                		}
	                                    }); 
                                    }catch(e){
                                    	alert("Converting in xml error:"+e.message);
                                    }
                                    return ((new XMLSerializer()).serializeToString(xml.context));
                                }                            
                            });
                        </script>
                        <div class="line"></div>
                        <div class="titles">
                            <div class="title-parent">
                                <h5>Shipment<br/> Details</h5>
                            </div>
                            <div class="title-parent">
                                <h5>Shipper<br/> Details</h5>
                            </div>
                            <div class="title-parent">
                                <h5>Receivers<br/> Address</h5>
                            </div>
                            <div class="title-parent">
                                <h5>Confirm<br/> Details</h5>
                            </div>
                        </div>
                        <form action="${get}validate_xml" method="post" id="PickupDetailsForm">
                        	<div id="wizard">							
								<h2>First Step</h2>
								<section>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Docket No</label>
											<input class="form-control w-control" maxlength="10" type="text" name="docket_no" id="docket_no"  >
											<input type="hidden" name="docket_type" value="NR"  >
											<input type="hidden" name="docket_category" value="D"  >
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Product</label>
											<select class="form-control" name="product" id="product">
												<option value="">-Select-</option>
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
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>BKG Basis</label>
											<select class="form-control" name="booking_basis">
											<option value="">-Select-</option>
											<option value="1">PAID</option>
											<option value="2">TBB</option>
											<option value="4">FOD</option>
											<option value="6">BOD</option>
											</select>
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Goods Type</label>
											<select class="form-control" id="goods_code" name="goods_code">
											</select>
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Shipper Code</label>
											<input class="form-control w-control" type="text" name="shipper_code" id="shipper_code">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Receiver Code</label>
											<input class="form-control w-control" type="text" name="receiver_code" id="receiver_code">
										</div>
										
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>BKG Pin Code</label>
											<input class="form-control w-control" type="text" id="shipper_pincode" name="shipper_pincode">
											<input type="hidden" id="shipper_tin" name="shipper_tin">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>DLY Pin Code</label>
											<input class="form-control w-control" type="text" id="receiver_pincode" name="receiver_pincode">
											<input type="hidden" id="receiver_tin" name="receiver_tin">
											<input type="hidden" id="esscode" name="esscode">
											
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>No of Packages</label>
													<input class="form-control w-control" type="text" name="no_of_packages">
												</div>
												<div class="col-sm-6">
													<label>Pkg No From</label>
													<input class="form-control w-control" type="text" name="package_number_from">
												</div>
											</div>
										</div>
										<div class="col-sm-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>Pkg No To</label>
													<input class="form-control w-control" type="text" name="package_number_to">
												</div>
												<div class="col-sm-6">
													<label>Package Type</label>
													<select class="form-control" name="package_type">
														<option value="">Select</option>
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
														<option value="4">4</option>
														<option value="5">5</option>
													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>Length</label>
													<input class="form-control w-control" type="text" name="package_details[0].pkg_ln">
												</div>
												<div class="col-sm-6">
													<label>Breadth</label>
													<input class="form-control w-control" type="text" name="package_details[0].pkg_br">
												</div>
											</div>
										</div>
										<div class="col-sm-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>Height</label>
													<input class="form-control w-control" type="text" name="package_details[0].pkg_ht">
												</div>
												<div class="col-sm-6">
													<label>Weight</label>
													<input class="form-control w-control" type="text" name="package_details[0].pkg_wt">
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>Length</label>
													<input class="form-control w-control" type="text" name="package_details[1].pkg_ln">
												</div>
												<div class="col-sm-6">
													<label>Breadth</label>
													<input class="form-control w-control" type="text" name="package_details[1].pkg_br">
												</div>
											</div>
										</div>
										<div class="col-sm-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>Height</label>
													<input class="form-control w-control" type="text" name="package_details[1].pkg_ht">
												</div>
												<div class="col-sm-6">
													<label>Weight</label>
													<input class="form-control w-control" type="text" name="package_details[1].pkg_wt">
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Shipment Value</label>
											<input class="form-control w-control" type="text" name="shipment_value">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Risk</label>
											<select class="form-control" name="risk">											
												<option value="">--Select--</option>
												<option value="Gati">Gati</option>
												<option value="Owner">Owner</option>											
											</select>
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Volume</label>
											<input class="form-control w-control" type="text" name="volume">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>UOM</label>
											<select class="form-control" name="UOM">
												<option value="">--Select--</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
											</select>
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>ACT. WT</label>
											<input class="form-control w-control" type="text" name="actual_weight">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>COD/DOD Flag</label>
											<select class="form-control" name="cod_flag" id="cod_flag">
												<option value="">--Select--</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
											</select>
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>COD/DOD in Fav</label>
											<select class="form-control" name="cod_dod_in_favor">
											    <option value="">--Select--</option>
												<option value="Gati">Gati</option>
												<option value="Shipper">Shipper</option>
											</select>
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>COD/DOD Amt</label>
											<input class="form-control w-control" type="text" name="cod_dod_amount">
										</div>
									</div> 
								</section>

								<h2>Second Step</h2>
								<section>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Shipper Code</label>
											<input class="form-control w-control" type="text" name="shipper_code1" id="shipper_code1"  >
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Mobile No</label>
											<input class="form-control w-control" type="text" name="shipper_mobile" id="shipper_mobile">
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Name</label>
											<input class="form-control w-control" type="text" name="shipper_name" id="shipper_name">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Phone No</label>
											<input class="form-control w-control" type="text" name="shipper_phone" id="shipper_phone">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 1</label>
											<input class="form-control w-control" type="text" name="shipper_address1" id="shipper_address1">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 2</label>
											<input class="form-control w-control" type="text" name="shipper_address2" id="shipper_address2">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 3</label>
											<input class="form-control w-control" type="text" name="shipper_address3" id="shipper_address3">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 4</label>
											<input class="form-control w-control" type="text" name="shipper_address4" id="shipper_address4">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>City</label>
											<input class="form-control w-control" type="text" name="shipper_city" id="shipper_city">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Pin Code</label>
											<input class="form-control w-control" type="text" name="shipper_pincode" id="shipper_pincode">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Email</label>
											<input class="form-control w-control" type="text" name="shipper_email" id="shipper_email">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>VAT/TIN</label>
											<input class="form-control w-control" type="text" name="shipper_tin" id="shipper_tin">
										</div>
									</div>
								</section>
								<h2>Third Step</h2>
								<section>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Receiver Code</label>
											<input class="form-control w-control" type="text" name="receiver_code1" id="receiver_code1">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Mobile No</label>
											<input class="form-control w-control" type="text" name="receiver_mobile" id="receiver_mobile">
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Name</label>
											<input class="form-control w-control" type="text" name="receiver_name" id="receiver_name"> 
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Phone No</label>
											<input class="form-control w-control" type="text" name="receiver_phone" id="receiver_phone">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 1</label>
											<input class="form-control w-control" type="text" name="receiver_address1" id="receiver_address1">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 2</label>
											<input class="form-control w-control" type="text" name="receiver_address2" id="receiver_address2">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 3</label>
											<input class="form-control w-control" type="text" name="receiver_address3" id="receiver_address3">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 4</label>
											<input class="form-control w-control" type="text" name="receiver_address4" id="receiver_address4">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>City</label>
											<input class="form-control w-control" type="text" name="receiver_city" id="receiver_city">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Pin Code</label>
											<input class="form-control w-control" type="text" name="receiver_pincode" id="receiver_pincode">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Email</label>
											<input class="form-control w-control" type="text" name="receiver_email" id="receiver_email">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>VAT/TIN</label>
											<input class="form-control w-control" type="text" name="receiver_tin" id="receiver_tin">
										</div>
									</div>
								</section>

								<h2>Forth Step</h2>
								<section>
                                <div class="row">
                                    <div class="col-sm-10 col-sm-offset-1 m-b-sm">
                                        <div class="header-strip">
                                            <h3>Shipment Details</h3>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-5 col-sm-offset-2 labels">
                                            <label><strong>Docket No</strong> : </label>
                                            <label><strong>BKG. Basis</strong> : </label>
                                            <label><strong>Receiver Code</strong> :</label>
                                            <label><strong>BKG Pin Code</strong> : 543213</label>
                                            <label><strong>No Of Packages</strong> : 5</label>
                                            <label><strong>Shipment Value</strong> : $ 100</label>
                                            <label><strong>Volume</strong> : 121 LBS</label>
                                            <label><strong>ACT. WT</strong> : 150 KG</label>
                                            <label><strong>COD/DOD in Fav</strong> : lorem ipsum</label>
                                        </div>
                                        <div class="col-sm-5 labels">
                                            <label><strong>Product</strong> : ABCD</label>
                                            <label><strong>Shipper Code</strong> : 12423</label>
                                            <label><strong>Goods Type</strong> : lorem ipsum</label>
                                            <label><strong>DLY Pin Code</strong> : 54321</label>
                                            <label><strong>Packing Type</strong> : lorem ipsum</label>
                                            <label><strong>UOM</strong> : Feet</label>
                                            <label><strong>COD/DOD Flag</strong> : lorem ipsum</label>
                                            <label><strong>ACT. WT</strong> : 150 KG</label>
                                            <label><strong>COD/DOD Amt</strong> : $100</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                                <div class="row m-t-lg">
                                    <div class="col-sm-10 col-sm-offset-1 m-b-sm">
                                        <div class="header-strip">
                                            <h3>Shipper Details</h3>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-5 col-sm-offset-2 labels">
                                            <label><strong>Shipper Code</strong> : 543213</label>
                                            <label><strong>Name</strong> : Jonny Bravo</label>
                                            <label><strong>Address Line 1</strong> : lorem ipsum dolor sit amet</label>
                                            <label><strong>Address Line 3</strong> : lorem ipsum dolor sit amet</label>
                                            <label><strong>City</strong> : Bangalore</label>
                                            <label><strong>Email</strong> : jonny@gmail.com</label>
                                        </div>
                                        <div class="col-sm-5 labels">
                                            <label><strong>Mobile</strong> : 985 214 5002</label>
                                            <label><strong>Phone</strong> : 620 521 220</label>
                                            <label><strong>Address Line 2</strong> : lorem ipsum</label>
                                            <label><strong>Address Line 4</strong> : lorem ipsum dolor sit amet</label>
                                            <label><strong>Pin Code</strong> : 124 523</label>
                                            <label><strong>VAT/TIN</strong> : -</label>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="clearfix"></div>
                                <div class="row m-t-lg">
                                    <div class="col-sm-10 col-sm-offset-1 m-b-sm">
                                        <div class="header-strip">
                                            <h3>Receivers Address</h3>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-5 col-sm-offset-2 labels">
                                            <label><strong>Receiver Code</strong> : 543213</label>
                                            <label><strong>Name</strong> : Jonny Bravo</label>
                                            <label><strong>Address Line 1</strong> : lorem ipsum dolor sit amet</label>
                                            <label><strong>Address Line 3</strong> : lorem ipsum dolor sit amet</label>
                                            <label><strong>City</strong> : Bangalore</label>
                                            <label><strong>Email</strong> : jonny@gmail.com</label>
                                        </div>
                                        <div class="col-sm-5 labels">
                                            <label><strong>Mobile</strong> : 985 214 5002</label>
                                            <label><strong>Phone</strong> : 620 521 220</label>
                                            <label><strong>Address Line 2</strong> : lorem ipsum</label>
                                            <label><strong>Address Line 4</strong> : lorem ipsum dolor sit amet</label>
                                            <label><strong>Pin Code</strong> : 124 523</label>
                                            <label><strong>VAT/TIN</strong> : -</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="m-t-lg"></div>
                            </section>							
						</div>
						</form>
                    </div>
                </section>
            </div>
        </div>
        <script type="text/javascript">
        $( function() {
        	
        	 
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
		            	  $("#esscode").val(data.ess_code);		            	  		                  
		              },
		              error: function() {
		                  alert("Failed to load Esscode");
		              }		              
		            });
        	 }
        	 
        	 fillGoodType();
	        
		      $( "#shipper_code" ).autocomplete({
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
			          return false;
			        }
			      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
			        return $( "<li>" )
			          .append( "<span class='list-custcode'>"+ item.custCode + "</span>" + item.custName )
			          .appendTo( ul );
			      };
		      
		      $( "#receiver_code" ).autocomplete({
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
		          return false;
		        }
		      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
		        return $( "<li>" )
		          .append( "<span class='list-custcode'>"+ item.custCode + "</span>" + item.custName )
		          .appendTo( ul );
		      };
			      
		      $( "#shipper_pincode" ).autocomplete({
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
		        focus: function( event, ui ) {
		          $( "#shipper_pincode" ).val( ui.item.pincode );
		          return false;
		        },
		        select: function( event, ui ) {
		          $( "#shipper_pincode" ).val( ui.item.pincode );
		          $( "#shipper_tin" ).val( ui.item.ou_code );
		          return false;
		        }
		      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
		        return $( "<li>" )
		          .append( "<span class='list-pin'>"+ item.pincode +"</span>"+item.location+"<span class='list-ou'>"+item.ou_code + "</span>" )
		          .appendTo( ul );
		      };
		      
		      $( "#receiver_pincode" ).autocomplete({
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
			        focus: function( event, ui ) {
			          $( "#receiver_pincode" ).val( ui.item.pincode );			          
			          return false;
			        },
			        select: function( event, ui ) {
			          $( "#receiver_pincode" ).val( ui.item.pincode );
			          $( "#receiver_tin" ).val( ui.item.ou_code );
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