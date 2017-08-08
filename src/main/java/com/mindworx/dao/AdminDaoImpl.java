package com.mindworx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindworx.model.Admin;
import com.mindworx.model.User;

@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private DataSource dataSource;
	private Connection connection = null;
	
	@Override
	public Admin getByLoginId(String userid) {
		Admin admin = null;
		try {
			connection = dataSource.getConnection();
			String sql = "SELECT * FROM GEMSPROD.GEMS_MOBILE_LOGIN WHERE STATUS ='V' AND USERID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rs = ps.executeQuery();			
			if(rs.next()){				
				admin = new Admin();
				admin.setOuCode(rs.getString(1));
				admin.setUserid(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setStatus(rs.getString(4));
				//lastdate
			}
			rs.close();
			ps.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
		
	}
	
}
