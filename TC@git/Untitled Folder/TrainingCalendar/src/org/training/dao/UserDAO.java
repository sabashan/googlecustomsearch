package org.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.training.model.User;
import org.training.util.DBConnection;

public class UserDAO {

 /*To find all users*/		
	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		Connection c = null;		
		String sql = "SELECT u.id_user,u.first_name, u.last_name, g.group_name,u.email,u.password,u.id_role FROM users as u, groups as g WHERE u.id_group=g.id_group";	
		try {
			c = DBConnection.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				list.add(processSummaryRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return list;
	}
	

	/*To find user by email*/	
	public User findByEmail(String email) {

		String sql = "SELECT u.id_user,u.first_name, u.last_name, g.group_name,u.email,u.password,u.id_role FROM users as u, groups as g WHERE u.id_group=g.id_group AND u.email=?";
		User user = null;
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = processRow(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return user;
	}	

	
	/*To find password & role	
	public User findPass(String email) {		

		String sql = "SELECT email,password,id_role FROM users WHERE email=?";		
		User user = null;		
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = processPass(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}				
		return user;		
	}	*/
	
	/* To find role */	
	public User findRole(String email, String pass) {

		String sql = "SELECT email,password,id_role FROM users WHERE email=?";
		User user = null;
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = processRole(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return user;
	}
	
	

	/*To create users*/	
	public User create(User user) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = DBConnection.getConnection();
			ps = c.prepareStatement("INSERT INTO users (first_name, last_name, id_group, email, password,id_role) VALUES (?,?,(SELECT id_group FROM groups WHERE group_name=?),?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getGroup());
			ps.setString(4, user.getEmail());			
			ps.setString(5, user.getPassword());
			ps.setInt(6, 2);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return user;
	}	
	

	/*To update users*/	
	public User update(User user) {
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("UPDATE users SET first_name=?, last_name=?, id_group=(SELECT id_group FROM groups WHERE group_name=?) WHERE email=?");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());			
			ps.setString(3, user.getGroup());
			ps.setString(4, user.getEmail());		
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return user;
	}
	
	
	/*To remove users*/	
	public boolean remove(String email) {
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM users WHERE email=?");
			ps.setString(1, email);
			int count = ps.executeUpdate();
			return count == 1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
	}	
	

	/*To list out single users*/	
	protected User processRow(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id_user"));
		user.setRoleId(rs.getInt("id_role"));		
		user.setFirstName(rs.getString("first_name"));		
		user.setLastName(rs.getString("last_name"));
		user.setGroup(rs.getString("group_name"));
		user.setEmail(rs.getString("email"));
		return user;
	}
	

	/*To list out list of users*/
	protected User processSummaryRow(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id_user"));
		user.setRoleId(rs.getInt("id_role"));
		user.setFirstName(rs.getString("first_name"));		
		user.setLastName(rs.getString("last_name"));
		user.setGroup(rs.getString("group_name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		return user;
	}
	
	
	/*To list out role*/
	protected User processRole(ResultSet rs) throws SQLException {
		User user = new User();		
		user.setEmail(rs.getString("email"));	
		user.setRoleId(rs.getInt("id_role"));
		return user;
	}	
	
	
}
