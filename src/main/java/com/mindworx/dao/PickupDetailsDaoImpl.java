package com.mindworx.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.validation.annotation.Validated;

import com.mindworx.model.PickupDetails;
import com.mindworx.controller.PickupDetailsRestController;
import com.mindworx.model.Customer;

@Validated
public class PickupDetailsDaoImpl implements PickupDetailsDao {
	
	
	private Connection connection = null;
	private static final Logger log = Logger.getLogger(PickupDetailsDaoImpl.class);
	
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
	
	//for Test Connection
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
	
	//for getBookingStation
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
	
	//for getGoodType at initial load page
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
	
	//for autocomplete ajax Shipper Code || Receiver Code
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
	
	//for autocomplete ajax Shipper Pincode || Receiver Pincode
	public String getPinCodes(String pincode) {
		//String sql = "SELECT distinct PINCODE,ou_code FROM gemsprod.GEMS_PINCODE_LOCATION_MST  WHERE PINCODE_STATUS='O'  AND END_DT > SYSDATE  AND STATUS='V' and pincode like ?";
		String sql = "SELECT distinct PINCODE,pincode||','||Trim(location)||','||state_code location,ou_code FROM gemsprod.GEMS_PINCODE_LOCATION_MST  WHERE PINCODE_STATUS='O'  AND END_DT > SYSDATE  AND STATUS='V' AND serv_type='D'  and pincode like ?";
		
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
				out.append(comm+"{\"pincode\":"+rs.getString(1)+",\"location\":\""+rs.getString(2)+"\",\"ou_code\":\""+rs.getString(3)+"\"}");
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
	
	//for Submit form and insert data
	public String validateXML(PickupDetails p) {
		log.debug("call validateXML");
		//generate contract_no;
		String cust_code = p.getShipper_Code();
		if(p.getBooking_Basis().equalsIgnoreCase("6")){
			cust_code = p.getReceiver_Code();
		}	
		String contract_no =  this.getContractNo(cust_code);
		log.debug("call Contract No:"+contract_no);
		//generate Docket_no;
		String output = this.generateDocketNo(p);
		log.debug("call Docket No:"+output);
		
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
			cstmt.setString(6, contract_no); 	//P_CONTRACTNO || contract_no
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
			log.debug("call CallableStatement:"+out.toString());
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
	
	//for Submit form and insert data
	private String insertDocket(PickupDetails p){
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
	
	//for insert insertPackage
	private String insertPackage(PickupDetails p){
		
		String sql = "insert into gemsprod.TEMP_DOCKET_ITEM_DTLS(LOAD_SEQNO,DOCKET_NO,PKG_NO,PKG_LN,PKG_BR,PKG_HT,PKG_WT)VALUES('AUTO/'||to_char(sysdate,'MON-YY/HH24MI'),?,?,?,?,?,?)";
		StringBuffer out = new StringBuffer();
		int maxBatchSize = 100;
		PreparedStatement ps = null;
		int []executeResult = null;
		try {
			
			ps = connection.prepareStatement(sql);
			List<com.mindworx.model.Package> packages = p.getPackage_Details();
			for (int i = 0; i < packages.size();  i++) {
				int package_no = Integer.parseInt(p.getPackage_number_from());
				ps.setInt(1,Integer.parseInt(p.getDocket_No()));
				ps.setInt(2,package_no+i);
				ps.setInt(3,Integer.parseInt(packages.get(i).getPkg_ln()));
				ps.setInt(4,Integer.parseInt(packages.get(i).getPkg_br()));
				ps.setInt(5,Integer.parseInt(packages.get(i).getPkg_ht()));
				ps.setInt(6,Integer.parseInt(packages.get(i).getPkg_wt()));
				ps.addBatch();
                if ((i + 1) % maxBatchSize == 0 || (i + 1) == packages.size()) {
                    executeResult = ps.executeBatch();
                }
            } 
			out.append("Docket Package Inserted");

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
	
	//for insert updateDocket
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

	//for generate getEsscode
	@Override
	public String getEsscode(String receiver_pincode) {
		String sql = "select ess_code,attachedou_code from gemsprod.GEMS_X_ESS_PINCODE_DTLS where PIN_CODE=? and status='V' and OPERATIONAL_STATUS='O'";
		StringBuffer out = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,receiver_pincode);
			rs = ps.executeQuery();
			if(rs.next()){
				out.append("{\"ess_code\":\""+rs.getString(1)+"\",\"attachedou_code\":\""+rs.getString(2)+"\"}");
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

	//for generate Contract No 
	@Override
	public String getContractNo(String cust_code) {
		String sql = "SELECT gccd.contract_no FROM gems_contract_cust_dtls gccd, gems_cust_contract_mst gccm WHERE gccd.cust_code = ? AND gccd.amend_version = gccm.amend_version AND gccd.contract_no = gccm.contract_no AND gccm.contract_status IN ( 'O', 'A' ) AND gccd.status = 'V' AND TRUNC(to_date(?)) BETWEEN TRUNC(gccm.lof_contract_activation_dt) AND TRUNC(gccm.cust_contract_end_dt) AND ( (gccm.cust_contract_termination_dt IS NOT NULL AND TRUNC(gccm.cust_contract_termination_dt) > TRUNC(to_Date(?))) OR ( gccm.cust_contract_termination_dt IS NULL ) ) AND TO_NUMBER(gccd.amend_version) != 0 AND TO_NUMBER(gccd.amend_version) = ( SELECT MAX(TO_NUMBER(amend_version)) FROM gems_cust_contract_mst WHERE contract_no = gccd.contract_no AND status = 'V' )";
		StringBuffer out = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String comm = "";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,cust_code);
			ps.setString(2,"16-06-2017");		//gems_docket_mst.bkg_dt
			ps.setString(3,"16-06-2017");		//gems_docket_mst.bkg_dt
			rs = ps.executeQuery();
			while(rs.next()){
				out.append(comm+"{\"contract_no\":\""+rs.getString(1)+"\"}");
				comm=",";
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
	
	//for generate Docket No
	public String generateDocketNo(PickupDetails p) {
		//StoreProcedure gems_proc_dkt_generate_java(i_ou_code IN VARCHAR2,V_USER_ID VARCHAR2, b_basis varchar2 , V_DKT_NO OUT NUMBER,err_msg OUT VARCHAR2,err_flag OUT VARCHAR2)
		CallableStatement cstmt = null;
		String sp = "{call gems_proc_dkt_generate_java(?,?,?,?,?,?)}";
		StringBuffer out = new StringBuffer();
		try {
			cstmt = connection.prepareCall(sp);
			cstmt.setString(1, p.getBooking_Pin_Code()); 		//Booking_STN
			cstmt.setString(2, "BAL_30811"); 	//User Code HARD_CODE
			cstmt.setString(3, p.getBooking_Basis()); 	//Booking Basis
			cstmt.registerOutParameter(4, java.sql.Types.INTEGER); // Generate Docket No
			cstmt.registerOutParameter(5, java.sql.Types.VARCHAR); //Error Msg
			cstmt.registerOutParameter(6, java.sql.Types.VARCHAR); //Error Flag			
			// execute getDBUSERByUserId store procedure
			cstmt.executeUpdate();
			int Docket_No = cstmt.getInt(1);
			String Msg = cstmt.getString(2);
			String Flag = cstmt.getString(3);
			
			out.append("{\"Docket_No\":"+Docket_No+",\"error_flag\":\""+Flag+"\",\"error_msg\":\""+Msg+"\"}");
			
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

	
	
}
