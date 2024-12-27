package com.crop.ClientApp;

import org.apache.log4j.*;
import com.crop.Seriveces.*;

import com.Linear_Regression_Services.Crop_Yield_Prediction_Using_Linear_Regression;
import com.Linear_Regression_Services.Crop_Yield_Prediction_Using_Linear_Regression_Impl;

import com.Model.AdminMaster;
import com.Model.CityModel;
import com.Model.CropModel;
import com.Model.DistModel;
import com.Model.OldDataSetModel;
import com.Model.StateModel;

import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Crop_Yield_Prediction_App extends Thread 
{
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

	public static void main(String[] args) throws SQLException, InterruptedException 
	{
		
		SimpleLayout layout = new SimpleLayout();
		ConsoleAppender console = new ConsoleAppender(layout);
		log.setLevel(Level.ALL);
		log.addAppender(console);

		StateService stateService = new StateServiceImpl();
		DistService distService = new DistServiceImpl();
		CityService cityService = new CityServiceImpl();
		OldDataSetService olddataService = new OldDataSetServiceImpl();
		CropService cropservice = new CropServiceImpl();
		AdminCredentialService adminservice = new AdminCredentialServiceImpl();
		CustomerLoginService customerService = new CustomerLoginServiceImpl();
		
		StateModel statemodel = new StateModel();
		DistModel distmodel = new DistModel();
		CityModel citymodel = new CityModel();
		OldDataSetModel olddataModel = new OldDataSetModel();
		CropModel cropModel = new CropModel();
		AdminMaster adminmaster = new AdminMaster();
		Crop_Yield_Prediction_Using_Linear_Regression getCropYield = new Crop_Yield_Prediction_Using_Linear_Regression_Impl();
		int choice;

		Scanner sc = new Scanner(System.in);
		// System.out.println(" Welcome to Crop Yield Prediction App !!! ");

		do 
		{
			System.out.println("\t\t\t********************************************");
			System.out.println("\t\t\t* Welcome to the Crop Yield Prediction App *");
			System.out.println("\t\t\t********************************************");
			System.out.println("\t\t\t    Presented By Sanket & Shubham           ");
			System.out.println(" LOGIN for ");
			System.out.println(" 1 : ADMIN ");
			System.out.println(" 2 : CUSTOMER ");
			System.out.println(" 3 : System Exit");
			System.out.println("");

			System.out.println("Enter Your Choice :");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) 
			{
				case 1:

				System.out.println("Enter username :");
				String username = sc.nextLine();

				System.out.println("Enter password :");
				String password = sc.nextLine();

				if (adminservice.isAdminMatch(username, password)) 
				{
					System.err.println("Please Wait Don't press exit buttun......✖️");
					Thread.sleep(10000);
				
					System.out.println("\n====================================================\n");
							    log.info("  Admin Verification Successful :             ");
							    int choice2;
					do {
						System.out.println("\n====================================================\n");
						System.out.println("1 : State Info");
						System.out.println("2 : District Info:");
						System.out.println("3 : City Info");
						System.out.println("4 : Crop Info:");
						System.out.println("12 : To Add Old Data Set ");
						System.out.println("13 : Display all Old Data  of Three Years :");

						System.out.println("Enter your choice :");
						choice2 = sc.nextInt();

						String stateName;
						boolean b;
						String distName;
						int cityId;
						String fertilizer;
						switch (choice2) 
						{
							case 1:
								int statechoice;
								do
								{
									
									System.out.println("1. Add State");
									System.out.println("2. View All State");
									System.out.println("3 : Search State Name");
									System.out.println("4 : Delete State By Id");
									System.out.println("5 : Update State By Id");
									
									System.out.println("Enter your choice");
									statechoice=sc.nextInt();
									switch(statechoice)
									{
										case 1:
											boolean isStateAdd = stateService.isAddedNewState(statemodel);

											if (isStateAdd)
											{
												System.out.println("\n====================================================\n");
												log.info("State Added Succcessfully");
												System.out.println("\n====================================================\n");

											} 
											else 
											{
												log.info("State is not Added :");
											}

										break;
										case 2:
											stateService.allState();
											break;
										case 3:
											System.out.println("Enter state name for search");
											sc.nextLine();
											stateName=sc.nextLine();
											StateModel model=stateService.getStateByName(stateName);
											if(model!=null)
											{
												System.out.println("=======================================================");
												System.out.println(model.getStateid()+"\t"+model.getStatename());
												System.out.println("=======================================================");
											}
											else
											{
												
												log.info("State not found");
											}
											break;
											
										case 4:
											System.out.println("Enter State Name for Delete");
											sc.nextLine();
											stateName=sc.nextLine();
									
											b=stateService.isDeleteState(stateName);
											if(b)
											{
												log.info("State Deleted Successfully");
											}
											else
											{
												log.info("State Not Deleted");
											}
											break;
									}
								}while(statechoice!=0);
							break;	
							case 2:
								int distchoice;
								do
								{
									System.out.println("1. Add District");
									System.out.println("2. View All District");
									System.out.println("3 : Search District Name");
									System.out.println("4 : Delete District By Id");
									System.out.println("5 : Update District By Id");
									
									System.out.println("Enter your choice");
									distchoice=sc.nextInt();
									
									switch(distchoice)
									{
										case 1:
											
											System.out.println("Enter State name");
											sc.nextLine();
											stateName=sc.nextLine();
											String fetchState=distService.getStateName(stateName);		
											
											if(fetchState !=null && fetchState.equals(stateName))
											{
												System.out.println("Enter dist name");
												distName=sc.nextLine();
												b=distService.isAssociateDistToState(stateName, distName);
												if(b)
												{
													log.info("District added Successfully");
												}
												else
												{
													log.info("District not added");
												}
												
											}
											else
											{
												System.out.println("State not matched");
											}
										break;
										case 2:
											distService.districtList();
										break;
											
										case 3:
											
										break;	
									}
									
								}while(distchoice!=0);
							break;	
							case 3:
								int citychoice;
								do
								{
									System.out.println("1. Add City");
									System.out.println("2. View All City");
									System.out.println("3 : Search City Name");
									System.out.println("4 : Delete City By Id");
									System.out.println("5 : Update City By Id");
									
									System.out.println("Enter your choice");
									citychoice=sc.nextInt();
									switch(citychoice)
									{
										case 1:
											System.out.println("Enter District name for add city");
											sc.nextLine();
											distName=sc.nextLine();
											
											String fetchdist=distService.getDistrictName(distName);
											
											if(fetchdist != null && fetchdist.equals(distName))
											{
												System.out.println("Enter city name");
												String cityName=sc.nextLine();
												
												b=cityService.isCityAdded(distName, cityName);
												if(b)
												{
													log.info("City added sucessfully");
												}
												else
												{
													log.info("City not added");
												}
												
											}
											else
											{
												System.out.println("District not found");
											}
											
										break;
										case 2:

											cityService.getAllCity();
											break;
											
									}
								}while(citychoice!=0);
							break;
							case 4:
								int cropchoice;
								do
								{
									System.out.println("1. Add Crop");
									System.out.println("2. View All Crop");
									System.out.println("3 : Search Crop Name");
									System.out.println("4 : Delete Crop By Id");
									System.out.println("Enter your choice");
									cropchoice=sc.nextInt();
									switch(cropchoice)
									{
										case 1:
											System.out.println("Enter crop name");
											sc.nextLine();
											String cropname=sc.nextLine();
											System.out.println("Enter fertilizer");
											fertilizer=sc.nextLine();
											System.out.println("Enter temperature");
											String temp=sc.nextLine();
											System.out.println("Enter Soil PH level");
											Double pH=sc.nextDouble();
											sc.nextLine();
											System.out.println("Enter current year Rainfall Average");
											int rainfall=sc.nextInt();
											System.out.println("Enter state id");
											int stateId=sc.nextInt();
											System.out.println("Enter Dist id");
											int distId=sc.nextInt();
											System.out.println("Enter City id");
											cityId=sc.nextInt();
											System.out.println("Enter Farm Area");
											int Area=sc.nextInt();
											b=cropservice.isCropAdded(cropname, fertilizer, temp, pH, rainfall, stateId, distId, cityId, Area);
											if(b)
											{
												log.info("Crop added Successfully");
											}
											else
											{
												log.info("Crop not added");
											}
										break;
										case 2:
											
											cropservice.allCropList();

										break;
									}
								}while(cropchoice!=0);
							
							break;

							
							case 12:
								System.out.println("Enter crop id");
								int cropid=sc.nextInt();
								sc.nextLine();
								System.out.println("Crop name");
								String cropname=sc.nextLine();
								System.out.println("Enter fertilizer");
								sc.nextLine();
								int Fertilizer=sc.nextInt();
								System.out.println("Enter Soil PH level");
								float ph=sc.nextFloat();
								System.out.println("Enter Temperature");
								float temp1=sc.nextFloat();
								System.out.println("Enter Previous 3 Year Rainfall Average");
								float rainfall1=sc.nextFloat();
								System.out.println("Enter Yield");
								float yield=sc.nextFloat();
								System.out.println("Enter year");
								int year=sc.nextInt();
								sc.nextLine();
								System.out.println("Enter Season");
								String season=sc.nextLine();
								System.out.println("Enter City Id");
								cityId=sc.nextInt();
								
								
								b=olddataService.isOldDataSetAdded(cropid, Fertilizer, ph,temp1, rainfall1, yield, year, season, cityId,cropname);
								if(b)
								{
									log.info("Old data added Succefully");
								}
								else
								{
									log.info(season);
								}
										
							case 13:

								olddataService.olddataset();
								break;
							}
						}while(choice2!=0);
					}
					else 
					{
						log.info("Admin Not Found !!! Thank You ");
					}
				
				break;
			case 2:
				
					System.out.println("\n====================================================\n");

					

					System.out.println("\n====================================================\n");
					int choice3;
					int custchoice;
					do
					{
						System.out.println(" 1 : Customer LOGIN :");
						System.out.println(" 2 : Customer Already Registered :");
						System.out.println(" 3 : Registration of Customer :");
						System.out.println(" 4 : System Exit :");
						System.out.println(" Enter Your Choice : ");
					
						choice3 = sc.nextInt();
						switch (choice3)
						{
							
							case 1:
							System.out.println("Do you have Previous Account : Yes or No");
							sc.nextLine();
							String message = sc.nextLine();
							if (message.equalsIgnoreCase("yes")) 
							{
								System.out.println("Enter username :");
								 username = sc.nextLine();

								System.out.println("Enter password :");
								password = sc.nextLine();

								if (customerService.isCustomerMatch(username, password)) 
								{
									System.out.println("\n====================================================\n");

									System.out.println("Customer Verification Successful ");
									System.out.println("\n====================================================\n");
									
									do
									{
										System.out.println("1 : Crop Yield Price using Linear Regression :");
										System.out.println("2 : Your  Information :");
										System.out.println("3 : System Exit :");
										System.out.println("Enter your Choice :");
										custchoice =sc.nextInt();
										sc.nextLine();
										switch(custchoice)
										{
											case 1:
											
												System.out.println("Enter Crop Details to calculate the Yield :");
											
												System.out.println("Enter the cropName :");
												String cropname =sc.nextLine();
												System.out.println("Enter the  Temperature of your your region :");
												float temperature = sc.nextFloat();
												System.out.println("Enter the Rainfall of your region :");
												float rainfall = sc.nextFloat();
												System.out.println("Enter the soil pH value of Your Farm :");
												float pH = sc.nextFloat();
											
												System.out.println("Enter the Quantity of Fertilizer in kg : ");
												float fertilizer = sc.nextFloat();
												
												float cropYield = getCropYield.getCropYield(cropname, temperature, rainfall, pH, fertilizer);
												
												System.out.println("The Crop Yield for the CropName :"+cropname+" is :"+cropYield );
												break;
										}
									}while(custchoice!=0);

								}
								else 
								{
									System.out.println("Opps !!! Customer Not Found : ");
								}
							} 
							else
							{
								System.out.println("\n====================================================\n");
								System.out.println("\t$              Please do Registration              $");
								System.out.println("\n====================================================\n");

							}
							break;
					
							case 2:

								sc.nextLine();
								System.out.println("Enter Your Email :");
								String email = sc.nextLine();

								customerService.allLoginCustomer(email);

								break;
							case 3:

						        System.out.print("Enter First Name: ");
						        sc.nextLine();
						        String firstName = sc.nextLine();
						        
						        System.out.print("Enter Last Name: ");
						        String lastName = sc.nextLine();
						        
						        System.out.print("Enter Email: ");
						        email = sc.nextLine();
						        
						        System.out.print("Enter Password: ");
						        password = sc.nextLine();
						        
						        System.out.print("Enter Phone Number: ");
						        String phoneNumber = sc.nextLine();
						        
						        System.out.print("Enter Address: ");
						        String address = sc.nextLine();
						        
						        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
						        String dateOfBirth = sc.nextLine();
						    
						        boolean b=customerService.isRegCust(firstName, lastName, email, password, phoneNumber, address,dateOfBirth);
						        if(b)
						        {
						        	log.info("Customer Registration is Successful :");
						        }
						        else
						        {
						        	log.info("Customer Registration Failed:");
						        }
								break;
						
						}
			
					}while(choice3!=0);
			}

		} while (choice != 0);	
	}
}
