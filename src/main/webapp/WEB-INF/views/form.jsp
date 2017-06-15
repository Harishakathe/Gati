<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="generate_xml.do" method="post" modelAttribute="pickupDetails" >
<input type="text" name="Docket_No" value="830018400">
<input type="text" name="Product" value="Express Plus20">
<input type="text" name="Booking_Basis" value="PAID">
<input type="text" name="shipper.shipper_Code " value="98899 ">
<input type="text" name="shipper.shipper_Mobile" value="89751166505">
<input type="text" name="shipper.shipper_Name" value="Sunil">
<input type="text" name="shipper.shipper_Address1" value="At Naleshawar">
<input type="text" name="shipper.shipper_Address2" value="Post Dhopi">
<input type="text" name="shipper.shipper_Address3" value="Tal, Nandeda">
<input type="text" name="shipper.shipper_Address4" value="Masharashtra">
<input type="text" name="shipper.shipper_City" value="Nandeda">
<input type="text" name="shipper.shipper_Pin_Code" value="431602">
<input type="text" name="shipper.shipper_Phone" value="9561434543">
<input type="text" name="shipper.shipper_Email" value="sunilwaghole@gmail.com">
<input type="text" name="shipper.shipper_VAT_TIN" value="12345">
<input type="text" name="receiver.receiver_Code " value="98877">
<input type="text" name="receiver.receiver_Mobile" value="897511665787">
<input type="text" name="receiver.receiver_Name" value="Harish">
<input type="text" name="receiver.receiver_Address1" value="At Nashik">
<input type="text" name="receiver.receiver_Address2" value="Nashik">
<input type="text" name="receiver.receiver_Address3" value="Tal, Nashik">
<input type="text" name="receiver.receiver_Address4" value="Masharashtra">
<input type="text" name="receiver.receiver_City" value="Nashik">
<input type="text" name="receiver.receiver_Pin_Code" value="422006">
<input type="text" name="receiver.receiver_Phone" value="2412104">
<input type="text" name="receiver.receiver_Email" value="haruishakathe@gmail.com">
<input type="text" name="receiver.receiver_VAT_TIN" value="6789">

<input type="text" name="Goods_Code" value="123">
<input type="text" name="Goods_Desc" value="Test Goods">
<input type="text" name="Booking_Pin_Code" value="123">
<input type="text" name="Delivery_Pin_Code" value="123">
<input type="text" name="No_of_Packages" value="2">
<input type="text" name="Package_number_from" value="154618088">
<input type="text" name="Package_number_to" value="154618089">
<input type="text" name="Package_Type" value="test type">
<input type="text" name="Shipment_Value" value="999999988">
<input type="text" name="Risk" value="risk">
<input type="text" name="Volume" value="99988">
<input type="text" name="UOM" value="I">
<input type="text" name="Actual_Weight" value="0.98">
<input type="text" name="COD_info" value="cinfo">
<input type="text" name="COD_Flag" value="cflag">
<input type="text" name="COD_DOD_in_Favor" value="G">
<input type="text" name="COD_DOD_Amount" value="0">
<input type="text" name="Pickup_date" value="12-08-2015">
<input type="text" name="Pickup_time" value="16:49:59">
<input type="text" name="Package_Details[0].pkg_no" value="154618088">
<input type="text" name="Package_Details[0].pkg_ln" value="18">
<input type="text" name="Package_Details[0].pkg_br" value="19">
<input type="text" name="Package_Details[0].pkg_ht" value="20">
<input type="text" name="Package_Details[0].pkg_wt" value="21">
<input type="text" name="Package_Details[1].pkg_no" value="154618089">
<input type="text" name="Package_Details[1].pkg_ln" value="18">
<input type="text" name="Package_Details[1].pkg_br" value="19">
<input type="text" name="Package_Details[1].pkg_ht" value="20">
<input type="text" name="Package_Details[1].pkg_wt" value="21">
<input type="submit" value="SEND">

</form>

</body>
</html>