package com.mindworx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name="PickupDetails")
public class PickupDetails {
	
	private String Docket_No;
	private String Docket_Type;
	private String Docket_Category;
	private String Product;
	private String Booking_Basis;
	
	private String Shipper_Code;
	private String Shipper_Name;
	private String Shipper_Address1;
	private String Shipper_Address2;
	private String Shipper_Address3;
	private String Shipper_Address4;
	private String Shipper_City;
	private String Shipper_Pincode;
	private String Shipper_Oucode;
	private String Shipper_Phone;
	private String Shipper_Mobile;
	private String Shipper_Email;
	private String Shipper_TIN;
	
	private String Receiver_Code;
	private String Receiver_Mobile;
	private String Receiver_Name;
	private String Receiver_Address1;
	private String Receiver_Address2;
	private String Receiver_Address3;
	private String Receiver_Address4;
	private String Receiver_City;
	private String Receiver_Pincode;
	private String Receiver_Oucode;
	private String Receiver_Phone;
	private String Receiver_Email;
	private String Receiver_TIN;
		
	private String Goods_Code;
	private String Goods_Desc;
	private String Booking_Pin_Code;
	private String Delivery_Pin_Code;
	private String No_of_Packages;
	private String Package_number_from;
	private String Package_number_to;
	private String Package_Type;
	private String Shipment_Value;
	private String Risk;
	private String Volume;
	private String UOM;
	private String Actual_Weight;
	private String COD_Flag;
	private String COD_DOD_in_Favor;
	private String COD_DOD_Amount;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date Pickup_date;
	private String Pickup_time;
	@XmlElement(name="PKG_DETAILS")
	private List<Package> Package_Details = new ArrayList<Package>();
	
	public PickupDetails() {
	}
	
	public String getDocket_No() {
		return Docket_No;
	}
	public void setDocket_No(String docket_No) {
		Docket_No = docket_No;
	}
	
	
	public String getDocket_Type() {
		return Docket_Type;
	}

	public void setDocket_Type(String docket_Type) {
		Docket_Type = docket_Type;
	}

	public String getDocket_Category() {
		return Docket_Category;
	}

	public void setDocket_Category(String docket_Category) {
		Docket_Category = docket_Category;
	}

	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public String getBooking_Basis() {
		return Booking_Basis;
	}
	public void setBooking_Basis(String booking_Basis) {
		Booking_Basis = booking_Basis;
	}	
	
	public String getGoods_Code() {
		return Goods_Code;
	}
	public void setGoods_Code(String goods_Code) {
		Goods_Code = goods_Code;
	}
	public String getGoods_Desc() {
		return Goods_Desc;
	}
	public void setGoods_Desc(String goods_Desc) {
		Goods_Desc = goods_Desc;
	}
	public String getBooking_Pin_Code() {
		return Booking_Pin_Code;
	}
	public void setBooking_Pin_Code(String booking_Pin_Code) {
		Booking_Pin_Code = booking_Pin_Code;
	}
	public String getDelivery_Pin_Code() {
		return Delivery_Pin_Code;
	}
	public void setDelivery_Pin_Code(String delivery_Pin_Code) {
		Delivery_Pin_Code = delivery_Pin_Code;
	}
	public String getNo_of_Packages() {
		return No_of_Packages;
	}
	public void setNo_of_Packages(String no_of_Packages) {
		No_of_Packages = no_of_Packages;
	}
	public String getPackage_number_from() {
		return Package_number_from;
	}
	public void setPackage_number_from(String package_number_from) {
		Package_number_from = package_number_from;
	}
	public String getPackage_number_to() {
		return Package_number_to;
	}
	public void setPackage_number_to(String package_number_to) {
		Package_number_to = package_number_to;
	}
	public String getPackage_Type() {
		return Package_Type;
	}
	public void setPackage_Type(String package_Type) {
		Package_Type = package_Type;
	}
	public String getShipment_Value() {
		return Shipment_Value;
	}
	public void setShipment_Value(String shipment_Value) {
		Shipment_Value = shipment_Value;
	}
	public String getRisk() {
		return Risk;
	}
	public void setRisk(String risk) {
		Risk = risk;
	}
	public String getVolume() {
		return Volume;
	}
	public void setVolume(String volume) {
		Volume = volume;
	}
	public String getUOM() {
		return UOM;
	}
	public void setUOM(String uOM) {
		UOM = uOM;
	}
	public String getActual_Weight() {
		return Actual_Weight;
	}
	public void setActual_Weight(String actual_Weight) {
		Actual_Weight = actual_Weight;
	}	
	public String getCOD_Flag() {
		return COD_Flag;
	}
	public void setCOD_Flag(String cOD_Flag) {
		COD_Flag = cOD_Flag;
	}
	public String getCOD_DOD_in_Favor() {
		return COD_DOD_in_Favor;
	}
	public void setCOD_DOD_in_Favor(String cOD_DOD_in_Favor) {
		COD_DOD_in_Favor = cOD_DOD_in_Favor;
	}
	public String getCOD_DOD_Amount() {
		return COD_DOD_Amount;
	}
	public void setCOD_DOD_Amount(String cOD_DOD_Amount) {
		COD_DOD_Amount = cOD_DOD_Amount;
	}
	public Date getPickup_date() {
		return Pickup_date;
	}
	public void setPickup_date(Date pickup_date) {
		Pickup_date = pickup_date;
	}
	public String getPickup_time() {
		return Pickup_time;
	}
	public void setPickup_time(String pickup_time) {
		Pickup_time = pickup_time;
	}
	public List<Package> getPackage_Details() {
		return Package_Details;
	}
	public void setPackage_Details(List<Package> package_Details) {
		Package_Details = package_Details;
	}	
	public String getShipper_Code() {
		return Shipper_Code;
	}

	public void setShipper_Code(String shipper_Code) {
		Shipper_Code = shipper_Code;
	}

	public String getShipper_Name() {
		return Shipper_Name;
	}

	public void setShipper_Name(String shipper_Name) {
		Shipper_Name = shipper_Name;
	}

	public String getShipper_Address1() {
		return Shipper_Address1;
	}

	public void setShipper_Address1(String shipper_Address1) {
		Shipper_Address1 = shipper_Address1;
	}

	public String getShipper_Address2() {
		return Shipper_Address2;
	}

	public void setShipper_Address2(String shipper_Address2) {
		Shipper_Address2 = shipper_Address2;
	}

	public String getShipper_Address3() {
		return Shipper_Address3;
	}

	public void setShipper_Address3(String shipper_Address3) {
		Shipper_Address3 = shipper_Address3;
	}

	public String getShipper_Address4() {
		return Shipper_Address4;
	}

	public void setShipper_Address4(String shipper_Address4) {
		Shipper_Address4 = shipper_Address4;
	}

	public String getShipper_City() {
		return Shipper_City;
	}

	public void setShipper_City(String shipper_City) {
		Shipper_City = shipper_City;
	}

	public String getShipper_Pincode() {
		return Shipper_Pincode;
	}

	public void setShipper_Pincode(String shipper_Pincode) {
		Shipper_Pincode = shipper_Pincode;
	}

	public String getShipper_Phone() {
		return Shipper_Phone;
	}

	public void setShipper_Phone(String shipper_Phone) {
		Shipper_Phone = shipper_Phone;
	}

	public String getShipper_Mobile() {
		return Shipper_Mobile;
	}

	public void setShipper_Mobile(String shipper_Mobile) {
		Shipper_Mobile = shipper_Mobile;
	}

	public String getShipper_Email() {
		return Shipper_Email;
	}

	public void setShipper_Email(String shipper_Email) {
		Shipper_Email = shipper_Email;
	}

	public String getShipper_TIN() {
		return Shipper_TIN;
	}

	public void setShipper_TIN(String shipper_TIN) {
		Shipper_TIN = shipper_TIN;
	}

	public String getReceiver_Code() {
		return Receiver_Code;
	}

	public void setReceiver_Code(String receiver_Code) {
		Receiver_Code = receiver_Code;
	}

	public String getReceiver_Mobile() {
		return Receiver_Mobile;
	}

	public void setReceiver_Mobile(String receiver_Mobile) {
		Receiver_Mobile = receiver_Mobile;
	}

	public String getReceiver_Name() {
		return Receiver_Name;
	}

	public void setReceiver_Name(String receiver_Name) {
		Receiver_Name = receiver_Name;
	}

	public String getReceiver_Address1() {
		return Receiver_Address1;
	}

	public void setReceiver_Address1(String receiver_Address1) {
		Receiver_Address1 = receiver_Address1;
	}

	public String getReceiver_Address2() {
		return Receiver_Address2;
	}

	public void setReceiver_Address2(String receiver_Address2) {
		Receiver_Address2 = receiver_Address2;
	}

	public String getReceiver_Address3() {
		return Receiver_Address3;
	}

	public void setReceiver_Address3(String receiver_Address3) {
		Receiver_Address3 = receiver_Address3;
	}

	public String getReceiver_Address4() {
		return Receiver_Address4;
	}

	public void setReceiver_Address4(String receiver_Address4) {
		Receiver_Address4 = receiver_Address4;
	}

	public String getReceiver_City() {
		return Receiver_City;
	}

	public void setReceiver_City(String receiver_City) {
		Receiver_City = receiver_City;
	}

	public String getReceiver_Pincode() {
		return Receiver_Pincode;
	}

	public void setReceiver_Pincode(String receiver_Pincode) {
		Receiver_Pincode = receiver_Pincode;
	}

	public String getReceiver_Phone() {
		return Receiver_Phone;
	}

	public void setReceiver_Phone(String receiver_Phone) {
		Receiver_Phone = receiver_Phone;
	}

	public String getReceiver_Email() {
		return Receiver_Email;
	}

	public void setReceiver_Email(String receiver_Email) {
		Receiver_Email = receiver_Email;
	}

	public String getReceiver_TIN() {
		return Receiver_TIN;
	}

	public void setReceiver_TIN(String receiver_TIN) {
		Receiver_TIN = receiver_TIN;
	}
	
	public String getShipper_Oucode() {
		return Shipper_Oucode;
	}
	public void setShipper_Oucode(String shipper_Oucode) {
		Shipper_Oucode = shipper_Oucode;
	}

	public String getReceiver_Oucode() {
		return Receiver_Oucode;
	}

	public void setReceiver_Oucode(String receiver_Oucode) {
		Receiver_Oucode = receiver_Oucode;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}

	
	
}
