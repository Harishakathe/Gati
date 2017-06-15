<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>GATI FORM</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/css/jquery.steps.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="/resources/js/jquery-2.1.1.js" />" type="text/javascript"></script>
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
                        <div id="wizard">
							<form action="generate_xml.do" method="post" modelAttribute="pickupDetails">
								<h2>First Step</h2>
								<section>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Docket No</label>
											<input class="form-control w-control" maxlength="10" type="text" id="Docket_No" name="Docket_No" >
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Product</label>
											<select class="form-control">
												<option value="">Select</option>
												<option value="Surface Express 25">Surface Express 25</option>
												<option value="Surface Express 25">Express Plus20</option>
												<option value="Surface Express 25">Gati-Laabh5</option>
												<option value="Surface Express 25">Gati-D2DC 67</option>
												<option value="Surface Express 25">Gati-Light65</option>
												<option value="Surface Express 25">Secure Box80</option>
												<option value="Surface Express 25">Standard 2</option>
												<option value="Surface Express 25">Preminum14_1</option>
												<option value="Surface Express 25">Premium Plus-12 hrs14_2</option>
												<option value="Premium Plus-24 hrs14_3">Premium Plus-24 hrs14_3</option>

											</select>
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>BKG Basis</label>
											<select class="form-control">
											<option value="">Select</option>
											<option value="1">PAID</option>
											<option value="2">TBB</option>
											<option value="4">FOD</option>
											<option value="6">BOD</option>    
											   
									            
												
												
											</select>
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Goods Type</label>
											<select class="form-control">
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
											<label>Receiver Code</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Shipper Code</label>
											<input class="form-control w-control" type="text">
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>BKG Pin Code</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>DLY Pin Code</label>
											<input class="form-control w-control" type="text">
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>No of Packages</label>
													<input class="form-control w-control" type="text">
												</div>
												<div class="col-sm-6">
													<label>Pkg No From</label>
													<input class="form-control w-control" type="text">
												</div>
											</div>
										</div>
										<div class="col-sm-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>Pkg No To</label>
													<input class="form-control w-control" type="text">
												</div>
												<div class="col-sm-6">
													<label>Packing Type</label>
													<select class="form-control">
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
													<input class="form-control w-control" type="text">
												</div>
												<div class="col-sm-6">
													<label>Breadth</label>
													<input class="form-control w-control" type="text">
												</div>
											</div>
										</div>
										<div class="col-sm-3 m-b-sm">
											<div class="row">
												<div class="col-sm-6">
													<label>Height</label>
													<input class="form-control w-control" type="text">
												</div>
												<div class="col-sm-6">
													<label>Weight</label>
													<input class="form-control w-control" type="text">
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Shipment Value</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Risk</label>
											<select class="form-control">
											
											<option value="">Select</option>
											<option value="1">Gati</option>
											<option value="2">Owner</option>
											
											</select>
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Volume</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>UOM</label>
											<select class="form-control">
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
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>COD/DOD Flag</label>
											<select class="form-control">
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
											<select class="form-control">
										    <option value="">Select</option>
											<option value="Gati">1</option>
											<option value="Shipper">2</option>
											</select>
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>COD/DOD Amt</label>
											<input class="form-control w-control" type="text">
										</div>
									</div> 
								</section>

								<h2>Second Step</h2>
								<section>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Shipper Code</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Mobile No</label>
											<input class="form-control w-control" type="text">
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Name</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Phone No</label>
											<input class="form-control w-control" type="text">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 1</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 2</label>
											<input class="form-control w-control" type="text">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 3</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 4</label>
											<input class="form-control w-control" type="text">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>City</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Pin Code</label>
											<input class="form-control w-control" type="text">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Email</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>VAT/TIN</label>
											<input class="form-control w-control" type="text">
										</div>
									</div>
								</section>

								<h2>Third Step</h2>
								<section>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Receiver Code</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Mobile No</label>
											<input class="form-control w-control" type="text">
										</div>
									</div> 
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Name</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Phone No</label>
											<input class="form-control w-control" type="text">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 1</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 2</label>
											<input class="form-control w-control" type="text">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Address Line 3</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Address Line 4</label>
											<input class="form-control w-control" type="text">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>City</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>Pin Code</label>
											<input class="form-control w-control" type="text">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3 col-sm-offset-3 m-b-sm">
											<label>Email</label>
											<input class="form-control w-control" type="text">
										</div>
										<div class="col-sm-3 m-b-sm">
											<label>VAT/TIN</label>
											<input class="form-control w-control" type="text">
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
							</form>
						</div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>