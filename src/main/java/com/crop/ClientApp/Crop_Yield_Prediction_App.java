package com.crop.ClientApp;

import org.apache.log4j.*;
import com.crop.Seriveces.*;
import com.Model.CustModel;
import com.Model.DistModel;
import com.Model.StateModel;

import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crop_Yield_Prediction_App {
	public static Logger log = Logger.getLogger(Crop_Yield_Prediction_App.class);
	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	static {
		SimpleLayout layout = new SimpleLayout();
		ConsoleAppender console = new ConsoleAppender(layout);
		log.addAppender(console);
		log.setLevel(Level.DEBUG);
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\t\t\t....WELCOME TO CROP YIELD PREDICTION....");
		
		List<CustModel> list=new ArrayList<>();
		
		StateService stateservice=new StateServiceImpl();
		DistService distservice=new DistServiceImpl();
		
		StateModel model;
		
		CustModel cmodel=new CustModel();
		
		DistModel dmodel=new DistModel();
		
		
		String admin="1234";
		System.out.println("1.Admin Login");
		System.out.println("2.Customer Login");
		System.out.println("enter your choice");
		int ch=sc.nextInt();
		int adminch,custch;
		sc.nextLine();
		do
		{
			switch(ch)
			{
			// Admin Panel
			
				case 1:
					System.out.println("Please enter password");
					String passkey=sc.nextLine();
					do
					{
						if(passkey.equalsIgnoreCase(admin))
						{
						
							System.out.println("1.Add new State");	
							System.out.println("2.View All State");
							System.out.println("3.Add new District");
							
							System.out.println("Enter your choice");
							adminch=sc.nextInt();
							sc.nextLine();
							
							switch(adminch)
							{
								
								case 1:
									
									System.out.println("Enter statename");
									String statename=sc.nextLine();
					
									boolean b=stateservice.isAddNewState(new StateModel(0,statename));
									if(b)
									{
										log.info("State added Succefully");
									}
									else
									{
										log.info("State not added");
									}
								System.exit(0);
								break;
								
								case 2:
									stateservice.allState();
									break;
									
								case 3:
									System.out.println("Enter state name");
									statename=sc.nextLine();
									System.out.println("Enter District name");
									String distname=sc.nextLine();
									
									dmodel.setDistName(distname);
									b=distservice.isAddNewDist(dmodel);
									if(b)
									{
										System.out.println("District added Sucessfully");
									}
									else
									{
										System.out.println("District not added");
									}
									break;
							}
						}
						else
						{
							System.out.println("Wrong Password");
						}
						break;
					}while(adminch!=0);
				//Customer Panel
				case 2:
				
					do
					{
						System.out.println("1.login customer");
						System.out.println("2.See Previous data");
						System.out.println("3.Register");
						System.out.println("Enter your choice");
						custch=sc.nextInt();
						switch(custch)
						{
						//New Customer Login
							case 1:
								System.out.println("Do you have previous account");
								sc.nextLine();
								String logReply=sc.nextLine();
								if(logReply.equalsIgnoreCase("yes"))
								{
									System.out.println("Please enter your id");
									int custid=sc.nextInt();
								
									sc.nextLine();
									System.out.println("Please enter your name");
									String custname=sc.nextLine();
								
									System.out.println("Please enter your email");
									String email=sc.nextLine();
								
									String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
									Pattern pattern = Pattern.compile(emailRegex);
									Matcher matcher = pattern.matcher(email);
							    
									if (matcher.matches()) 
									{
										System.out.println("The email is valid.");
									} 
									else 
									{
										System.out.println("The email is invalid.");
									}
									cmodel.setCustid(custid);
									cmodel.setCustname(custname);
									cmodel.setCustemail(email);
									boolean c=stateservice.AddDataCust(cmodel);
									if(c)
									{
										log.info("Login sucessfully\n\n");
									}
									else
									{
										log.info("Failed");
									}
									break;
									
								}
								else
								{
									System.out.println("Please Registered");
								}
								break;
							case 2:
								System.out.println("Enter your name");
								sc.nextLine();
								String str=sc.nextLine();
								
								list=stateservice.getCustName(str);
								break;
						}
					}while(custch!=0);
					
						//Old Customer data
					
							
						case 3:
							
							
				}
			
		}while(ch!=0);
	}

}
