Feature: Login

Scenario: Successful Login with Valid Credentials
	
		Given User Launch Chrome Browser
		When User opens URL "https://admin-demo.nopcommerce.com/login"
		And User enter emails as "admin@yourstore.com" and password as "admin"
		And click on Login button
		Then Page title should be "Dashboard / nopCommerce administration"
		When User click on log out button
		Then Page title should be "Your store. Login"
		And close browser
		
		

