package com.crop.Repository;
import java.io.*;
import java.sql.*;
import java.util.Properties;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import com.crop.ClientApp.*;

public class DBConfig
{
	protected static Connection conn;
	protected static PreparedStatement stmt;
	protected static ResultSet rs;
	private static DBConfig db=null;
	
	private static final Logger log=Logger.getLogger(DBConfig.class);
	static
	{
		SimpleLayout simple=new SimpleLayout();
		ConsoleAppender console=new ConsoleAppender(simple);
		log.addAppender(console);
		log.setLevel(Level.DEBUG);
	}
	
	public DBConfig()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			File f=new File(".");
			String path=f.getAbsolutePath();
			
			FileInputStream inputstream=new FileInputStream(path+"\\src\\main\\resources\\dbconfig.properties");
			Properties p=new Properties();
			p.load(inputstream);
			
			String driverClassName=p.getProperty("driver");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			String url=p.getProperty("url");

//			System.out.println(driverClassName);
//			System.out.println(username);
//			System.out.println(password);
//			System.out.println(url);

			conn=DriverManager.getConnection(url,username,password);
			
			if(conn!=null)
			{
				System.out.println("Connected");
			}
			else
			{
				System.out.println("Not Connected");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error in DBConfig"+ex);
		}
	}
	
	public static DBConfig getInstance()
	{
		if(db==null)
		{
			db=new DBConfig();
			
		}
		return db;
		
	}
	public static Connection getConnection()
	{
		return conn;	
	}
	public static PreparedStatement getStatement()
	{
		return stmt;	
	}
	
	public static ResultSet getResult()
	{
		return rs;	
	}
//	public static void main(String x[])
//	{
//		new DBConfig();
//	}
}
