package com.mindworx.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.validation.annotation.Validated;

import com.mindworx.model.PickupDetails;
import com.mindworx.model.Customer;

@Validated
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
		String comm = "";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			out.append("{\"items\":[");
			while(rs.next()){				
				out.append(comm+"{\"good_code\":\""+rs.getString(1)+"\",\"good_name\":\""+rs.getString(2)+"\"}");
				comm=",";
			}
			out.append("]}");
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

	public List<Customer> getCustomerDetails(String customerid) {
		String sql = "SELECT cust_code,CUST_NAME,Nvl(CUST_ADD1,' ') CUST_ADD1,Nvl(CUST_ADD2,' ') CUST_ADD2,Nvl(CUST_ADD3,' ') CUST_ADD3,Nvl(CUST_ADD4,' ') CUST_ADD4,Nvl(CUST_CITY,' ') CUST_CITY,Nvl(CUST_PHONE_NO,' ') CUST_PHONE_NO ,Nvl(CUST_EMAIL,' ') CUST_EMAIL,Nvl(CUST_MOBILE_NO,' ') CUST_MOBILE_NO,Nvl(BUSINESS_PINCODE,' ')BUSINESS_PINCODE,nvl(ATTACHED_OU,'-') ATTACHED_OU FROM gemsprod.gems_cust_mst WHERE status='V' AND cust_Code<>'99999' and cust_code like upper(?)";
		List<Customer> out = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,customerid+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				Customer cust = new Customer();
				cust.setCustCode(rs.getString("cust_code"));
				cust.setCustName(rs.getString("CUST_NAME"));
				cust.setCustAdd1(rs.getString("CUST_ADD1").trim());
				cust.setCustAdd2(rs.getString("CUST_ADD2").trim());
				cust.setCustAdd3(rs.getString("CUST_ADD3").trim());
				cust.setCustAdd4(rs.getString("CUST_ADD4").trim());
				cust.setCustCity(rs.getString("CUST_CITY").trim());
				cust.setCustPincode(rs.getString("BUSINESS_PINCODE").trim());
				cust.setCustPhone(rs.getString("CUST_PHONE_NO").trim());
				cust.setCustMobile(rs.getString("CUST_MOBILE_NO").trim());
				cust.setCustEmail(rs.getString("CUST_EMAIL").trim());
				cust.setCustTIN(rs.getString("ATTACHED_OU"));
				out.add(cust);
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
			out.append("{\"items\":[");
			while(rs.next()){
				out.append(comm+"{\"pincode\":"+rs.getString(1)+",\"ou_code\":\""+rs.getString(2)+"\"}");
				comm=",";
			}
			out.append("]}");
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

	public String validateXML(PickupDetails p) {
		
		CallableStatement cstmt = null;
		String sp = "{call Gems_DOCKET_VALIDATE_proc(?,?,?,?)}";
		StringBuffer out = new StringBuffer();
		try {
			cstmt = connection.prepareCall(sp);
			cstmt.setInt(1, Integer.parseInt(p.getDocket_No())); 		//P_DKTNO || DOCKET_NO
			cstmt.setString(2, p.getShipper_Pincode()); 	//P_BKGOU || OU_CODE 
			cstmt.setString(3, ""); 	//P_DKT_CATG || DOCKET_Category
			cstmt.setString(4, ""); 	//P_DKT_TYPE || DOCKET_type
			cstmt.setDate(5, new java.sql.Date(p.getPickup_date().getTime())); 		//P_BKGDT || Date 
			cstmt.setString(6, ""); 	//P_CONTRACTNO || contract_no
			cstmt.setString(7, p.getShipper_Code()); 	//P_CONSIGNOR || cust_code
			cstmt.setString(8, p.getReceiver_Code()); 	//P_CONSIGNEE || cust_code
			cstmt.setString(9, p.getBooking_Basis()); 	//P_BASISCODE || Booking Basis
			cstmt.setString(10, p.getProduct()); 	//P_PRODCODE || product_code || service code
			cstmt.setString(11, p.getReceiver_Pincode()); 	//P_DLYOU || to_ou 			
			cstmt.registerOutParameter(12, java.sql.Types.VARCHAR); //Error Flag
			cstmt.registerOutParameter(13, java.sql.Types.VARCHAR); //Error Msg			
			// execute getDBUSERByUserId store procedure
			cstmt.executeUpdate();
			
			String Flag = cstmt.getString(1);
			String Msg = cstmt.getString(2);
			out.append("{\"error_flag\":\""+Flag+"\",\"error_msg\":\""+Msg+"\"}");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}					
		}
		return out.toString();
	}
	
	public String insertDocket(PickupDetails p){
		String sql = "insert into gemsprod.GEMS_GKE_DOCKET_UPLOAD(LOAD_SEQ_NO,created_date,DOCKET_NO,PROD_SERV_CODE,BOOKING_BASIS,CONSIGNOR_CODE,CONSIGNEE_CODE,GOODS_CODE,CONSIGNOR_PINCODE,CONSIGNEE_PINCODE,NO_OF_PKGS,DECL_CARGO_VAL,RISK_COVERAGE,VOLUME,UOM,ACTUAL_WT,CONSIGNOR_NAME,CONSIGNOR_ADD1,CONSIGNOR_ADD2,CONSIGNOR_ADD3,CONSIGNOR_ADD4,CONSIGNOR_CITY,CONSIGNOR_MOBILE_NO,CONSIGNOR_PHONE_NO,CONSIGNOR_EMAIL,CONSIGNEE_NAME,CONSIGNEE_ADD1,CONSIGNEE_ADD2,CONSIGNEE_ADD3,CONSIGNEE_ADD4,CONSIGNEE_CITY,CONSIGNEE_MOBILE_NO,CONSIGNEE_PHONE_NO,CONSIGNEE_EMAIL,COD_DOD_FLAG,COD_IN_FAVOUR_OF,ESS_CODE,consignor_tinno,consignee_tinno,UPLOAD_FLAG,STATUS)VALUES('AUTO/'||to_char(sysdate,'MON-YY/HH24MI'),sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'V')";
		StringBuffer out = new StringBuffer();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(p.getDocket_No()));
			ps.setString(2,p.getProduct());
			ps.setString(3,p.getBooking_Basis());
			ps.setString(4,p.getShipper_Code());
			ps.setString(5,p.getReceiver_Code());
			ps.setString(6,p.getGoods_Code());
			ps.setString(7,p.getShipper_Pincode());
			ps.setString(8,p.getReceiver_Pincode());
			ps.setInt(9,Integer.parseInt(p.getNo_of_Packages()));
			ps.setFloat(10,Float.parseFloat(p.getShipment_Value()));
			ps.setString(11,p.getRisk());
			ps.setFloat(12,Float.parseFloat(p.getVolume()));
			ps.setString(13,p.getUOM());
			ps.setFloat(14,Float.parseFloat(p.getActual_Weight()));
			ps.setString(15,p.getShipper_Name());
			ps.setString(16,p.getShipper_Address1());
			ps.setString(17,p.getShipper_Address2());
			ps.setString(18,p.getShipper_Address3());
			ps.setString(19,p.getShipper_Address4());
			ps.setString(20,p.getShipper_City());
			ps.setString(21,p.getShipper_Mobile());
			ps.setString(22,p.getShipper_Phone());
			ps.setString(23,p.getShipper_Email());
			ps.setString(24,p.getReceiver_Name());
			ps.setString(25,p.getReceiver_Address1());
			ps.setString(26,p.getReceiver_Address1());
			ps.setString(27,p.getReceiver_Address1());
			ps.setString(28,p.getReceiver_Address1());
			ps.setString(29,p.getReceiver_City());
			ps.setString(30,p.getReceiver_Mobile());
			ps.setString(31,p.getReceiver_Phone());
			ps.setString(32,p.getReceiver_Email());
			ps.setString(33,p.getCOD_Flag());
			ps.setString(34,"G");
			ps.setString(35,"esscode");
			ps.setString(36,p.getShipper_TIN());
			ps.setString(37,p.getReceiver_TIN());
			ps.setString(38,"W");
			int k = ps.executeUpdate();
			if(k > 0) 
				out.append("Docket Created Successfully Created");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}					
		}
		return out.toString();
	}
	
	public String updateDocket(PickupDetails p){
		String sql = "update gemsprod.GEMS_GKE_DOCKET_UPLOAD set PROD_SERV_CODE=? ,BOOKING_BASIS=? ,CONSIGNOR_CODE=? ,CONSIGNEE_CODE=? ,GOODS_CODE=? ,CONSIGNOR_PINCODE=? ,CONSIGNEE_PINCODE=? ,NO_OF_PKGS=? ,DECL_CARGO_VAL=? ,RISK_COVERAGE=? ,VOLUME=? ,UOM=? ,ACTUAL_WT=? ,CONSIGNOR_NAME=? ,CONSIGNOR_ADD1=? ,CONSIGNOR_ADD2=? ,CONSIGNOR_ADD3=? ,CONSIGNOR_ADD4=? ,CONSIGNOR_CITY=? ,CONSIGNOR_MOBILE_NO=? ,CONSIGNOR_PHONE_NO=? ,CONSIGNOR_EMAIL=? ,CONSIGNEE_NAME=? ,CONSIGNEE_ADD1=? ,CONSIGNEE_ADD2=? ,CONSIGNEE_ADD3=? ,CONSIGNEE_ADD4=? ,CONSIGNEE_CITY=? ,CONSIGNEE_MOBILE_NO=? ,CONSIGNEE_PHONE_NO=? ,CONSIGNEE_EMAIL=? ,COD_DOD_FLAG=? ,COD_IN_FAVOUR_OF=? ,ESS_CODE=? ,consignor_tinno=? ,consignee_tinno=? where DOCKET_NO = ?";
		StringBuffer out = new StringBuffer();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setString(1,p.getProduct());
			ps.setString(2,p.getBooking_Basis());
			ps.setString(3,p.getShipper_Code());
			ps.setString(4,p.getReceiver_Code());
			ps.setString(5,p.getGoods_Code());
			ps.setString(6,p.getShipper_Pincode());
			ps.setString(7,p.getReceiver_Pincode());
			ps.setInt(8,Integer.parseInt(p.getNo_of_Packages()));
			ps.setFloat(9,Float.parseFloat(p.getShipment_Value()));
			ps.setString(10,p.getRisk());
			ps.setFloat(11,Float.parseFloat(p.getVolume()));
			ps.setString(12,p.getUOM());
			ps.setFloat(13,Float.parseFloat(p.getActual_Weight()));
			ps.setString(14,p.getShipper_Name());
			ps.setString(15,p.getShipper_Address1());
			ps.setString(16,p.getShipper_Address2());
			ps.setString(17,p.getShipper_Address3());
			ps.setString(18,p.getShipper_Address4());
			ps.setString(19,p.getShipper_City());
			ps.setString(20,p.getShipper_Mobile());
			ps.setString(21,p.getShipper_Phone());
			ps.setString(22,p.getShipper_Email());
			ps.setString(23,p.getReceiver_Name());
			ps.setString(24,p.getReceiver_Address1());
			ps.setString(25,p.getReceiver_Address1());
			ps.setString(26,p.getReceiver_Address1());
			ps.setString(27,p.getReceiver_Address1());
			ps.setString(28,p.getReceiver_City());
			ps.setString(29,p.getReceiver_Mobile());
			ps.setString(30,p.getReceiver_Phone());
			ps.setString(31,p.getReceiver_Email());
			ps.setString(32,p.getCOD_Flag());
			ps.setString(33,"G");
			ps.setString(34,"esscode");
			ps.setString(35,p.getShipper_TIN());
			ps.setString(36,p.getReceiver_TIN());
			ps.setString(37,"W");
			ps.setInt(38,Integer.parseInt(p.getDocket_No()));
			int k = ps.executeUpdate();
			if(k > 0) 
				out.append("Docket Updated Successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}					
		}
		return out.toString();
	}

	@Override
	public String getEsscode(String receiver_pincode) {
		String sql = "select ess_code,attachedou_code from gemsprod.GEMS_X_ESS_PINCODE_DTLS where PIN_CODE=? and status='V' and OPERATIONAL_STATUS='O'";
		StringBuffer out = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String comm = "";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,receiver_pincode);
			rs = ps.executeQuery();
			if(rs.next()){
				out.append(comm+"{\"ess_code\":\""+rs.getString(1)+"\",\"attachedou_code\":\""+rs.getString(2)+"\"}");
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

	
	
}
