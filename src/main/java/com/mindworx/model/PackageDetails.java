package com.mindworx.model;


public class PackageDetails {
	
	private String pkg_no;
	private String pkg_ln;
	private String pkg_br;
	private String pkg_ht;
	private String pkg_wt;
	
	public PackageDetails() {
		// TODO Auto-generated constructor stub
	}
	public String getPkg_no() {
		return pkg_no;
	}
	public void setPkg_no(String pkg_no) {
		this.pkg_no = pkg_no;
	}
	public String getPkg_ln() {
		return pkg_ln;
	}
	public void setPkg_ln(String pkg_ln) {
		this.pkg_ln = pkg_ln;
	}
	public String getPkg_br() {
		return pkg_br;
	}
	public void setPkg_br(String pkg_br) {
		this.pkg_br = pkg_br;
	}
	public String getPkg_ht() {
		return pkg_ht;
	}
	public void setPkg_ht(String pkg_ht) {
		this.pkg_ht = pkg_ht;
	}
	public String getPkg_wt() {
		return pkg_wt;
	}
	public void setPkg_wt(String pkg_wt) {
		this.pkg_wt = pkg_wt;
	}
	
	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
	
}
