# GroceryStoreApplication
The primary aim of GroceryStoreApplication is to evaluate the type of relation the user has maintained with the Store and based on that caculate the discount which can be given to the user. 
The process of evaluation is done by following below criterias:

    1. If the user is an employee of the store, he gets a 30% discount
    2. If the user is an affiliate of the store, he gets a 10% discount
    3. If the user has been a customer for over 2 years, he gets a 5% discount.
    4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
    as a discount).
    
Apart from above criterias, we have two rules as well, which are given below:

    1. The percentage based discounts do not apply on groceries.
    2. A user can get only one of the percentage based discounts on a bill.
    
 
## Getting Started  
  
### Build all components and import to the IDE: 
  
  
    1. Clone/Download this repository in one of your directory in your machine.
    2. Import the project in your IDE using maven import.  
  
###  Running Micro Service  .
  
  
	1.	Move to the ${PROJECT_CHECKOUT_FOLDER}\GroceryStoreApplication\target .  
  
	2. Execute below command: ```java -jar GroceryStoreApplication-0.0.1-SNAPSHOT```  
	Note:- The version of the snapshot may vary.  
  
## Prerequisites  
  
	* Software:- GroceryStoreApplication  
 	* Version: 0.0.1  
	* JDK 1.8  
	* Maven 3.x  
	* Spring framework.  
	* Git  
	* For Static Code Analysis, we use Sonar for generating reports  
	* Jacoco is used for code coverage.  
  
  
## Running Sonar Report  
  
	  1. Import project on IDE (not mandatory) / Build the project locally.  
    2. Start Sonar Qube Server
    3. Run 'mvn clean verify sonar:sonar' command
    4. Look in target/reports for jacoco reports
    5. Check Sonar Qube dashboard for Overall Summary (default localhost:9000)
    
    *** Attached PDF of Latest Sonar Qube Summary inside SonarReports Folder ***
 
