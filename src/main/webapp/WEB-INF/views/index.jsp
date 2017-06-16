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
        <script src="<c:url value="/resources/js/jquery-1.12.4.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery-ui.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery.steps.js" />" type="text/javascript"></script>
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
                                    transitionEffect: "slideLeft"
                                });
                            });
                        </script>
                        <div class="line"></div>
                        <div class="titles">
                            <div class="title-parent">
                                <h5>Shipment<br/> ${home}</h5>
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
                        <form action="generate_xml.do" method="post" modelAttribute="pickupDetails">
                        	<div id="wizard">							
								<h2>First Step</h2>
								<section>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Docket No</label>
											<input class="form-control w-control" maxlength="10" type="text" name="Docket_No" id="Docket_No"  >
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Product</label>
											<select class="form-control" name="Product" id="Product">
												<option value="">Select</option>
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
											<select class="form-control" name="Booking_Basis">
											<option value="">Select</option>
											<option value="1">PAID</option>
											<option value="2">TBB</option>
											<option value="4">FOD</option>
											<option value="6">BOD</option>    
											   
									            
												
												
											</select>
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Goods Type</label>
											<select class="form-control" name="Goods_Code">
												<option>Select</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Shipper Code</label>
											<input class="form-control w-control" type="text" name="Shipper_Code" id="Shipper_Code">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Receiver Code</label>
											<input class="form-control w-control" type="text" name="Receiver_Code" id="Receiver_Code">
										</div>
										
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>BKG Pin Code</label>
											<input class="form-control w-control" type="text" name="Shipper_Pincode">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>DLY Pin Code</label>
											<input class="form-control w-control" type="text" name="Receiver_Pincode">
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>No of Packages</label>
													<input class="form-control w-control" type="text" name="No_of_Packages">
												</div>
												<div class="col-sm-6">
													<label>Pkg No From</label>
													<input class="form-control w-control" type="text" name="Package_number_from">
												</div>
											</div>
										</div>
										<div class="col-sm-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>Pkg No To</label>
													<input class="form-control w-control" type="text" name="Package_number_to">
												</div>
												<div class="col-sm-6">
													<label>Packing Type</label>
													<select class="form-control" name="Package_Type">
														<option>Select</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
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
													<input class="form-control w-control" type="text" name="Package_Details[0].pkg_ln">
												</div>
												<div class="col-sm-6">
													<label>Breadth</label>
													<input class="form-control w-control" type="text" name="Package_Details[0].pkg_br">
												</div>
											</div>
										</div>
										<div class="col-sm-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>Height</label>
													<input class="form-control w-control" type="text" name="Package_Details[0].pkg_ht">
												</div>
												<div class="col-sm-6">
													<label>Weight</label>
													<input class="form-control w-control" type="text" name="Package_Details[0].pkg_wt">
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Shipment Value</label>
											<input class="form-control w-control" type="text" name="Shipment_Value">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Risk</label>
											<select class="form-control" name="Risk">
											
											<option value="">Select</option>
											<option value="1">Gati</option>
											<option value="2">Owner</option>
											
											</select>
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Volume</label>
											<input class="form-control w-control" type="text" name="Volume">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>UOM</label>
											<select class="form-control" name="UOM">
												<option>Select</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>ACT. WT</label>
											<input class="form-control w-control" type="text" name="Actual_Weight">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>COD/DOD Flag</label>
											<select class="form-control" name="COD_Flag">
												<option>Select</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>COD/DOD in Fav</label>
											<select class="form-control" name="COD_DOD_in_Favor">
										    <option value="">Select</option>
											<option value="Gati">1</option>
											<option value="Shipper">2</option>
											</select>
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>COD/DOD Amt</label>
											<input class="form-control w-control" type="text" name="COD_DOD_Amount">
										</div>
									</div> 
								</section>

								<h2>Second Step</h2>
								<section>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Shipper Code</label>
											<input class="form-control w-control" type="text" name="Shipper_Code" >
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Mobile No</label>
											<input class="form-control w-control" type="text" name="Shipper_Mobile">
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Name</label>
											<input class="form-control w-control" type="text" name="Shipper_Name">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Phone No</label>
											<input class="form-control w-control" type="text" name="Shipper_Phone">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 1</label>
											<input class="form-control w-control" type="text" name="Shipper_Address1">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 2</label>
											<input class="form-control w-control" type="text" name="Shipper_Address2">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 3</label>
											<input class="form-control w-control" type="text" name="Shipper_Address3">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 4</label>
											<input class="form-control w-control" type="text" name="Shipper_Address4">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>City</label>
											<input class="form-control w-control" type="text" name="Shipper_City">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Pin Code</label>
											<input class="form-control w-control" type="text" name="Shipper_Pincode">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Email</label>
											<input class="form-control w-control" type="text" name="Shipper_Email">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>VAT/TIN</label>
											<input class="form-control w-control" type="text" name="Shipper_TIN">
										</div>
									</div>
								</section>

								<h2>Third Step</h2>
								<section>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Receiver Code</label>
											<input class="form-control w-control" type="text" name="Receiver_Code">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Mobile No</label>
											<input class="form-control w-control" type="text" name="Receiver_Mobile">
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Name</label>
											<input class="form-control w-control" type="text" name="Receiver_Name">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Phone No</label>
											<input class="form-control w-control" type="text" name="Receiver_Phone">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 1</label>
											<input class="form-control w-control" type="text" name="Receiver_Address1">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 2</label>
											<input class="form-control w-control" type="text" name="Receiver_Address2">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 3</label>
											<input class="form-control w-control" type="text" name="Receiver_Address3">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 4</label>
											<input class="form-control w-control" type="text" name="Receiver_Address4">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>City</label>
											<input class="form-control w-control" type="text" name="Receiver_City">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Pin Code</label>
											<input class="form-control w-control" type="text" name="Receiver_Pincode">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Email</label>
											<input class="form-control w-control" type="text" name="Receiver_Email">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>VAT/TIN</label>
											<input class="form-control w-control" type="text" name="Receiver_TIN">
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
                                            <label><strong>Docket No</strong> : 543213</label>
                                            <label><strong>BKG. Basis</strong> : lorem ipsum</label>
                                            <label><strong>Receiver Code</strong> : 543213</label>
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
	        
		      $( "#Shipper_Code" ).autocomplete({
			        minLength: 3,
			        source: function( request, response ) {
			            $.ajax( {
			              method:"get",
			              url: "${get}getCustomerDetails/"+request.term,
			              success: function( data ) {
			                response( data.customers );
			              }
			            } );
			          },       
			        focus: function( event, ui ) {
			          $("#Shipper_Code").val( ui.item.custCode );
			          return false;
			        },
			        select: function( event, ui ) {
			        	$("#Shipper_Code").val( ui.item.custCode );
			        	$("#Shipper_Name").val( ui.item.custName );
			        	$("#Shipper_Add1").val( ui.item.custAdd1 );
			        	$("#Shipper_Add2").val( ui.item.custAdd2 );
			        	$("#Shipper_Add3").val( ui.item.custAdd3 );
			        	$("#Shipper_Add4").val( ui.item.custAdd4 );
			        	$("#Shipper_City").val( ui.item.custCity );
			        	$("#Shipper_Pincode").val( ui.item.custPincode );
			        	$("#Shipper_Phone").val( ui.item.custPhone );
			        	$("#Shipper_Mobile").val( ui.item.custMobile );
			        	$("#Shipper_Email").val( ui.item.custEmail );
			        	$("#Shipper_TIN").val( ui.item.custTIN );
			          return false;
			        }
			      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
			        return $( "<li>" )
			          .append( "<div>" + item.custCode + "<br>" + item.custName + "</div>" )
			          .appendTo( ul );
			      };
		      
		      $( "#Receiver_Code" ).autocomplete({
		        minLength: 3,
		        source: function( request, response ) {
		            $.ajax( {
		              method:"get",
		              url: "${get}getCustomerDetails/"+request.term,
		              success: function( data ) {
		                response( data.customers );
		              }
		            } );
		          },       
		        focus: function( event, ui ) {
		          $("#Receiver_Code").val( ui.item.custCode );
		          return false;
		        },
		        select: function( event, ui ) {
		        	$("#Receiver_Code").val( ui.item.custCode );
		        	$("#Receiver_Name").val( ui.item.custName );
		        	$("#Receiver_Add1").val( ui.item.custAdd1 );
		        	$("#Receiver_Add2").val( ui.item.custAdd2 );
		        	$("#Receiver_Add3").val( ui.item.custAdd3 );
		        	$("#Receiver_Add4").val( ui.item.custAdd4 );
		        	$("#Receiver_City").val( ui.item.custCity );
		        	$("#Receiver_Pincode").val( ui.item.custPincode );
		        	$("#Receiver_Phone").val( ui.item.custPhone );
		        	$("#Receiver_Mobile").val( ui.item.custMobile );
		        	$("#Receiver_Email").val( ui.item.custEmail );
		        	$("#Receiver_TIN").val( ui.item.custTIN );	   
		          return false;
		        }
		      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
		        return $( "<li>" )
		          .append( "<div>" + item.custCode + "<br>" + item.custName + "</div>" )
		          .appendTo( ul );
		      };
			      
		      $( "#Shipper_Pincode" ).autocomplete({
		        minLength: 3,
		        source: function( request, response ) {
		            $.ajax( {
		              method:"get",
		              url: "${home}getPinCodes/"+request.term,
		              success: function( data ) {
		                response( data );
		              }
		            } );
		          },
		        focus: function( event, ui ) {
		          $( "#Shipper_Pincode" ).val( ui.item.label );
		          return false;
		        },
		        select: function( event, ui ) {
		          $( "#project" ).val( ui.item.label );
		          return false;
		        }
		      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
		        return $( "<li>" )
		          .append( "<div>" + item.label + "<br>" + item.desc + "</div>" )
		          .appendTo( ul );
		      };
        });
        </script>
    </body>
</html>