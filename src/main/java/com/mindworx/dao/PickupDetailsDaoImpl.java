package com.mindworx.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import com.mindworx.model.PickupDetails;
import com.mindworx.model.Customer;
import com.mindworx.model.PackageDetails;

public class PickupDetailsDaoImpl implements PickupDetailsDao {
	
	
	private Connection connection = null;
	private DataSource dataSource;
	private final int maxBatchSize = 100;
	
	private static final Logger log = Logger.getLogger(PickupDetailsDaoImpl.class);
	
	public PickupDetailsDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public PickupDetails getPickupDetails(int Docket_no) {
		PickupDetails p = null;
		
		String sql = "SELECT DOCKET_CATG,DOCKET_NO,DOCKET_TYPE,RISK_COVERAGE,BOOKING_STN,DELIVERY_STN,PROD_SERV_CODE,NO_OF_PKGS,GOODS_CODE,CONSIGNMENT_TYPE,DECL_CARGO_VAL,ACTUAL_WT,VOLUME,UOM,CONTRACT_NO,CONSIGNOR_CODE,CONSIGNOR_NAME,CONSIGNOR_ADD1,CONSIGNOR_ADD2,CONSIGNOR_ADD3,CONSIGNOR_CITY,CONSIGNOR_ADD4,CONSIGNOR_MOBILE_NO,CONSIGNOR_PHONE_NO,CONSIGNOR_EMAIL,CONSIGNOR_PINCODE,CONSIGNEE_CODE,CONSIGNEE_NAME,CONSIGNEE_ADD1,CONSIGNEE_ADD2,CONSIGNEE_ADD3,CONSIGNEE_CITY,CONSIGNEE_ADD4,CONSIGNEE_MOBILE_NO,CONSIGNEE_PHONE_NO,CONSIGNEE_EMAIL,CONSIGNEE_PINCODE,STATUS,CREATED_DATE,BOOKING_BASIS,FROM_PKG_NO,TO_PKG_NO,COD_AMT,COD_IN_FAVOUR_OF,UPLOAD_FLAG,ESS_CODE,COD_DOD_FLAG,GOODS_DESC,CONSIGNOR_TINNO,CONSIGNEE_TINNO FROM GEMSPROD.GEMS_GKE_DOCKET_UPLOAD WHERE DOCKET_NO = ?";
		String sql1 = "SELECT PKG_NO,PKG_LN,PKG_BR,PKG_HT,PKG_WT FROM GEMSPROD.TEMP_DOCKET_ITEM_DTLS WHERE DOCKET_NO = "+Docket_no;
		
		PreparedStatement ps = null;
		Statement st1 = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			log.info("Docket QUERY:"+sql);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, Docket_no);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				p = new PickupDetails();
				p.setDocket_category(rs.getString(1));
				p.setDocket_no(rs.getInt(2));
				p.setDocket_type(rs.getString(3));
				p.setRisk(rs.getString(4));
				p.setBooking_ou(rs.getString(5));
				p.setDelivery_ou(rs.getString(6));
				p.setProduct(rs.getString(7));
				p.setNo_of_packages(rs.getInt(8));
				p.setGoods_code(rs.getString(9));
				p.setPackage_type(rs.getString(10));
				p.setShipment_value(rs.getFloat(11));
				p.setActual_weight(rs.getFloat(12)); 
				p.setVolume(rs.getFloat(13));
				p.setUom(rs.getString(14));
				p.setContract_no(rs.getString(15));
				p.setShipper_code(rs.getString(16)); 
				p.setShipper_name(rs.getString(17));
				p.setShipper_address1(rs.getString(18));
				p.setShipper_address2(rs.getString(19));
				p.setShipper_address3(rs.getString(20));
				p.setShipper_city(rs.getString(21));
				p.setShipper_address4(rs.getString(22));
				p.setShipper_mobile(rs.getString(23));
				p.setShipper_phone(rs.getString(24));
				p.setShipper_email(rs.getString(25));
				p.setShipper_pincode(rs.getString(26)); 
				p.setReceiver_code(rs.getString(27)); 
				p.setReceiver_name(rs.getString(28));
				p.setReceiver_address1(rs.getString(29));
				p.setReceiver_address2(rs.getString(30));
				p.setReceiver_address3(rs.getString(31));
				p.setReceiver_city(rs.getString(32));
				p.setReceiver_address4(rs.getString(33));
				p.setReceiver_mobile(rs.getString(34));
				p.setReceiver_phone(rs.getString(35));
				p.setReceiver_email(rs.getString(36));
				p.setReceiver_pincode(rs.getString(37)); 
				log.info("STATUS :"+rs.getString(38));
				p.setPickup_date(new Date(rs.getTimestamp(39).getTime()));
				p.setBooking_basis(rs.getString(40));
				p.setPackage_number_from(rs.getInt(41)); 
				p.setPackage_number_to(rs.getInt(42)); 
				p.setCod_dod_amount(rs.getInt(43));
				p.setCod_dod_in_favor(rs.getString(44));				
				log.info("UPLOAD_FLAG :"+rs.getString(45)); 
				p.setEss_code(rs.getString(46));
				p.setCod_flag(rs.getString(47)); 
				p.setGoods_desc(rs.getString(48));
				p.setShipper_tin(rs.getString(49));
				p.setReceiver_tin(rs.getString(50));
				st1 = connection.createStatement();
				ResultSet rs1 = st1.executeQuery(sql1);
				List<PackageDetails> list = new ArrayList<>();
				while(rs1.next())
				{
					PackageDetails packageDetails = new PackageDetails();
					packageDetails.setPkg_no(rs1.getInt(1));
					packageDetails.setPkg_ln(rs1.getFloat(2));
					packageDetails.setPkg_br(rs1.getFloat(3));
					packageDetails.setPkg_ht(rs1.getFloat(4));
					packageDetails.setPkg_wt(rs1.getFloat(5));
					list.add(packageDetails);
				}
				p.setPackage_details(list);
				rs1.close();
				st1.close();
				rs.close();
				ps.close();
			}
			else
			{
				log.error("Docket Not Found");
			}
		} catch (SQLException e) {
			log.error("SQLException: " + e.getMessage());
			try {
				connection.rollback();
				connection.close();
			} catch (SQLException e1) {
				log.error("SQLException: " + e1.getMessage());
			}
		}						
		return p;		
	}
	
	//for Test Connection
	public long getGEMS_WS_CUST_AUTO_prod_vals() {
		//String sql = "select count(*) from gemsprod.GEMS_WS_CUST_AUTO_prod_vals";
		String sql = "SELECT table_name, owner, tablespace_name FROM user_tables";
		int count = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer out = new StringBuffer();
		String comma="";
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			/*if(rs.next()){
				
				count = (int) rs.getInt(1);
			}*/
			out.append("[");
			while(rs.next()){				
				out.append(comma+"{\"table_name\":\""+rs.getString(1)+"\",\"owner\":\""+rs.getString(2)+"\",\"tablespace_name\":\""+rs.getString(3)+"\"}");
				comma=",";
			}
			out.append("]");
			rs.close();
			ps.close();
		} catch (SQLException e) {
			log.error("SQLException: " + e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
			}
		}		
		//return out.toString();
		return 0;
	}	
	
	//for getBookingStation
	public String getBookingStation(String cust_code) {
		String sql = "select attached_ou from gemsprod.gems_cust_mst where cust_code = ? ";
		String out = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(0, cust_code);
			rs = ps.executeQuery();
			if(rs.next()){
				out = rs.getString(1);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			log.error("SQLException: " + e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
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
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			out.append("{\"items\":[");
			while(rs.next()){				
				out.append(comm+"{\"good_code\":\""+rs.getString(1)+"\",\"good_name\":\""+rs.getString(2)+"\"}");
				comm=",";
			}
			out.append("]}");
			rs.close();
			ps.close();
		} catch (SQLException e) {
			log.error("SQLException: " + e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
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
			connection = dataSource.getConnection();
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
				cust.setCustTIN("");
				cust.setCustOU(rs.getString("ATTACHED_OU"));
				out.add(cust);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			log.error("SQLException: " + e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
			}
		}
		
		return out;
	}
	
	//for autocomplete ajax Shipper Pincode || Receiver Pincode
	public String getPinCodes(String pincode) {
		//String sql = "SELECT distinct PINCODE,ou_code FROM gemsprod.GEMS_PINCODE_LOCATION_MST  WHERE PINCODE_STATUS='O'  AND END_DT > SYSDATE  AND STATUS='V' and pincode like ?";
		String sql = "SELECT distinct PINCODE, Trim(location)||','||state_code location,ou_code FROM gemsprod.GEMS_PINCODE_LOCATION_MST  WHERE PINCODE_STATUS='O'  AND END_DT > SYSDATE  AND STATUS='V' AND serv_type='D'  and pincode like ?";
		
		StringBuffer out = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String comm = "";
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,pincode+"%");
			rs = ps.executeQuery();
			out.append("{\"items\":[");
			while(rs.next()){
				out.append(comm+"{\"pincode\":"+rs.getString(1)+",\"location\":\""+rs.getString(2)+"\",\"ou_code\":\""+rs.getString(3)+"\"}");
				comm=",";
			}
			out.append("]}");
			rs.close();
			ps.close();
		} catch (SQLException e) {
			log.error("SQLException: " + e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
			}
		}
		
		return out.toString();
	}
	
	//for Submit form and insert data
	public String validateXML(PickupDetails p) {
		log.info("call validateXML Success Booking_Basis:"+p.getBooking_basis());		
		String Sql = "{call gemsprod.gems_docket_pack.Gems_DOCKET_VALIDATE_proc(0,'"+p.getBooking_ou()+"','"+p.getDocket_category()+"','"+p.getDocket_type()+"',trunc(SYSDATE),'"+p.getContract_no()+"','"+p.getShipper_code()+"','"+p.getReceiver_code()+"','"+p.getBooking_basis()+"','"+p.getProduct()+"','"+p.getReceiver_tin()+"',?,?)}";
		log.info("call Sql:"+Sql);
		CallableStatement cstmt = null;
		StringBuffer out = new StringBuffer();
		try {
			connection = dataSource.getConnection();
			//cstmt = connection.prepareCall("{call gemsprod.gems_docket_pack.Gems_DOCKET_VALIDATE_proc(?,?,?,?,trunc(SYSDATE),?,?,?,?,?,?,?,?)}");
			cstmt = connection.prepareCall(Sql);
			
			cstmt.registerOutParameter(1, Types.VARCHAR); //Error Flag
			cstmt.registerOutParameter(2, Types.VARCHAR); //Error Msg
			
		/*	cstmt.setInt(3, 0); 		//P_DKTNO || DOCKET_NO
			cstmt.setString(4, p.getShipper_tin()); 	//P_BKGOU || OU_CODE 
			cstmt.setString(5, p.getDocket_category()); 	//P_DKT_CATG || DOCKET_Category
			cstmt.setString(6, p.getDocket_type()); 	//P_DKT_TYPE || DOCKET_type
			cstmt.setDate(7, new java.sql.Date(p.getPickup_date().getTime())); 		//P_BKGDT || Date 
			cstmt.setString(7, contract_no); 	//P_CONTRACTNO || contract_no
			cstmt.setString(8, p.getShipper_code()); 	//P_CONSIGNOR || cust_code
			cstmt.setString(9, p.getReceiver_code()); 	//P_CONSIGNEE || cust_code
			cstmt.setString(10, p.getBooking_basis()); 	//P_BASISCODE || Booking Basis
			cstmt.setString(11, p.getProduct()); 	//P_PRODCODE || product_code || service code
			cstmt.setString(12, p.getReceiver_tin()); 	//P_DLYOU || to_ou */
			
			cstmt.executeUpdate();
			
			String Flag = cstmt.getString(1);
			String Msg = cstmt.getString(2);
			
			out.append("{\"error_flag\":\""+Flag+"\",\"error_msg\":\""+Msg+"\"}");
			log.info("call CallableStatement:"+out.toString());
			cstmt.close();
		} catch (SQLException ex) {
			log.error("SQLException: " + ex.getMessage());			  			
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
			}
		}
		
		return out.toString();
	}
	//for Submit form and insert data
	@Override
	public String insertDocket(PickupDetails p){
		log.info("insertDocket PickupDetails:"+p);
		String sql = "INSERT INTO GEMSPROD.GEMS_GKE_DOCKET_UPLOAD(LOAD_SEQ_NO,DOCKET_CATG,DOCKET_NO,DOCKET_TYPE,RISK_COVERAGE,BOOKING_STN,DELIVERY_STN,PROD_SERV_CODE,NO_OF_PKGS,GOODS_CODE,CONSIGNMENT_TYPE,DECL_CARGO_VAL,ACTUAL_WT,VOLUME,UOM,CONTRACT_NO,CONSIGNOR_CODE,CONSIGNOR_NAME,CONSIGNOR_ADD1,CONSIGNOR_ADD2,CONSIGNOR_ADD3,CONSIGNOR_CITY,CONSIGNOR_ADD4,CONSIGNOR_PHONE_NO,CONSIGNOR_MOBILE_NO,CONSIGNOR_EMAIL,CONSIGNOR_PINCODE,CONSIGNEE_CODE,CONSIGNEE_NAME,CONSIGNEE_ADD1,CONSIGNEE_ADD2,CONSIGNEE_ADD3,CONSIGNEE_CITY,CONSIGNEE_ADD4,CONSIGNEE_PHONE_NO,CONSIGNEE_MOBILE_NO,CONSIGNEE_EMAIL,CONSIGNEE_PINCODE,STATUS,CREATED_DATE,BOOKING_BASIS,FROM_PKG_NO,TO_PKG_NO,COD_AMT,COD_IN_FAVOUR_OF,UPLOAD_FLAG,ESS_CODE,COD_DOD_FLAG,GOODS_DESC,CONSIGNOR_TINNO,CONSIGNEE_TINNO)VALUES('AUTO/'||to_char(sysdate,'MON-YY/HH24MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?)";
		String sql1 = "INSERT INTO GEMSPROD.TEMP_DOCKET_ITEM_DTLS(LOAD_SEQNO,DOCKET_NO,PKG_NO,PKG_LN,PKG_BR,PKG_HT,PKG_WT)VALUES('AUTO/'||to_char(sysdate,'MON-YY/HH24MI'),?,?,?,?,?,?)";
		String sql2 = "SELECT MAX(PKG_NO) FROM GEMSPROD.TEMP_DOCKET_ITEM_DTLS";
		List<PackageDetails> packageDetails = p.getPackage_details();
		StringBuffer out = new StringBuffer();
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			int Package_number_from = p.getPackage_number_from();
			log.info("Package_number_from is :"+Package_number_from);
			if(Package_number_from==0){					
				ps2 = connection.prepareStatement(sql2);
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next()) {
					Package_number_from = rs2.getInt(1);
					p.setPackage_number_from(Package_number_from);
					p.setPackage_number_to((Package_number_from+packageDetails.size()-1));
					log.info("Package_number_from Generated :"+p.getPackage_number_from());
					log.info("Package_number_to Generated :"+p.getPackage_number_to());
				}
			}
			ps = connection.prepareStatement(sql, new String[]{"DOCKET_NO"});
			ps.setString(1,p.getDocket_category());
			ps.setInt(2,p.getDocket_no());
			ps.setString(3,p.getDocket_type());
			ps.setString(4,p.getRisk());
			ps.setString(5,p.getBooking_ou());  //Booking_stn
			ps.setString(6,p.getDelivery_ou());	//Delivery_stn
			ps.setString(7,p.getProduct());
			ps.setInt(8,p.getNo_of_packages());
			ps.setString(9,p.getGoods_code());
			ps.setString(10, p.getPackage_type());   //Consignment_type
			ps.setDouble(11,p.getShipment_value());		//DECL_CARGO_VAL
			ps.setFloat(12,p.getActual_weight());
			ps.setFloat(13,p.getVolume());
			ps.setString(14,p.getUom());
			ps.setString(15,p.getContract_no());
			ps.setString(16,p.getShipper_code());		//CONSIGNOR
			ps.setString(17,p.getShipper_name());		
			ps.setString(18,p.getShipper_address1());
			ps.setString(19,p.getShipper_address2());
			ps.setString(20,p.getShipper_address3());
			ps.setString(21,p.getShipper_city());
			ps.setString(22,p.getShipper_address4());
			ps.setString(23,p.getShipper_phone());
			ps.setString(24,p.getShipper_mobile());		
			ps.setString(25,p.getShipper_email());
			ps.setString(26,p.getShipper_pincode());			
			ps.setString(27,p.getReceiver_code());
			ps.setString(28,p.getReceiver_name());
			ps.setString(29,p.getReceiver_address1());
			ps.setString(30,p.getReceiver_address2());
			ps.setString(31,p.getReceiver_address3());			
			ps.setString(32,p.getReceiver_city());
			ps.setString(33,p.getReceiver_address4());
			ps.setString(34,p.getReceiver_phone());
			ps.setString(35,p.getReceiver_mobile());			
			ps.setString(36,p.getReceiver_email());
			ps.setString(37,p.getReceiver_pincode());
			ps.setString(38,"V");			
			ps.setString(39,p.getBooking_basis());			
			ps.setInt(40,p.getPackage_number_from());
			ps.setInt(41,p.getPackage_number_to());
			ps.setInt(42,p.getCod_dod_amount());
			ps.setString(43,p.getCod_dod_in_favor());
			ps.setString(44,"W");
			ps.setString(45,p.getEss_code());
			ps.setString(46,p.getCod_flag());
			ps.setString(47,p.getGoods_desc().trim());			
			ps.setString(48,p.getShipper_tin());		//Shipper GSTIN
			ps.setString(49,p.getReceiver_tin());		//Receiver GSTIN
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				log.info("Docket No:"+rs.getInt(1));
								
				
				ps1 = connection.prepareStatement(sql1);
				
				for (int i = 0; i < packageDetails.size();  i++) {
					ps1.setInt(1,p.getDocket_no());
					ps1.setInt(2,(p.getPackage_number_from()+i));
					ps1.setFloat(3,packageDetails.get(i).getPkg_ln());
					ps1.setFloat(4,packageDetails.get(i).getPkg_br());
					ps1.setFloat(5,packageDetails.get(i).getPkg_ht());
					ps1.setFloat(6,packageDetails.get(i).getPkg_wt());
					ps1.addBatch();
	                if ((i + 1) % maxBatchSize == 0 || (i + 1) == packageDetails.size()) {
	                    ps1.executeBatch(); 
	                    log.info("packageDetails batch is inseted");
	                    }
	            } 
				out.append("{\"error_flag\":\"N\",\"Docket_No\":"+p.getDocket_no()+"}");
				log.info("Docket Package Inserted");
			}
			else
			{
				out.append("{\"error_flag\":\"Y\",\"error_msg\":\"Docket Does Not Inserted\"}");
			}
			ps1.close();
			rs.close();
			ps.close();
		} catch (SQLException e) {
			String me = e.getMessage();
			out.append("{\"error_flag\":\"Y\",\"error_msg\":\""+me.replace("\"", "'")+"\"}");
			e.printStackTrace();
			log.error("SQLException: " + e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				log.error("connection SQLException: " + e1.getMessage());
			}
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
			}
		}
		return out.toString();
	}
	
	
	
	//for insert updateDocket
	public String updateDocket(PickupDetails p){
		//String sql = "UPDATE GEMSPROD.GEMS_GKE_DOCKET_UPLOAD SET ESS_CODE=? WHERE DOCKET_NO = ?";
		
		String sql = "UPDATE GEMSPROD.GEMS_GKE_DOCKET_UPLOAD SET DOCKET_CATG=?,DOCKET_TYPE=?,RISK_COVERAGE=?,BOOKING_STN=?,DELIVERY_STN=?,PROD_SERV_CODE=?,NO_OF_PKGS=?,GOODS_CODE=?,CONSIGNMENT_TYPE=?,DECL_CARGO_VAL=?,ACTUAL_WT=?,VOLUME=?,UOM=?,CONTRACT_NO=?,CONSIGNOR_CODE=?,CONSIGNOR_NAME=?,CONSIGNOR_ADD1=?,CONSIGNOR_ADD2=?,CONSIGNOR_ADD3=?,CONSIGNOR_CITY=?,CONSIGNOR_ADD4=?,CONSIGNOR_MOBILE_NO=?,CONSIGNOR_PHONE_NO=?,CONSIGNOR_EMAIL=?,CONSIGNOR_PINCODE=?,CONSIGNEE_CODE=?,CONSIGNEE_NAME=?,CONSIGNEE_ADD1=?,CONSIGNEE_ADD2=?,CONSIGNEE_ADD3=?,CONSIGNEE_CITY=?,CONSIGNEE_ADD4=?,CONSIGNEE_MOBILE_NO=?,CONSIGNEE_PHONE_NO=?,CONSIGNEE_EMAIL=?,CONSIGNEE_PINCODE=?,BOOKING_BASIS=?,FROM_PKG_NO=?,TO_PKG_NO=?,COD_AMT=?,COD_IN_FAVOUR_OF=?,ESS_CODE=?,COD_DOD_FLAG=?,GOODS_DESC=?,CONSIGNOR_TINNO=?,CONSIGNEE_TINNO=? WHERE DOCKET_NO = ?";
		String sql1 = "UPDATE GEMSPROD.TEMP_DOCKET_ITEM_DTLS SET `PKG_LN`=?,`PKG_BR`=?,`PKG_HT`=?,`PKG_WT`=? WHERE DOCKET_NO = ? AND PKG_NO = ? ";
		StringBuffer out = new StringBuffer();
		PreparedStatement ps,ps1 = null;
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(sql);						
			ps.setString(1,p.getDocket_category());
			ps.setString(2,p.getDocket_type());
			ps.setString(3,p.getRisk());
			ps.setString(4,p.getBooking_ou());  //Booking_stn
			ps.setString(5,p.getDelivery_ou());	//Delivery_stn
			ps.setString(6,p.getProduct());
			ps.setInt(7,p.getNo_of_packages());
			ps.setString(8,p.getGoods_code());
			ps.setString(9, p.getPackage_type());   //Consignment_type
			ps.setDouble(10,p.getShipment_value());		//DECL_CARGO_VAL
			ps.setFloat(11,p.getActual_weight());
			ps.setFloat(12,p.getVolume());
			ps.setString(13,p.getUom());
			ps.setString(14,p.getContract_no());
			ps.setString(15,p.getShipper_code());		//CONSIGNOR
			ps.setString(16,p.getShipper_name());		
			ps.setString(17,p.getShipper_address1());
			ps.setString(18,p.getShipper_address2());
			ps.setString(19,p.getShipper_address3());
			ps.setString(20,p.getShipper_city());
			ps.setString(21,p.getShipper_address4());
			ps.setString(22,p.getShipper_phone());
			ps.setString(23,p.getShipper_mobile());		
			ps.setString(24,p.getShipper_email());
			ps.setString(25,p.getShipper_pincode());
			ps.setString(26,p.getReceiver_code());
			ps.setString(27,p.getReceiver_name());
			ps.setString(28,p.getReceiver_address1());
			ps.setString(29,p.getReceiver_address2());
			ps.setString(30,p.getReceiver_address3());
			ps.setString(31,p.getReceiver_city());
			ps.setString(32,p.getReceiver_address4());
			ps.setString(33,p.getReceiver_phone());
			ps.setString(34,p.getReceiver_mobile());
			ps.setString(35,p.getReceiver_email());
			ps.setString(36,p.getReceiver_pincode());
			ps.setString(37,p.getBooking_basis());
			ps.setInt(38,p.getPackage_number_from());
			ps.setInt(39,p.getPackage_number_to());
			ps.setInt(40,p.getCod_dod_amount());
			ps.setString(41,p.getCod_dod_in_favor());
			ps.setString(42,p.getEss_code());
			ps.setString(43,p.getCod_flag());
			ps.setString(44,p.getGoods_desc().trim());
			ps.setString(45,p.getShipper_tin());		//Shipper GSTIN
			ps.setString(46,p.getReceiver_tin());		//Receiver GSTIN
			ps.setInt(47,p.getDocket_no());
			int k = ps.executeUpdate();
			if(k > 0){
				ps1 = connection.prepareStatement(sql1);
				List<PackageDetails> packageDetails = p.getPackage_details();
				for (int i = 0; i < packageDetails.size();  i++) {
					
					ps1.setFloat(1,packageDetails.get(i).getPkg_ln());
					ps1.setFloat(2,packageDetails.get(i).getPkg_br());
					ps1.setFloat(3,packageDetails.get(i).getPkg_ht());
					ps1.setFloat(4,packageDetails.get(i).getPkg_wt());
					ps1.setInt(5,p.getDocket_no());
					ps1.setInt(6,(p.getPackage_number_from()+i));
					ps1.addBatch();
	                if ((i + 1) % maxBatchSize == 0 || (i + 1) == packageDetails.size()) {
	                    ps1.executeBatch(); 
	                    log.info("packageDetails batch is updated");
	                    }
	            } 
				out.append("{\"error_flag\":\"N\",\"Docket_No\":"+p.getDocket_no()+"}");
				log.info("Docket Package Inserted");
			}
				
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQLException: " + e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
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
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,receiver_pincode);
			rs = ps.executeQuery();
			if(rs.next()){
				out.append("{\"ess_code\":\""+rs.getString(1)+"\",\"attachedou_code\":\""+rs.getString(2)+"\"}");
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			log.error("SQLException: " + e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
			}
		}
		return out.toString();
	}

	//for generate Contract No 
	@Override
	public String getContractNo(String cust_code) {
		log.info("call getContractNo cust_code:"+cust_code);
		String sql = "SELECT gccd.contract_no FROM gems_contract_cust_dtls gccd, gems_cust_contract_mst gccm WHERE gccd.cust_code = ? AND gccd.amend_version = gccm.amend_version AND gccd.contract_no = gccm.contract_no AND gccm.contract_status IN ( 'O', 'A' ) AND gccd.status = 'V' AND TRUNC(to_date(?)) BETWEEN TRUNC(gccm.lof_contract_activation_dt) AND TRUNC(gccm.cust_contract_end_dt) AND ( (gccm.cust_contract_termination_dt IS NOT NULL AND TRUNC(gccm.cust_contract_termination_dt) > TRUNC(to_Date(?))) OR ( gccm.cust_contract_termination_dt IS NULL ) ) AND TO_NUMBER(gccd.amend_version) != 0 AND TO_NUMBER(gccd.amend_version) = ( SELECT MAX(TO_NUMBER(amend_version)) FROM gems_cust_contract_mst WHERE contract_no = gccd.contract_no AND status = 'V' )";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Contract_No = "";
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,cust_code);
			ps.setDate(2,new java.sql.Date(new Date().getTime()));		//gems_docket_mst.bkg_dt
			ps.setDate(3,new java.sql.Date(new Date().getTime()));		//gems_docket_mst.bkg_dt
			rs = ps.executeQuery();
			while(rs.next()){
				Contract_No=rs.getString(1);
			}
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
		} catch (SQLException e) {
			log.error("SQLException: " + e.getMessage());
			//e.printStackTrace();
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
			}
		}
		return Contract_No;
	}
	
	//for generate Docket No
	public String generateDocketNo(PickupDetails p) {
		
		CallableStatement cstmt = null;
		String sp = "{call gemsprod.gems_proc_dkt_generate_java('"+p.getBooking_ou()+"','BAL_30811','"+ p.getBooking_basis()+"',?,?,?)}";
		//String sp = "{call gemsprod.gems_proc_dkt_generate_java(?,?,?,?,?,?)}";
		StringBuffer out = new StringBuffer();
		try {
			log.info("call generateDocketNo CallableStatement :"+sp);
			connection = dataSource.getConnection();
			cstmt = connection.prepareCall(sp);
			
			//inparams
			//cstmt.setString(1, p.getShipper_tin()); 		//Booking_STN 
			//cstmt.setString(2, "BAL_30811"); 	//User Code HARD_CODE
			//cstmt.setString(3, p.getBooking_basis()); 	//Booking Basis
			//outparms
			
			cstmt.registerOutParameter(1, Types.INTEGER); // Generate Docket No
			cstmt.registerOutParameter(2, Types.VARCHAR); //Error Msg
			cstmt.registerOutParameter(3, Types.VARCHAR); //Error Flag	
										
			cstmt.executeUpdate();
			int Docket_No = cstmt.getInt(1);
			String Msg = cstmt.getString(2);
			String Flag = cstmt.getString(3);
			
			out.append("{\"Docket_No\":"+Docket_No+",\"error_flag\":\""+Flag+"\",\"error_msg\":\""+Msg+"\"}");
			cstmt.close();
		} catch (SQLException e) {
			log.error("SQLException: " + e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
			}
		}		
		return out.toString();
	}

	@Override
	public String descTable() {
		StringBuffer out = new StringBuffer();
		try {
			connection = dataSource.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM GEMSPROD.GEMS_GKE_DOCKET_UPLOAD WHERE DOCKET_NO =125602795");
			
			ResultSetMetaData metaData = rs.getMetaData();
			log.info("No of Column:"+metaData.getColumnCount());
			log.info("..........table DESC.......");
			for (int i = 1; i < metaData.getColumnCount(); i++) {
				log.info(""+metaData.getColumnName(i)+"\t"+metaData.getColumnTypeName(i));
			}
			int i=0;
			String comma="";
			out.append("[");
			while(rs.next()){
				out.append(comma+"{\"LOAD_SEQ_NO\":\""+rs.getString(1)+"\",\"DOCKET_CATG\":\""+rs.getString(2)+"\",\"DOCKET_NO\":\""+rs.getString(3)+"\",\"DOCKET_TYPE\":\""+rs.getString(4)+"\",\"BKG_DT\":\""+rs.getString(5)+"\",\"RISK_COVERAGE\":\""+rs.getString(6)+"\",\"REF_DOCKET_NO\":\""+rs.getString(7)+"\",\"BOOKING_STN\":\""+rs.getString(8)+"\",\"DELIVERY_STN\":\""+rs.getString(9)+"\",\"PROD_SERV_CODE\":\""+rs.getString(10)+"\",\"ASSURED_DLY_DT\":\""+rs.getString(11)+"\",\"BILLING_OU\":\""+rs.getString(12)+"\",\"GATEWAY_CODE\":\""+rs.getString(13)+"\",\"NO_OF_PKGS\":\""+rs.getString(14)+"\",\"COMMERCIAL_FLAG\":\""+rs.getString(15)+"\",\"GOODS_CODE\":\""+rs.getString(16)+"\",\"CONSIGNMENT_TYPE\":\""+rs.getString(17)+"\",\"HARM_CODE\":\""+rs.getString(18)+"\",\"DECL_CARGO_VAL\":\""+rs.getString(19)+"\",\"DECL_CARGO_VAL_FC\":\""+rs.getString(20)+"\",\"ACTUAL_WT\":\""+rs.getString(21)+"\",\"VOLUME\":\""+rs.getString(22)+"\",\"UOM\":\""+rs.getString(23)+"\",\"CONV_FACTOR\":\""+rs.getString(24)+"\",\"CHARGED_WT\":\""+rs.getString(25)+"\",\"CTL_VEH_CATG\":\""+rs.getString(26)+"\",\"REQD_TEMP\":\""+rs.getString(27)+"\",\"MASS_MAIL_DOCKET_FLAG\":\""+rs.getString(28)+"\",\"DISTANCE_CTL\":\""+rs.getString(29)+"\",\"DOCS_ENCLOSED\":\""+rs.getString(30)+"\",\"INCOM_DKT_NUM_PART\":\""+rs.getString(31)+"\",\"CONTRACT_NO\":\""+rs.getString(32)+"\",\"CONSIGNOR_CODE\":\""+rs.getString(33)+"\",\"CONSIGNOR_NAME\":\""+rs.getString(34)+"\",\"CONSIGNOR_ADD1\":\""+rs.getString(35)+"\",\"CONSIGNOR_ADD2\":\""+rs.getString(36)+"\",\"CONSIGNOR_ADD3\":\""+rs.getString(37)+"\",\"CONSIGNOR_CITY\":\""+rs.getString(38)+"\",\"CONSIGNOR_ADD4\":\""+rs.getString(39)+"\",\"CONSIGNOR_PHONE_NO\":\""+rs.getString(40)+"\",\"CONSIGNOR_MOBILE_NO\":\""+rs.getString(41)+"\",\"CONSIGNOR_FAX\":\""+rs.getString(42)+"\",\"CONSIGNOR_EMAIL\":\""+rs.getString(43)+"\",\"CONSIGNOR_STATE\":\""+rs.getString(44)+"\",\"CONSIGNOR_COUNTRY\":\""+rs.getString(45)+"\",\"CONSIGNOR_PINCODE\":\""+rs.getString(46)+"\",\"CONSIGNEE_CODE\":\""+rs.getString(47)+"\",\"CONSIGNEE_NAME\":\""+rs.getString(48)+"\",\"CONSIGNEE_ADD1\":\""+rs.getString(49)+"\",\"CONSIGNEE_ADD2\":\""+rs.getString(50)+"\",\"CONSIGNEE_ADD3\":\""+rs.getString(51)+"\",\"CONSIGNEE_CITY\":\""+rs.getString(52)+"\",\"CONSIGNEE_ADD4\":\""+rs.getString(53)+"\",\"CONSIGNEE_PHONE_NO\":\""+rs.getString(54)+"\",\"CONSIGNEE_MOBILE_NO\":\""+rs.getString(55)+"\",\"CONSIGNEE_FAX\":\""+rs.getString(56)+"\",\"CONSIGNEE_EMAIL\":\""+rs.getString(57)+"\",\"CONSIGNEE_STATE\":\""+rs.getString(58)+"\",\"CONSIGNEE_COUNTRY\":\""+rs.getString(59)+"\",\"CONSIGNEE_PINCODE\":\""+rs.getString(60)+"\",\"DOCKET_STATUS\":\""+rs.getString(61)+"\",\"TC_DOCKET_PREPARED_BY\":\""+rs.getString(62)+"\",\"DOCKET_PREPARED_BY\":\""+rs.getString(63)+"\",\"DOCKET_PREPARED_TYPE\":\""+rs.getString(64)+"\",\"MODE_OF_PAYMENT\":\""+rs.getString(65)+"\",\"TAX_TYPE\":\""+rs.getString(66)+"\",\"STATUS\":\""+rs.getString(67)+"\",\"REMARKS\":\""+rs.getString(68)+"\",\"CREATED_BY\":\""+rs.getString(69)+"\",\"LAST_UPDATED_BY\":\""+rs.getString(70)+"\",\"LAST_UPDATED_DATE\":\""+rs.getString(71)+"\",\"CREATED_DATE\":\""+rs.getString(72)+"\",\"UPLOADED_DATA\":\""+rs.getString(73)+"\",\"BOOKING_BASIS\":\""+rs.getString(74)+"\",\"CTL_VEH_FLEET_NO\":\""+rs.getString(75)+"\",\"ORDER_NO\":\""+rs.getString(76)+"\",\"FROM_PKG_NO\":\""+rs.getString(77)+"\",\"TO_PKG_NO\":\""+rs.getString(78)+"\",\"COD_AMT\":\""+rs.getString(79)+"\",\"COD_IN_FAVOUR_OF\":\""+rs.getString(80)+"\",\"COD_INCLUDED\":\""+rs.getString(81)+"\",\"UPLOAD_FLAG\":\""+rs.getString(82)+"\",\"ERROR_UPLOAD_FLAG\":\""+rs.getString(83)+"\",\"ERROR_REASON\":\""+rs.getString(84)+"\",\"DOCKETS_UPDATION_FLAG\":\""+rs.getString(85)+"\",\"TRANSNO\":\""+rs.getString(86)+"\",\"ESS_FLAG\":\""+rs.getString(87)+"\",\"PKG_FLAG\":\""+rs.getString(88)+"\",\"ESS_CODE\":\""+rs.getString(89)+"\",\"CUST_SPECIAL_INSTRUCTION\":\""+rs.getString(90)+"\",\"CUST_REMARKS\":\""+rs.getString(91)+"\",\"CUST_MFG_COUNTRY\":\""+rs.getString(92)+"\",\"UPLOADED_rs.getString(\":\""+rs.getString(93)+"\",\"TRACK_STATUS\":\""+rs.getString(94)+"\",\"SCN_GOODS_CODE\":\""+rs.getString(95)+"\",\"CUST_DATE_DELIVERY\":\""+rs.getString(96)+"\",\"INTERFACE_rs.getString(\":\""+rs.getString(97)+"\",\"HOLD_FLAG\":\""+rs.getString(98)+"\",\"COD_DOD_FLAG\":\""+rs.getString(99)+"\",\"SCAN_DT\":\""+rs.getString(100)+"\",\"SCANNED_PKGS\":\""+rs.getString(101)+"\",\"SPL_SERV_MODE\":\""+rs.getString(102)+"\",\"GOODS_DESC\":\""+rs.getString(103)+"\",\"CONSIGNOR_TINNO\":\""+rs.getString(104)+"\"}");
comma=",";	
				i++;
				
				if(i==200){
					out.append("]");
					break;
				}
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("SQLException: " + e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {log.error("SQLException: " + e.getMessage());}
			}
		}
		return out.toString();
		
	}
	
}
