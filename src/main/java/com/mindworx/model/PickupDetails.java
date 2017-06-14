package com.mindworx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name="gati")
public class PickupDetails {
	
	private String Docket_No;
	private String Product;
	private String Booking_Basis;
	private Shipper shipper;
	private Receiver receiver;
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
	private String COD_info;
	private String COD_Flag;
	private String COD_DOD_in_Favor;
	private String COD_DOD_Amount;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date Pickup_date;
	private String Pickup_time;
	@XmlElement(name="PKG_DETAILS")
	private List<Package> Package_Details = new ArrayList<Package>();
	
	public PickupDetails() {
		// TODO Auto-generated constructor stub
		shipper = new Shipper();
		receiver = new Receiver();
	}
	
	public String getDocket_No() {
		return Docket_No;
	}
	public void setDocket_No(String docket_No) {
		Docket_No = docket_No;
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
	public String getCOD_info() {
		return COD_info;
	}
	public void setCOD_info(String cOD_info) {
		COD_info = cOD_info;
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
	public Shipper getShipper() {
		return shipper;
	}
	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}
	public Receiver getReceiver() {
		return receiver;
	}
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
	
	
}
