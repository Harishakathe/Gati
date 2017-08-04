package com.mindworx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindworx.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private DataSource dataSource;
	private Connection connection = null;
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getByLoginId(String custLogin) {
		User user = null;
		try {
			connection = dataSource.getConnection();
			String sql = "SELECT * FROM GATI_COM.GW_CUSTOMERS_NEW WHERE CUST_LOGIN = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, custLogin);
			ResultSet rs = ps.executeQuery();			
			if(rs.next()){				
				user = new User();
				user.setCustLogin(rs.getString(1));
				user.setCusId(rs.getInt(2));
				user.setCusName(rs.getString(3));
				user.setCusPword(rs.getString(4));
			}
			rs.close();
			ps.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public User getByCustId(int custId) {
		User user = null;
		try {
			connection = dataSource.getConnection();
			String sql = "SELECT * FROM GATI_COM.GW_CUSTOMERS_NEW WHERE CUST_ID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, custId);
			ResultSet rs = ps.executeQuery();			
			if(rs.next()){
				user = new User();
				user.setCustLogin(rs.getString(1));
				user.setCusId(rs.getInt(2));
				user.setCusName(rs.getString(3));
			}
			rs.close();
			ps.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
