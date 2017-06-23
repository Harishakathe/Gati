package com.mindworx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement
public class PickupDetails {
	
	private String docket_no;
	private String docket_type;
	private String docket_category;
	private String product;
	private String booking_basis;	
	private String shipper_code;
	private String shipper_name;
	private String shipper_address1;
	private String shipper_address2;
	private String shipper_address3;
	private String shipper_address4;
	private String shipper_city;
	private String shipper_pincode;
	private String shipper_oucode;
	private String shipper_phone;
	private String shipper_mobile;
	private String shipper_email;
	private String shipper_tin;	
	private String receiver_code;
	private String receiver_mobile;
	private String receiver_name;
	private String receiver_address1;
	private String receiver_address2;
	private String receiver_address3;
	private String receiver_address4;
	private String receiver_city;
	private String receiver_pincode;
	private String receiver_oucode;
	private String receiver_phone;
	private String receiver_email;
	private String receiver_tin;		
	private String goods_code;
	private String goods_desc;
	private String booking_ou;
	private String delivery_ou;
	private String no_of_packages;
	private String package_number_from;
	private String package_number_to;
	private String package_type;
	private String Shipment_value;
	private String risk;
	private String volume;
	private String uom;
	private String actual_weight;
	private String cod_flag;
	private String cod_dod_in_favor;
	private String cod_dod_amount;
	private String ess_code;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date pickup_date;
	private String pickup_time;
	private List<PackageDetails> package_details = new ArrayList<PackageDetails>();
	
	public PickupDetails() {
	}
		
	public String getDocket_no() {
		return docket_no;
	}

	public void setDocket_no(String docket_no) {
		this.docket_no = docket_no;
	}

	public String getDocket_type() {
		return docket_type;
	}

	public void setDocket_type(String docket_type) {
		this.docket_type = docket_type;
	}

	public String getDocket_category() {
		return docket_category;
	}

	public void setDocket_category(String docket_category) {
		this.docket_category = docket_category;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getBooking_basis() {
		return booking_basis;
	}

	public void setBooking_basis(String booking_basis) {
		this.booking_basis = booking_basis;
	}

	public String getShipper_code() {
		return shipper_code;
	}

	public void setShipper_code(String shipper_code) {
		this.shipper_code = shipper_code;
	}

	public String getShipper_name() {
		return shipper_name;
	}

	public void setShipper_name(String shipper_name) {
		this.shipper_name = shipper_name;
	}

	public String getShipper_address1() {
		return shipper_address1;
	}

	public void setShipper_address1(String shipper_address1) {
		this.shipper_address1 = shipper_address1;
	}

	public String getShipper_address2() {
		return shipper_address2;
	}

	public void setShipper_address2(String shipper_address2) {
		this.shipper_address2 = shipper_address2;
	}

	public String getShipper_address3() {
		return shipper_address3;
	}

	public void setShipper_address3(String shipper_address3) {
		this.shipper_address3 = shipper_address3;
	}

	public String getShipper_address4() {
		return shipper_address4;
	}

	public void setShipper_address4(String shipper_address4) {
		this.shipper_address4 = shipper_address4;
	}

	public String getShipper_city() {
		return shipper_city;
	}

	public void setShipper_city(String shipper_city) {
		this.shipper_city = shipper_city;
	}

	public String getShipper_pincode() {
		return shipper_pincode;
	}

	public void setShipper_pincode(String shipper_pincode) {
		this.shipper_pincode = shipper_pincode;
	}

	public String getShipper_oucode() {
		return shipper_oucode;
	}

	public void setShipper_oucode(String shipper_oucode) {
		this.shipper_oucode = shipper_oucode;
	}

	public String getShipper_phone() {
		return shipper_phone;
	}

	public void setShipper_phone(String shipper_phone) {
		this.shipper_phone = shipper_phone;
	}

	public String getShipper_mobile() {
		return shipper_mobile;
	}

	public void setShipper_mobile(String shipper_mobile) {
		this.shipper_mobile = shipper_mobile;
	}

	public String getShipper_email() {
		return shipper_email;
	}

	public void setShipper_email(String shipper_email) {
		this.shipper_email = shipper_email;
	}

	public String getShipper_tin() {
		return shipper_tin;
	}

	public void setShipper_tin(String shipper_tin) {
		this.shipper_tin = shipper_tin;
	}

	public String getReceiver_code() {
		return receiver_code;
	}

	public void setReceiver_code(String receiver_code) {
		this.receiver_code = receiver_code;
	}

	public String getReceiver_mobile() {
		return receiver_mobile;
	}

	public void setReceiver_mobile(String receiver_mobile) {
		this.receiver_mobile = receiver_mobile;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getReceiver_address1() {
		return receiver_address1;
	}

	public void setReceiver_address1(String receiver_address1) {
		this.receiver_address1 = receiver_address1;
	}

	public String getReceiver_address2() {
		return receiver_address2;
	}

	public void setReceiver_address2(String receiver_address2) {
		this.receiver_address2 = receiver_address2;
	}

	public String getReceiver_address3() {
		return receiver_address3;
	}

	public void setReceiver_address3(String receiver_address3) {
		this.receiver_address3 = receiver_address3;
	}

	public String getReceiver_address4() {
		return receiver_address4;
	}

	public void setReceiver_address4(String receiver_address4) {
		this.receiver_address4 = receiver_address4;
	}

	public String getReceiver_city() {
		return receiver_city;
	}

	public void setReceiver_city(String receiver_city) {
		this.receiver_city = receiver_city;
	}

	public String getReceiver_pincode() {
		return receiver_pincode;
	}

	public void setReceiver_pincode(String receiver_pincode) {
		this.receiver_pincode = receiver_pincode;
	}

	public String getReceiver_oucode() {
		return receiver_oucode;
	}

	public void setReceiver_oucode(String receiver_oucode) {
		this.receiver_oucode = receiver_oucode;
	}

	public String getReceiver_phone() {
		return receiver_phone;
	}

	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}

	public String getReceiver_email() {
		return receiver_email;
	}

	public void setReceiver_email(String receiver_email) {
		this.receiver_email = receiver_email;
	}

	public String getReceiver_tin() {
		return receiver_tin;
	}

	public void setReceiver_tin(String receiver_tin) {
		this.receiver_tin = receiver_tin;
	}

	public String getGoods_code() {
		return goods_code;
	}

	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}

	public String getGoods_desc() {
		return goods_desc;
	}

	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}

	public String getBooking_ou() {
		return booking_ou;
	}

	public void setBooking_ou(String booking_ou) {
		this.booking_ou = booking_ou;
	}

	public String getDelivery_ou() {
		return delivery_ou;
	}

	public void setDelivery_ou(String delivery_ou) {
		this.delivery_ou = delivery_ou;
	}

	public String getNo_of_packages() {
		return no_of_packages;
	}

	public void setNo_of_packages(String no_of_packages) {
		this.no_of_packages = no_of_packages;
	}

	public String getPackage_number_from() {
		return package_number_from;
	}

	public void setPackage_number_from(String package_number_from) {
		this.package_number_from = package_number_from;
	}

	public String getPackage_number_to() {
		return package_number_to;
	}

	public void setPackage_number_to(String package_number_to) {
		this.package_number_to = package_number_to;
	}

	public String getPackage_type() {
		return package_type;
	}

	public void setPackage_type(String package_type) {
		this.package_type = package_type;
	}

	public String getShipment_value() {
		return Shipment_value;
	}

	public void setShipment_value(String shipment_value) {
		Shipment_value = shipment_value;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getActual_weight() {
		return actual_weight;
	}

	public void setActual_weight(String actual_weight) {
		this.actual_weight = actual_weight;
	}

	public String getCod_flag() {
		return cod_flag;
	}

	public void setCod_flag(String cod_flag) {
		this.cod_flag = cod_flag;
	}

	public String getCod_dod_in_favor() {
		return cod_dod_in_favor;
	}

	public void setCod_dod_in_favor(String cod_dod_in_favor) {
		this.cod_dod_in_favor = cod_dod_in_favor;
	}

	public String getCod_dod_amount() {
		return cod_dod_amount;
	}

	public void setCod_dod_amount(String cod_dod_amount) {
		this.cod_dod_amount = cod_dod_amount;
	}

	public Date getPickup_date() {
		return pickup_date;
	}

	public void setPickup_date(Date pickup_date) {
		this.pickup_date = pickup_date;
	}

	public String getPickup_time() {
		return pickup_time;
	}

	public void setPickup_time(String pickup_time) {
		this.pickup_time = pickup_time;
	}

	public List<PackageDetails> getPackage_details() {
		return package_details;
	}

	public void setPackage_details(List<PackageDetails> package_details) {
		this.package_details = package_details;
	}
	
	public String getEss_code() {
		return ess_code;
	}

	public void setEss_code(String ess_code) {
		this.ess_code = ess_code;
	}
	
	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}

		
	
}
