package com.crop.ClientApp;

import org.apache.log4j.*;
import com.crop.Seriveces.*;

import com.Linear_Regression_Services.*;
import com.Linear_Regression_Model.*;
import com.Linear_Regression_Services.Crop_Yield_Prediction_Using_Linear_Regression;
import com.Linear_Regression_Services.Crop_Yield_Prediction_Using_Linear_Regression_Impl;

import com.Model.AdminMaster;
import com.Model.CityModel;
import com.Model.CropModel;
import com.Model.CustomerLoginModel;
import com.Model.DistModel;
import com.Model.OldDataSetModel;
import com.Model.StateModel;

import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crop_Yield_Prediction_App extends Thread {
	public static Logger log = Logger.getLogger(Crop_Yield_Prediction_App.class);
	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	static {
		SimpleLayout layout = new SimpleLayout();
		ConsoleAppender console = new ConsoleAppender(layout);
		log.addAppender(console);
		log.setLevel(Level.ALL);
	}

	public static void main(String[] args) throws SQLException, InterruptedException {

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
		Filter_Data filterService=new Filter_Data_Impl();

		StateModel statemodel = new StateModel();
		DistModel distmodel = new DistModel();
		CityModel citymodel = new CityModel();
		OldDataSetModel olddataModel = new OldDataSetModel();
		CropModel cropModel = new CropModel();
		AdminMaster adminmaster = new AdminMaster();

		GetMinOfXService getMinService = new Get_MinService_Impl();
		Get_Min_of_Y_Service getMin_Of_Y_Service = new Get_MinOf_Service_Impl();
		Deviation_Of_X_Service deviationService = new Deviation_Of_X_Service_Impl();
		Deviation_Of_Y_Service deviationOfYService = new Deviation_Of_Y_Service_Impl();
		Product_Of_Dev_of_X_Y_Service prodev_X_Y = new Product_Of_Dev_of_X_Y_Service_Impl();
		Sum_Of_Prod_Dev_X_Y_Service sum_of_Dev_X_Y = new Sum_Of_Prod_Dev_X_Y_Service_Impl();
		Sum_of_Square_of_Dev_X_Service sum_of_square_X = new Sum_of_Square_of_Dev_X_Service_Impl();
		Get_ValueOf_M_Services getValue_M = new Get_Value_of_M_Services_Impl();
		Get_Value_B_Intercept_Service getValueOfB = new Get_Value_B_Intercept_Service__Impl();
		Crop_Yield_Prediction_Using_Linear_Regression getCropYield = new Crop_Yield_Prediction_Using_Linear_Regression_Impl();

		int choice;

		Scanner sc = new Scanner(System.in);
		// System.out.println(" Welcome to Crop Yield Prediction App !!! ");

		do {
			Thread.sleep(1000);
			System.out.println("==================================================================================================================================");
			System.out.println("                   \t\t\t🌽🧅🌶️🥦🫛🥬🫑🥕🫒🧄🧅🥔🌽🧅🌶️🥦🫛🥬🫑🥕🫒🧄🧅🥔🌽🧅🌶");
			System.out.println("                    \t\t\t  Welcome to the Crop Yield Prediction App  ");
			System.out.println("                   \t\t\t🌽🧅🌶️🥦🫛🥬🫑🥕🫒🧄🧅🥔🌽🧅🌶️🥦🫛🥬🫑🥕🫒🧄🧅🥔🌽🧅🌶");
			System.out.println("                   \t\t\t     Presented By Sanket & Shubham           ");
			System.out.println("==================================================================================================================================");
			Thread.sleep(1000);
			System.out.println(" LOGIN for ");
			System.out.println(" 1 : ADMIN ");
			System.out.println(" 2 : CUSTOMER ");
			System.out.println(" 3 : System Exit");
			System.out.println("");

			System.out.println("Enter Your Choice :");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:

				System.out.println("Enter username :");
				String username = sc.nextLine();

				System.out.println("Enter password :");
				String password = sc.nextLine();

				if (adminservice.isAdminMatch(username, password)) {
					System.err.println("Please Wait Don't press exit buttun......✖️");
					Thread.sleep(1000);

					System.out.println("\n====================================================\n");
					log.info("  Admin Verification Successful :             ");
					int choice2;
					do {
						System.out.println("\n====================================================\n");
						System.out.println("1 : State Info");
						System.out.println("2 : District Info:");
						System.out.println("3 : City Info");
						System.out.println("4 : Crop Info:");
						System.out.println("5 : To Add Old Data Set ");
						System.out.println("6 : Display all Old Data  of Three Years :");
						System.out.println("7 : Get MIN(Temp) using crop Name");
						System.out.println("8 : Get MIN_Of_Y(Yield)  using crop Name ");
						System.out.println("9 : Get deviation of X using crop Name :");
						System.out.println("10 : Get Deviation of Y (yield ) using crop Name :");
						System.out.println("11 : The Product of Deviation of X & Y :");
						System.out.println("12 : The Sum of Product of Deviation of X and Y :");
						System.out.println("13 : The Sum of Square of Deviation of X ");
						System.out.println("14 : The Value of Slope of M (Temp)");
						System.out.println("15 : The Value of Intersept B ");
						System.out.println("16 : Prediction of Crop Yield using Linear Regression :");
						System.out.println("17 : Filter crop data season wise");
						System.out.println("\n====================================================\n\n");
						System.out.println("Enter your choice :");
						choice2 = sc.nextInt();

						String stateName;
						boolean b;
						String distName;
						int cityId;
						int fertilizer;
						switch (choice2) {
						case 1:
							int statechoice;
							do {

								System.out.println("1. Add State");
								System.out.println("2. View All State");
								System.out.println("3 : Search State Name");
								System.out.println("4 : Delete State By Id");
								System.out.println("5 : Update State By Id");

								System.out.println("Enter your choice");
								statechoice = sc.nextInt();
								switch (statechoice) {
								case 1:
									boolean isStateAdd = stateService.isAddedNewState(statemodel);

									if (isStateAdd) {
										System.out.println("\n====================================================\n");
										log.info("State Added Succcessfully");
										System.out.println("\n====================================================\n");

									} else {
										log.info("State is not Added :");
									}

									break;
								case 2:
									stateService.allState();
									break;
								case 3:
									System.out.println("Enter state name for search");
									sc.nextLine();
									stateName = sc.nextLine();
									StateModel model = stateService.getStateByName(stateName);
									if (model != null) {
										System.out.println("=======================================================");
										System.out.println(model.getStateid() + "\t" + model.getStatename());
										System.out.println("=======================================================");
									} else {

										log.info("State not found");
									}
									break;

								case 4:
									System.out.println("Enter State Name for Delete");
									sc.nextLine();
									stateName = sc.nextLine();

									b = stateService.isDeleteState(stateName);
									if (b) {
										log.info("State Deleted Successfully");
									} else {
										log.info("State Not Deleted");
									}
									break;
								case 5:
									sc.nextLine();
									System.out.println("Enter State current name");
									String currName=sc.nextLine();
									System.out.println("Enter New State Name");
									stateName=sc.nextLine();
									b=stateService.isUpdateState(currName, currName);
									if(b)
									{
										log.info("State updated Succefully");
									}
									else
									{
										log.info("State not updated");
									}
									break;
								}
							} while (statechoice != 0);
							break;
						case 2:
							int distchoice;
							do {
								System.out.println("1. Add District");
								System.out.println("2. View All District");
								System.out.println("3. Add Bulk Excel Data");
								System.out.println("4 : Search District Name");
								System.out.println("5 : Delete District By Id");
								System.out.println("6: Update District By Id");

								System.out.println("Enter your choice");
								distchoice = sc.nextInt();

								switch (distchoice) {
								case 1:

									System.out.println("Enter State name");
									sc.nextLine();
									stateName = sc.nextLine();
									String fetchState = distService.getStateName(stateName);

									if (fetchState != null && fetchState.equals(stateName)) {
										System.out.println("Enter dist name");
										distName = sc.nextLine();
										b = distService.isAssociateDistToState(stateName, distName);
										if (b) {
											log.info("District added Successfully");
										} else {
											log.info("District not added");
										}

									} else {
										System.out.println("State not matched");
									}
									break;
								case 2:
									distService.districtList();
									break;
									
								case 3:
									
									String path="E:\\disk2.xlsx";
									 
									boolean result = distService.isAddBulkDist(path); // Call the method and pass the path

								    if (result) 
								    {
								        System.out.println("Bulk Data of Crop is Successfully Added to the Database.");
								    } 
								    else 
								    {
								        System.out.println("Oops!!! Some problem found while adding data.");
								    }
								    break;
								case 4:
									System.out.println("Enter Dist name for search");
									sc.nextLine();
									distName = sc.nextLine();
									DistModel dmodel = distService.getDistByName(distName);
									if (dmodel != null) {
										System.out.println("=======================================================");
										System.out.println(dmodel.getDistrictid() + "\t" + dmodel.getDistrictname());
										System.out.println("=======================================================");
									} else {

										log.info("District not found");
									}
									break;
								case 5:
									System.out.println("Enter District Name for Delete");
									sc.nextLine();
									distName = sc.nextLine();

									b = distService.isDeleteDist(distName);
									if (b) {
										log.info("District Deleted Successfully");
									} else {
										log.info("District Not Deleted");
									}
									break;
								}

							} while (distchoice != 0);
							break;
						case 3:
							int citychoice;
							do {
								System.out.println("1. Add City");
								System.out.println("2. View All City");
								System.out.println("3 : Search City Name");
								System.out.println("4 : Delete City By Id");
								System.out.println("5 : Update City By Id");

								System.out.println("Enter your choice");
								citychoice = sc.nextInt();
								switch (citychoice) {
								case 1:
									System.out.println("Enter District name for add city");
									sc.nextLine();
									distName = sc.nextLine();

									String fetchdist = distService.getDistrictName(distName);

									if (fetchdist != null && fetchdist.equals(distName)) {
										System.out.println("Enter city name");
										String cityName = sc.nextLine();

										b = cityService.isCityAdded(distName, cityName);
										if (b) {
											log.info("City added sucessfully");
										} else {
											log.info("City not added");
										}

									} else {
										System.out.println("District not found");
									}

									break;
								case 2:

									cityService.getAllCity();
									break;

								}
							} while (citychoice != 0);
							break;
						case 4:
							int cropchoice;
							do {
								System.out.println("1. Add Crop");
								System.out.println("2. View All Crop");
								System.out.println("3 : Search Crop Name");
								System.out.println("4 : Delete Crop By Id");
								System.out.println("Enter your choice");
								cropchoice = sc.nextInt();
								switch (cropchoice) {
								case 1:
									sc.nextLine();
									System.out.println("Enter crop name");
									sc.nextLine();
									String cropname = sc.nextLine();
									System.out.println("Enter season");
									String season=sc.nextLine();
									
									System.out.println("Enter fertilizer");
									fertilizer = sc.nextInt();
									System.out.println("Enter temperature");
									String temp = sc.nextLine();
									System.out.println("Enter Soil PH level");
									Double pH = sc.nextDouble();
									sc.nextLine();
									System.out.println("Enter current year Rainfall Average");
									int rainfall = sc.nextInt();
									System.out.println("Enter state id");
									int stateId = sc.nextInt();
									System.out.println("Enter Dist id");
									int distId = sc.nextInt();
									System.out.println("Enter City id");
									cityId = sc.nextInt();
									System.out.println("Enter Farm Area");
									int Area = sc.nextInt();
									b = cropservice.isCropAdded(cropname, fertilizer, temp, pH, rainfall, stateId,
											distId, cityId, Area,season);
									if (b) {
										log.info("Crop added Successfully");
									} else {
										log.info("Crop not added");
									}
									break;
								case 2:

									cropservice.allCropList();

									break;
								}
							} while (cropchoice != 0);

							break;

						case 5:
							sc.nextLine();
							System.out.println("Crop name");
							String cropname = sc.nextLine();
							System.out.println("Enter fertilizer");

							int Fertilizer = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter Soil PH level");
							float ph = sc.nextFloat();
							System.out.println("Enter Temperature");
							float temp = sc.nextFloat();
							System.out.println("Enter Previous 3 Year Rainfall Average");
							float rainfall = sc.nextFloat();
							System.out.println("Enter Yield");
							float yield = sc.nextFloat();
							System.out.println("Enter year");
							int year = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter Season");
							String season = sc.nextLine();
							System.out.println("Enter City Id");
							cityId = sc.nextInt();

							b = olddataService.isOldDataSetAdded(Fertilizer, ph, temp, rainfall, yield, year, season,
									cityId, cropname);
							if (b) {
								log.info("Old data added Succefully");
							} else {
								log.info(season);
							}
							break;
						case 6:

							olddataService.olddataset();
							break;

						// +=====================================================================================================
						// ------------------=

						case 7:

							System.out.println("Enter the Crop Name to see the Min of X of Temperature :");
							String name = sc.nextLine();
							float minOfX_Temp = getMinService.getMinOfTemp(name);

							System.out.println("==============================================================");
							System.out.println(" The Min of X ie (Temp)  is :" + minOfX_Temp);
							System.out.println("==============================================================");

							break;

						case 8:
							System.out.println("Enter the  Crop Name to calculate the Min Of Y (Yield) :");
							cropname = sc.nextLine();
							float min_of_Y_Yield = getMin_Of_Y_Service.getMinOfYeild(cropname);
							System.out.println("\n==============================================================\n");
							System.out.println("The Min of Y yield is :" + min_of_Y_Yield);
							System.out.println("\n==============================================================\n");
						case 9:
							System.out.println(
									"Enter the Crop Name to see the Deviation of X(Temperature) using CropName:");
							cropname = sc.nextLine();
							List<Float> deviationList = deviationService.getDeviationOfTemp(cropname);

							System.out.println("\n==============================================================\n");
							System.out.println("The Deviation of X (Temp) is:");
							deviationList.forEach(deviation -> System.out.println(deviation));
							System.out.println("\n==============================================================\n");
							break;

						case 10:
							System.out
									.println("Enter the Crop Name to see the Deviations of Y (Yield) using Crop Name:");
							cropname = sc.nextLine();

							List<Float> deviationOfYList = deviationOfYService.deviation_Of_Y(cropname);

							// Print the deviations
							System.out.println("The Deviations of Y (Yield) are:");
							System.out.println("\n==============================================================\n");
							deviationOfYList.forEach(System.out::println);
							System.out.println("\n==============================================================\n");
							break;

						case 11:

							System.out.println("Enter the Crop Name:");
							cropname = sc.nextLine();

							List<Float> prodOfDevXAndYList = prodev_X_Y.product_of_Dev_X_and_Y(cropname);

							System.out.println("The Products of Deviations of X and Y are:");

							System.out.println("\n==============================================================\n");
							prodOfDevXAndYList.forEach(System.out::println);
							System.out.println("\n==============================================================\n");

							break;

						case 12:

							System.out.println("Enter the  Crop Name to calculate the Min Of Y (Yield) :");
							cropname = sc.nextLine();

							float result2 = sum_of_Dev_X_Y.getSum_OfDeviation_X_Y(cropname);

							System.out.println("The Sum of Product of  Deviation of X and Y is :" + result2);

							break;

						case 13:

							System.out.println("Enter the  Crop Name to calculate the Min Of Y (Yield) :");
							cropname = sc.nextLine();
							result2 = sum_of_square_X.sumOfProductOfDeviationOf_X(cropname);

							System.out.println("The Sum of Square of Deviation of X is : " + result2);

							break;

						case 14:

							System.out.println("Enter the  Crop Name to calculate the Min Of Y (Yield) :");
							cropname = sc.nextLine();

							float valueOf_M_temp = getValue_M.get_M_of_Temp(cropname);
							System.out.println("The Value of M :" + valueOf_M_temp);

							break;

						case 15:

							System.out.println("Enter the  Crop Name to calculate the Min Of Y (Yield) :");
							cropname = sc.nextLine();
							float B = getValueOfB.valueOfB_Intercept(cropname);
							System.out.println("The Value of Intersept is : " + B);

							break;

						case 16:

							System.out.println("Enter the crop  name to predict the yield  ");
							cropname = sc.nextLine();

							float meanofTemp = getMinService.getMinOfTemp(cropname);
							float meanOfRainfall = getMinService.getMinofRainfall(cropname);
							float meanOfpH = getMinService.getMinOfpH(cropname);
							float meanOfFertilizer = getMinService.getMinOfFertilizer(cropname);
							float meanOf_Y_Yield = getMin_Of_Y_Service.getMinOfYeild(cropname);

							System.out.println("The Mean of All Entities :");

							System.out.println("The Mean of Temperature for Crop :" + cropname + " is :" + meanofTemp);
							System.out.println("The Mean of Rainfall for Crop :" + cropname + " is :" + meanOfRainfall);

							System.out.println("The Mean of pH for Crop :" + cropname + " is :" + meanOfpH);

							System.out.println(
									"The Mean of Fertilizer for Crop :" + cropname + " is :" + meanOfFertilizer);

							System.out.println("The Mean of Yield  for Crop :" + cropname + " is :" + meanOf_Y_Yield);

							System.out.println("\n==============================================================\n");

							System.out.println("⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓ Deviation of All the Entities : ⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓ ");
							System.out.println("\n==============================================================\n");

							deviationList = deviationService.getDeviationOfTemp(cropname);

							System.out.println("\n==============================================================\n");
							System.out.println("The Deviation of X (Temp) is:");
							deviationList.forEach(deviation -> System.out.println(deviation));
							System.out.println("\n==============================================================\n");

							deviationList = deviationService.getDeviationofRainfall(cropname);

							System.out.println("\n==============================================================\n");
							System.out.println("The Deviation of X (Temp) is:");
							deviationList.forEach(deviation -> System.out.println(deviation));
							System.out.println("\n==============================================================\n");

							deviationList = deviationService.getDeviationofpH(cropname);

							System.out.println("\n==============================================================\n");
							System.out.println("The Deviation of X (Temp) is:");
							deviationList.forEach(deviation -> System.out.println(deviation));
							System.out.println("\n==============================================================\n");

							deviationList = deviationService.getDeviationofFertilizer(cropname);

							System.out.println("\n==============================================================\n");
							System.out.println("The Deviation of X (Temp) is:");
							deviationList.forEach(deviation -> System.out.println(deviation));
							System.out.println("\n==============================================================\n");

							deviationOfYList = deviationOfYService.deviation_Of_Y(cropname);
							System.out.println("The Deviations of Y (Yield) are:");
							System.out.println("\n==============================================================\n");
							deviationOfYList.forEach(System.out::println);
							System.out.println("\n==============================================================\n");

							System.out.println(
									"\n=========================================================================\n");

							System.out.println(
									"⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓ Product of Deviation of  All the Entities with Yield : ⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓ ");
							System.out.println(
									"\n=============================================================================\n");

							prodOfDevXAndYList = prodev_X_Y.product_of_Dev_X_and_Y(cropname);

							System.out.println("The Products of Deviations of Temperature and Yield are:");

							System.out.println("\n==============================================================\n");
							prodOfDevXAndYList.forEach(System.out::println);
							System.out.println("\n==============================================================\n");

							prodOfDevXAndYList = prodev_X_Y.product_of_Dev_X_rainfall_and_Y(cropname);

							System.out.println("The Products of Deviations of Rainfall and Yield are:");

							System.out.println("\n==============================================================\n");
							prodOfDevXAndYList.forEach(System.out::println);
							System.out.println("\n==============================================================\n");

							prodOfDevXAndYList = prodev_X_Y.product_of_Dev_X_pH_and_Y(cropname);

							System.out.println("The Products of Deviations of PH values and Yield are:");

							System.out.println("\n==============================================================\n");
							prodOfDevXAndYList.forEach(System.out::println);
							System.out.println("\n==============================================================\n");

							prodOfDevXAndYList = prodev_X_Y.product_of_Dev_X__fertilizerand_Y(cropname);

							System.out.println("The Products of Deviations of Fertilzer values and Yield are:");

							System.out.println("\n==============================================================\n");
							prodOfDevXAndYList.forEach(System.out::println);
							System.out.println("\n==============================================================\n");

							System.out.println(
									"\n=========================================================================\n");

							System.out.println(
									"⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓ Sum of Product of Deviation of All the Entities : ⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓⇓ ");
							System.out.println(
									"\n=============================================================================\n");

							result2 = sum_of_Dev_X_Y.getSum_OfDeviation_X_Y(cropname);

							System.out.println(
									"The Sum of Product of  Deviation of Temperature  and  Crop Yield is :" + result2);

							result2 = sum_of_Dev_X_Y.getSum_OfDeviation_X_rainfall_Y(cropname);

							System.out.println(
									"The Sum of Product of  Deviation of Rainfall  and  Crop Yield is :" + result2);

							result2 = sum_of_Dev_X_Y.getSum_OfDeviation_X_pH_Y(cropname);

							System.out.println(
									"The Sum of Product of  Deviation of Soil pH  and  Crop Yield is :" + result2);

							result2 = sum_of_Dev_X_Y.getSum_OfDeviation_X_fertilizer_Y(cropname);

							System.out.println(
									"The Sum of Product of  Deviation of Fertilizer  and  Crop Yield is :" + result2);

							System.out.println("Sum of Product of Devaition of ALL The X Entities :");

							result2 = sum_of_square_X.sumOfProductOfDeviationOf_X(cropname);

							System.out.println("The Sum of Square of Deviation of Temp(X) is : " + result2);

							result2 = sum_of_square_X.sumOfProductOfDeviationOf_X_Rainfall(cropname);

							System.out.println("The Sum of Square of Deviation of Rainfall is  : " + result2);

							result2 = sum_of_square_X.sumOfProductOfDeviationOf_X_pH(cropname);

							System.out.println("The Sum of Square of Deviation of Soil pH(X) is : " + result2);

							result2 = sum_of_square_X.sumOfProductOfDeviationOf_X_Fertilizer(cropname);

							System.out.println("The Sum of Square of Deviation of Fertilzer(X) is  : " + result2);

							System.out.println("\n==============================================================\n");

							System.out.println("The Value of M (Slope) : ");
							System.out.println("\n==============================================================\n");

							valueOf_M_temp = getValue_M.get_M_of_Temp(cropname);
							System.out.println("The Value of M :" + valueOf_M_temp);

							float valueOf_M_rainfall = getValue_M.get_M_of_Rainfall(cropname);
							System.out.println("The Value of M :" + valueOf_M_rainfall);

							float valueOf_M_Soil_pH = getValue_M.get_M_of_Soil_pH(cropname);
							System.out.println("The Value of M :" + valueOf_M_Soil_pH);

							float valueOf_M_Fertilizer = getValue_M.get_M_of_Fertilizer(cropname);
							System.out.println("The Value of M :" + valueOf_M_Fertilizer);

							break;
							
						case 17:
							
							int filterChoice;
							
							do
							{
								System.out.println("1 : Filter Using CROP Name  :");
								System.out.println("2 : Filter Using Season : ");
								System.out.println("Enter Your choice :");
								 filterChoice= sc.nextInt();
								switch(filterChoice)
								{
								case 1 :
									sc.nextLine();
									System.out.println("Enter the CropName :");
									cropname =sc.nextLine();
											
									List <CropModel> cropList = filterService.filterbyCropName(cropname);
									
									for(CropModel cmodel:cropList)
									{
										System.out.println(cmodel.getCropname());
									}
									
									break;
									
									
								case 2:
									sc.nextLine();
									System.out.println("Enter the Season Where you want to filter the Crop :");
									String seasonName = sc.nextLine();
									
									List <CropModel> filterCropBySeason = filterService.filterCropBySeason(seasonName);
									
									for(CropModel cmodel:filterCropBySeason)
									{
										System.out.println(cmodel.getCropname());
									}
									break;
								}
							}while(filterChoice!=0);
							break;
							
						}

					} while (choice2 != 0);
				} else {
					log.info("Admin Not Found !!! Thank You ");
				}

				break;
			case 2:

				System.out.println("\n====================================================\n");

				System.out.println("\n====================================================\n");
				int choice3;
				int custchoice;
				do {
					System.out.println(" 1 : Customer LOGIN :");
					System.out.println(" 2 : Customer Already Registered :");
					System.out.println(" 3 : Registration of Customer :");
					System.out.println(" 4 : System Exit :");
					System.out.println(" Enter Your Choice : ");

					choice3 = sc.nextInt();
					switch (choice3) {

					case 1:
						System.out.println("Do you have Previous Account : Yes or No");
						sc.nextLine();
						String message = sc.nextLine();
						if (message.equalsIgnoreCase("yes")) {
							System.out.println("Enter username :");
							username = sc.nextLine();

							System.out.println("Enter password :");
							password = sc.nextLine();

							if (customerService.isCustomerMatch(username, password)) {
								System.out.println("\n====================================================\n");

								System.out.println("Customer Verification Successful ");
								System.out.println("\n====================================================\n");

								do {
									System.out.println("1 : Crop Yield Price using Linear Regression :");
									System.out.println("2 : Your  Information :");
									System.out.println("Enter your Choice :");
									custchoice = sc.nextInt();
									sc.nextLine();
									switch (custchoice) {
									case 1:

										System.out.println("Enter Crop Details to calculate the Yield :");

										System.out.println("Enter the cropName :");
										String cropname = sc.nextLine();
										System.out.println("Enter the  Temperature of your your region :");
										float temperature = sc.nextFloat();
										System.out.println("Enter the Rainfall of your region :");
										float rainfall = sc.nextFloat();
										System.out.println("Enter the soil pH value of Your Farm :");
										float pH = sc.nextFloat();

										System.out.println("Enter the Quantity of Fertilizer in kg : ");
										float fertilizer = sc.nextFloat();
										System.out.println(
												"\n\n    =========================================================================");
										float cropYield = getCropYield.getCropYield(cropname, temperature, rainfall, pH,
												fertilizer);

										System.out.println(
												"          The Crop Yield for the CropName :" + cropname + " is :" + cropYield);
										System.out.println(
												"    =========================================================================");
										
										System.out.println("===================================================================================================================================");
										System.out.printf("| %-20s || %-15s || %-15s || %-15s || %-15s || %-15s |%n", 
										                  "Crop Name", "Temperature", "Rainfall", "Soil pH", "Fertilizer (kg)", "Crop Yield (Tons)");
										System.out.println("===================================================================================================================================");

										// Table Values
										System.out.printf("| %-20s || %-15.2f || %-15.2f || %-15.2f || %-15.2f || %-15.2f |%n", 
										                  cropname, temperature, rainfall, pH, fertilizer, cropYield);
										System.out.println("===================================================================================================================================");
										break;
										
									case 2:
										List<CustomerLoginModel> list=customerService.custDetail();
										System.out.println("===================================================================================================================================");
										for(CustomerLoginModel model:list)
										{
											System.out.println("Customer Id: "+model.getCustomerId()+"\n"+"Customer FName: "+model.getFirstName()+"\n"+"Customer LName: "+model.getLastName()+"\n"+"Email: "+model.getCustomerEmail()+"\n"+"password: "+model.getPassword()+"\n"+
										"customerPhoneNumber: "+model.getCustomerPhoneNumber()+"\n"+"customerAddress:"+model.getCustomerAdress()+"\n"+"registrationDate:"+model.getRegistrationDate());
										}
										System.out.println("===================================================================================================================================");
										break;
									}
								} while (custchoice != 0);

							} else {
								System.out.println("Opps !!! Customer Not Found : ");
							}
						} else {
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

						boolean b = customerService.isRegCust(firstName, lastName, email, password, phoneNumber,address);
						if (b)
						{
							log.info("Customer Registration is Successful :");
						} else {
							log.info("Customer Registration Failed:");
						}
						break;

					}

				} while (choice3 != 0);
			}

		} while (choice != 0);
	}
}
