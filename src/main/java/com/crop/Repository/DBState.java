package com.crop.Repository;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBState 
{
	DBConfig config= DBConfig.getInstance();
	protected Connection conn=DBConfig.getConnection();
	protected PreparedStatement stmt= DBConfig.getStatement();
	protected ResultSet rs= DBConfig.getResult();
	protected CallableStatement cstmt=DBConfig.getCallStatement();
	
	DBState()
	{
	//	System.out.println(config.getConnection());
	}
}
