package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomerSteps {
	  
	
	



@Given("User click on add customer button")
public void user_click_on_add_customer_button() throws Throwable {
	try{
	handleFrame();
	}catch(Exception e){
		
	}
	Hook.driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
    
}

@When("User enters all the fields")
public void user_enters_all_the_fields() throws Throwable {
	
	try{
	handleFrame();
	}catch(Exception e){
		
	}
	
	Hook.driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
	Hook.driver.findElement(By.id("fname")).sendKeys("karthi");
	Hook.driver.findElement(By.id("lname")).sendKeys("rajan");
	Hook.driver.findElement(By.id("email")).sendKeys("karthi@gmail.com");
	Hook.driver.findElement(By.name("addr")).sendKeys("chennai");
	Hook.driver.findElement(By.id("telephoneno")).sendKeys("123445354");
	
    
}

@When("User enters all the fields with one dimensional")
public void user_enters_all_the_fields_with_one_dimensional(DataTable customerData) throws Throwable {
    
	List<String> data = customerData.asList(String.class);
	try{
		handleFrame();
		}catch(Exception e){
			
		}
		
		Hook.driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		Hook.driver.findElement(By.id("fname")).sendKeys(data.get(0));
		Hook.driver.findElement(By.id("lname")).sendKeys(data.get(1));
		Hook.driver.findElement(By.id("email")).sendKeys(data.get(2));
		Hook.driver.findElement(By.name("addr")).sendKeys(data.get(3));
		Hook.driver.findElement(By.id("telephoneno")).sendKeys(data.get(4));
	
}

@When("User enters all the fields with one dimensional map")
public void user_enters_all_the_fields_with_one_dimensional_map(DataTable customerData) throws Throwable {

	Map<String, String> data = customerData.asMap(String.class, String.class);
	
	try{
		handleFrame();
		}catch(Exception e){
			
		}
		
		Hook.driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		Hook.driver.findElement(By.id("fname")).sendKeys(data.get("Fname"));
		Hook.driver.findElement(By.id("lname")).sendKeys(data.get("Lname"));
		Hook.driver.findElement(By.id("email")).sendKeys(data.get("Email"));
		Hook.driver.findElement(By.name("addr")).sendKeys(data.get("Address"));
		Hook.driver.findElement(By.id("telephoneno")).sendKeys(data.get("phno"));
	
}

@When("User click on submit button")
public void user_click_on_submit_button() {
	
	Hook.driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
    
}

@Then("User should be displayed customer ID is generated or not")
public void user_should_be_displayed_customer_ID_is_generated_or_not() throws Throwable {
	
	try{
	handleFrame();
	}catch(Exception e){
		
	}
	
	Assert.assertTrue(Hook.driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
    
}

public void handleFrame() throws Throwable {
	 Thread.sleep(3000);
	 Hook.driver.switchTo().frame(Hook.driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
	 Hook.driver.findElement(By.id("closeBtn")).click();
	 Hook.driver.switchTo().parentFrame();

}



}
