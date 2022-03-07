package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Product;
import com.bean.UserAccount;

public class DBUtils {
	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select userName, password, gender from user " //
				+ " where userName = ? and password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String gender = rs.getString("gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select userName, password, gender from user "//
				+ " where userName = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("password");
			String gender = rs.getString("gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static  List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select * from product1";

		PreparedStatement pstm = conn.prepareStatement(sql);
               //Statement stmt=conn.createStatement();
               ResultSet rs = pstm.executeQuery();
		//ResultSet rs = stmt.executeQuery("select * from product1");
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			
		    String code = rs.getString("code");
			String name = rs.getString("name");
			String edition = rs.getString("edition");
			String author = rs.getString("author");
			int quantity=rs.getInt("quantity");
			float price = rs.getFloat("price");
			Product product = new Product();
			
			product.setCode(code);
			product.setName(name);
			product.setEdition(edition);
			product.setAuthor(author);
			product.setQuantity(quantity);
			product.setPrice(price);
			list.add(product);
			//System.out.println(" "+product.getName()+" "+product.getCode()+" "+product.getPrice());
			
			
			
		}
		
		return list;
	
	}

	public static Product findProduct(Connection conn, String code) throws SQLException {
		String sql = "Select code,name,edition,author,quantity,price from product1  where code=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("name");
			String edition = rs.getString("edition");
			String author = rs.getString("author");
			int quantity=rs.getInt("quantity");
			float price = rs.getFloat("price");
			Product product = new Product(code,name,edition,author,quantity, price);
			return product;
		}
		return null;
	}

	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update product1 set name =?,edition=?,author=?,quantity=?,price=? where code=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setString(2, product.getEdition());
		pstm.setString(3, product.getAuthor());
		pstm.setInt(4, product.getQuantity());
		pstm.setFloat(5, product.getPrice());
		pstm.setString(6, product.getCode());
		pstm.executeUpdate();
	}

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into product1(code,name,edition,author,quantity,price) values(?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getCode());
		pstm.setString(2, product.getName());
		pstm.setString(3, product.getEdition());
		pstm.setString(4, product.getAuthor());
		pstm.setInt(5, product.getQuantity());
		pstm.setFloat(6, product.getPrice());

		pstm.executeUpdate();
	}

	public static void deleteProduct(Connection conn, String code) throws SQLException {
		String sql = "Delete From product1 where code= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, code);

		pstm.executeUpdate();
	}

}
