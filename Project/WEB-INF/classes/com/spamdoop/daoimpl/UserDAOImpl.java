package com.spamdoop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.spamdoop.dao.UserDAO;
import com.spamdoop.pojo.User;
import com.spamdoop.util.MySQLUtility;

public class UserDAOImpl implements UserDAO {

	public List<String> getAllUsers() throws Exception {
		Connection con = null;
		List<String> result = new ArrayList<>();
		try {
			con = MySQLUtility.connect();
			ResultSet rs = con.createStatement().executeQuery("select * from user");
			while (rs.next()) {
				result.add(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}
		return result;

	}

	@Override
	public void register(User user) throws Exception {

		Connection con = null;
		try {
			con = MySQLUtility.connect();
			PreparedStatement ps = con.prepareStatement("insert into user values (?,?,?,?,?,?,?,?) ");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(4, user.getRole());
			ps.setString(5, user.getFname());
			ps.setString(6, user.getLname());
			ps.setString(7, user.getGender());
			ps.setString(8, user.getMobile());
			ps.setString(3, user.getAddr());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}
	}

	@Override
	public User getUserDetails(String email, String password) throws Exception {
		Connection con = null;
		try {
			con = MySQLUtility.connect();
			PreparedStatement ps = con.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs.next();
			User user = new User();
			user.setAddr(rs.getString("addr"));
			user.setEmail(rs.getString("email"));
			user.setFname(rs.getString("fname"));
			user.setLname(rs.getString("lname"));
			user.setGender(rs.getString("gender"));
			user.setMobile(rs.getString("mobile"));
			user.setRole(rs.getString("role"));
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

	}

	@Override
	public void updateProfile(User user) throws Exception {
		Connection con = null;
		try {
			con = MySQLUtility.connect();
			PreparedStatement ps = con.prepareStatement(
					" update user set role=?, fname=?, lname=?, gender=?, mobile=?, addr=? where email=?");
			ps.setString(1, user.getRole());
			ps.setString(2, user.getFname());
			ps.setString(3, user.getLname());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getMobile());
			ps.setString(6, user.getAddr());
			ps.setString(7, user.getEmail());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}

	}

	@Override
	public void deleteProfile(String email) throws Exception {
		Connection con = null;
		try {
			con = MySQLUtility.connect();
			PreparedStatement ps = con.prepareStatement("delete from user where email=?");
			ps.setString(1, email);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}

	}

	@Override
	public boolean changePassword(String email, String oldpassword, String newpassword) throws Exception {
		Connection con = null;
		try {
			con = MySQLUtility.connect();
			PreparedStatement ps = con.prepareStatement("select password from user where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if (rs.getString(1).equals(oldpassword)) {
				PreparedStatement ps2 = con.prepareStatement("update user set password=? where email=?");
				ps2.setString(1, newpassword);
				ps2.setString(2, email);
				ps2.execute();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}

	}

	@Override
	public String forgotPassword(String email) throws Exception {
		Connection con = null;
		try {
			con = MySQLUtility.connect();
			PreparedStatement ps = con.prepareStatement("select password from user where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

	}

}
