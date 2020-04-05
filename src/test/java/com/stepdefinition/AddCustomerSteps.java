package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.objectrepository.AddCustomerPage;
import com.objectrepository.HomePage;
import com.resources.FunctionalLibrary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomerSteps extends FunctionalLibrary{
	  
	
	
    FunctionalLibrary f = new FunctionalLibrary();
    HomePage hp = new HomePage();
    AddCustomerPage cp = new AddCustomerPage();


@Given("User click on add customer button")
public void user_click_on_add_customer_button() throws Throwable {
	try{
	handleFrame();
	}catch(Exception e){
		
	}

       f.button(hp.getAddCustomerBtn());
    
}

@When("User enters all the fields")
public void user_enters_all_the_fields() throws Throwable {
	
	try{
	handleFrame();
	}catch(Exception e){
		
	}
	
    f.button(cp.getDoneBtn());
    f.insertText(cp.getFname(), "java");
    f.insertText(cp.getLname(), "selenium");
    f.insertText(cp.getEmail(), "java@gmail.com");
    f.insertText(cp.getAddress(), "thoraipakkam");
    f.insertText(cp.getPhno(), "7265237231");
	
    
}

@When("User enters all the fields with one dimensional")
public void user_enters_all_the_fields_with_one_dimensional(DataTable customerData) throws Throwable {
    
	List<String> data = customerData.asList(String.class);
	try{
		handleFrame();
		}catch(Exception e){
			
		}
	
	 f.button(cp.getDoneBtn());
	   f.insertText(cp.getFname(), data.get(0));
	    f.insertText(cp.getLname(), data.get(1));
	    f.insertText(cp.getEmail(), data.get(2));
	    f.insertText(cp.getAddress(), data.get(3));
	    f.insertText(cp.getPhno(), data.get(4));	
		
/*		driver.findElement(By.id("fname")).sendKeys(data.get(0));
		driver.findElement(By.id("lname")).sendKeys(data.get(1));
		driver.findElement(By.id("email")).sendKeys(data.get(2));
		driver.findElement(By.name("addr")).sendKeys(data.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(data.get(4));*/
	
}

@When("User enters all the fields with one dimensional map")
public void user_enters_all_the_fields_with_one_dimensional_map(DataTable customerData) throws Throwable {

	Map<String, String> data = customerData.asMap(String.class, String.class);
	
	try{
		handleFrame();
		}catch(Exception e){
			
		}
		
		driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		driver.findElement(By.id("fname")).sendKeys(data.get("Fname"));
		driver.findElement(By.id("lname")).sendKeys(data.get("Lname"));
		driver.findElement(By.id("email")).sendKeys(data.get("Email"));
		driver.findElement(By.name("addr")).sendKeys(data.get("Address"));
		driver.findElement(By.id("telephoneno")).sendKeys(data.get("phno"));
	
}

@When("User click on submit button")
public void user_click_on_submit_button() {
	
	f.button(cp.getSubmitBtn());
    
}

@Then("User should be displayed customer ID is generated or not")
public void user_should_be_displayed_customer_ID_is_generated_or_not() throws Throwable {
	
	try{
	handleFrame();
	}catch(Exception e){
		
	}
	
	Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
    
}

public void handleFrame() throws Throwable {
	 Thread.sleep(3000);
	 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
	 driver.findElement(By.id("closeBtn")).click();
	 driver.switchTo().parentFrame();

}



}
