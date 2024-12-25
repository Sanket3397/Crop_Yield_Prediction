package com.crop.ClientApp;

import org.apache.log4j.*;
import com.crop.Seriveces.*;
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

public class Crop_Yield_Prediction_App 
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

	public static void main(String[] args) throws SQLException 
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
		int choice;

		Scanner sc = new Scanner(System.in);
		// System.out.println(" Welcome to Crop Yield Prediction App !!! ");

		do 
		{
			System.out.println("\t\t\tWelcome to the Crop Yield Prediction App ");
			System.out.println("\t\t\t****************************************");
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
					
					System.out.println("\n====================================================\n");
							    log.info("  Admin Verification Successful :             ");
							    int choice2;
					do {
						System.out.println("\n====================================================\n");
						System.out.println("1 : Add State");
						System.out.println("2 : View all State :");
						System.out.println("3 : Search State Name");
						System.out.println("4 : Delete State By Id");
						System.out.println("5 : Update State By Id");
						System.out.println("6 : Add Single District :");
						System.out.println("7 : Display all District :");
						System.out.println("8 : Add City :");
						System.out.println("9 : View All Cities :");
						System.out.println("10: Add Crop Data of Farmer :");
						System.out.println("11: View All Crops :");
						System.out.println("12 : To Add Old Data Set ");
						System.out.println("13 : Display all Old Data  of Three Years :");

						System.out.println("Enter your choice :");
						choice2 = sc.nextInt();

						switch (choice2) 
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
								String stateName=sc.nextLine();
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
						
								boolean b=stateService.isDeleteState(stateName);
								if(b)
								{
									log.info("State Deleted Successfully");
								}
								else
								{
									log.info("State Not Deleted");
								}
								break;
							case 6:
								String distName;
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

							case 7:

								distService.districtList();

								break;

							case 8:
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
							case 9:

								cityService.getAllCity();
								break;

							case 10:

								boolean isCropAdded = cropservice.isCropAdded(cropModel);
								if (isCropAdded)
								{
									log.info("Crop Added to the Database :");

								} 
								else
								{
									log.info("Opps !!! Some problem occurs :");
								}

								break;

							case 11:

								cropservice.allCropList();

								break;

							case 12:

								boolean is_Old_Data_Set_Added = olddataService.isOldDataSetAdded(olddataModel);

								if (is_Old_Data_Set_Added)
								{
									log.info("Old Data Set is Successfully Added to your DataBase :");

								} 
								else
								{
									log.info(
									"Opps !!! Some problem is Occured While entering the data in OLD DATA SET table :");
								}

								break;

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

							}
							else 
							{
								System.out.println("Opps !!! Customer Not Found : ");
							}
						} 
						else
						{
							System.out.println("\n====================================================\n");

							System.out.println("Please do Registration");
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

								boolean isCustomerLoign =customerService.isAddedCustomerLogin();
								if(isCustomerLoign)
								{
									System.out.println("\n====================================================\n");

									log.info("Customer Registration is Successful :");
									System.out.println("\n====================================================\n");

							
								}
								else
								{
									System.out.println("\n====================================================\n");

									log.info("Opps !! Some problem Occurs :");
							
									System.out.println("\n====================================================\n");

								}

								break;
						}
			
					}while(choice3!=0);
			}

		} while (choice != 0);
		
	}
}
