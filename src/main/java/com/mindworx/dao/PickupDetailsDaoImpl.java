package com.mindworx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mindworx.model.PickupDetails;
import com.mindworx.model.Shipper;


public class PickupDetailsDaoImpl implements PickupDetailsDao {
	
	
	private Connection connection = null;
	
	public PickupDetailsDaoImpl(DataSource dataSource) {
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PickupDetails getPickupDetails() {
		return new PickupDetails();
		
	}
	
	public long getGEMS_WS_CUST_AUTO_prod_vals() {
		String sql = "select count(*) from gemsprod.GEMS_WS_CUST_AUTO_prod_vals";
		int count = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				
				count = (int) rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}					
		}
		return count;
		
	}
	
	
	

	public String getBookingStation(String cust_code) {
		String sql = "select attached_ou from gemsprod.gems_cust_mst where cust_code = ? ";
		String out = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(0, cust_code);
			rs = ps.executeQuery();
			if(rs.next()){
				out = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}					
		}
		return out;
	}

	public String getGoodType() {
		String sql = "select goods_code,substr(goods_name,1,20) goods_nm from gemsprod.GEMS_GOODS_MST where status='V' order by goods_name";
		StringBuffer out = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				out.append("<option value='"+rs.getString(1)+"' >"+rs.getString(2)+"</option>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}					
		}
		return out.toString();
	}

	public String getCustomerDetails(String customerid) {
		String sql = "SELECT cust_code,CUST_NAME,Nvl(CUST_ADD1,' ') CUST_ADD1,Nvl(CUST_ADD2,' ') CUST_ADD2,Nvl(CUST_ADD3,' ') CUST_ADD3,Nvl(CUST_ADD4,' ') CUST_ADD4,Nvl(CUST_CITY,' ') CUST_CITY,Nvl(CUST_PHONE_NO,' ') CUST_PHONE_NO ,Nvl(CUST_EMAIL,' ') CUST_EMAIL,Nvl(CUST_MOBILE_NO,' ') CUST_MOBILE_NO,NVL(CUST_EMAIL,' ') CUST_EMAIL,Nvl(BUSINESS_PINCODE,' ')BUSINESS_PINCODE,nvl(ATTACHED_OU,'-') ATTACHED_OU FROM gemsprod.gems_cust_mst WHERE status='V' AND cust_Code<>'99999' and cust_code like upper(?)";
		StringBuffer out = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,customerid+"%");
			rs = ps.executeQuery();
			if(rs.next()){
				Shipper shipper = new Shipper();
				shipper.setShipper_Code(rs.getString("cust_code"));
				shipper.setShipper_Name(rs.getString("CUST_NAME"));
				shipper.setShipper_Address1(rs.getString("CUST_ADD1").trim());
				shipper.setShipper_Address2(rs.getString("CUST_ADD2").trim());
				shipper.setShipper_Address3(rs.getString("CUST_ADD3").trim());
				shipper.setShipper_Address4(rs.getString("CUST_ADD4").trim());
				shipper.setShipper_City(rs.getString("CUST_CITY").trim());
				shipper.setShipper_Pin_Code(rs.getString("BUSINESS_PINCODE").trim());
				shipper.setShipper_Phone(rs.getString("CUST_PHONE_NO").trim());
				shipper.setShipper_Mobile(rs.getString("CUST_MOBILE_NO").trim());
				shipper.setShipper_Email(rs.getString("CUST_EMAIL").trim());
				shipper.setShipper_VAT_TIN(rs.getString("ATTACHED_OU"));
				out.append(shipper.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}					
		}
		return out.toString();
	}

	public String getPinCodes(String pincode) {
		String sql = "SELECT distinct PINCODE,ou_code FROM gemsprod.GEMS_PINCODE_LOCATION_MST  WHERE PINCODE_STATUS='O'  AND END_DT > SYSDATE  AND STATUS='V' and pincode like ?";
		StringBuffer out = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String comm = "";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,pincode+"%");
			rs = ps.executeQuery();
			out.append("[");
			while(rs.next()){
				out.append(comm+"{\"PINCODE\":\""+rs.getString(1)+"\",\"ou_code\":\""+rs.getString(2)+"\"}");
				comm=",";
			}
			out.append("]");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}					
		}
		return out.toString();
	}

	
	
}
