package com.abzbank;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class model {

	private String name;
	private String Customer_ID;
	private int Account_number;
	private String password;
	private int Balance;
	private String Email;
	private int raccno;

	private Connection con;
	private PreparedStatement psmt;
	private PreparedStatement prepareStatement;
	private ResultSet res;
	
	public ArrayList al = new ArrayList();
	public ArrayList sal = new ArrayList();
	public ArrayList ral = new ArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(String customer_ID) {
		Customer_ID = customer_ID;
	}

	public int getAccont_number() {
		return Account_number;
	}

	public void setAccont_number(int accont_number) {
		Account_number = accont_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getRaccno() {
		return raccno;
	}

	public void setRaccno(int raccno) {
		this.raccno = raccno;
	}

	public model() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "root", "root");
			System.out.println("Driver Loaded and Db connection established");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean Register() throws SQLException {

		String sql = "insert into abzbank(name,custid,accno,password,balance,email) values(?,?,?,?,?,?)";
		psmt = con.prepareStatement(sql);

		psmt.setString(1, name);
		psmt.setString(2, Customer_ID);
		psmt.setInt(3, Account_number);
		psmt.setString(4, password);
		psmt.setInt(5, Balance);
		psmt.setString(6, Email);

		int x = psmt.executeUpdate();

		if (x > 0) {

			return true;
		}

		return false;
	}

	public boolean Login() throws SQLException {

		psmt = con.prepareStatement("select * from abzbank where custid = ? and password = ? ");

		psmt.setString(1, Customer_ID);
		psmt.setString(2, password);

		ResultSet result = psmt.executeQuery();

		if (result.next() == true) {

			Account_number = result.getInt("accno");
			return true;

		}

		return false;
	}

	public boolean checkbalance() throws SQLException {

		String s = "select balance from abzbank where accno = ?";

		psmt = con.prepareStatement(s);

		psmt.setInt(1, Account_number);

		res = psmt.executeQuery();

		while (res.next() == true) {
			Balance = res.getInt("balance");
			return true;
		}

		return false;
	}

	public boolean changePwd() throws SQLException {
		
		String s=  "update abzbank set password=? where accno=?";
		psmt = con.prepareStatement(s);
		psmt.setString(1, password);
		psmt.setInt(2, Account_number);
		int x = psmt.executeUpdate();
		if(x>0) {
		return true;
		}
		return false;
	}
	
	

	public boolean transfer() throws SQLException {
		String s1 = "select * from abzbank where accno = ?";
		psmt = con.prepareStatement(s1);
		psmt.setInt(1, raccno);
		res = psmt.executeQuery();
		while(res.next() == true) {
			System.out.println("s1");
			String s2 = "update abzbank set balance=balance-? where accno = ?";
			psmt = con.prepareStatement (s2);
			psmt.setInt(1, Balance);
			psmt.setInt(2, Account_number);
			int y1 = psmt.executeUpdate();
				if(y1 > 0) {
					System.out.println("s2");
					int x = res.getInt("BALANCE");
					System.out.println("getting balance");
					if(x>0) {
					String s3 = "update abzbank set balance=balance+? where accno = ?";
					psmt = con.prepareStatement(s3);
					psmt.setInt(1, Balance);
					psmt.setInt(2, raccno);
					int y2 = psmt.executeUpdate();
					System.out.println("s3");
					if (y1> 0 && y2>0) {
					System.out.println("s3");
					String s4 = "insert into GetStatement values(?,?,?)";
					psmt = con.prepareStatement(s4);
					psmt.setInt(1, Account_number);
					psmt.setInt(2, raccno);
					psmt.setInt(3, Balance);
					int y = psmt.executeUpdate();
					System.out.println("s4");
					if(y>0) {
					return true; 
					}else {
						
					return false;
					}
					}else {
						return false;
					}}
					else {
						return false;
					}}
					else {
						return false;
					}
		}
		
		return false;
}

	public ArrayList getStatement() throws SQLException {
		
		String s = "select * from GetStatement where accno=?";
		psmt = con.prepareStatement(s);
		psmt.setInt(1, Account_number);
		res = psmt.executeQuery();
		while(res.next() == true) {
		sal.add(res.getInt("ACCNO"));
		ral.add(res.getInt("RACCNO"));
		al.add(res.getInt("BALANCE"));
		}
		return al;
	}

	public boolean applyloan() throws SQLException {
		

		String s = "select * from abzbank where accno=?";
		psmt = con.prepareStatement(s);
		psmt.setInt(1, Account_number);
		res = psmt.executeQuery();
		while(res.next()==true)
		{
			name = res.getString("name");
			Email = res.getString("Email");
			return true;
		}
		
		
		return false;
	}
	
	
}
	
