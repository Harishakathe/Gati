package com.mindworx.model;


public class PackageDetails {
	
	private int pkg_no;
	private float pkg_ln;
	private float pkg_br;
	private float pkg_ht;
	private float pkg_wt;
	
	public PackageDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public int getPkg_no() {
		return pkg_no;
	}

	public void setPkg_no(int pkg_no) {
		this.pkg_no = pkg_no;
	}

	public float getPkg_ln() {
		return pkg_ln;
	}

	public void setPkg_ln(float pkg_ln) {
		this.pkg_ln = pkg_ln;
	}

	public float getPkg_br() {
		return pkg_br;
	}

	public void setPkg_br(float pkg_br) {
		this.pkg_br = pkg_br;
	}

	public float getPkg_ht() {
		return pkg_ht;
	}

	public void setPkg_ht(float pkg_ht) {
		this.pkg_ht = pkg_ht;
	}

	public float getPkg_wt() {
		return pkg_wt;
	}

	public void setPkg_wt(float pkg_wt) {
		this.pkg_wt = pkg_wt;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
	
}
