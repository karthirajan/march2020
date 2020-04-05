package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.resources.FunctionalLibrary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;


public class AddTariffPlanSteps extends FunctionalLibrary{
	

	
	@Given("User click on add tariff button")
	public void user_click_on_add_tariff_button() throws Throwable {
		handleFrame();
		
		driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	    
	}

	@Then("User should be received congratulation message")
	public void user_should_be_received_congratulation_message() throws Throwable {
		handleFrame();
		
		Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).getText(), "Congratulation you add Tariff Plan");
		
		
	    
	}
	
	@When("User enters tariff plan fields")
	public void user_enters_tariff_plan_fields() throws Throwable {
		
		handleFrame();
		
		driver.findElement(By.name("rental")).sendKeys("400");
		driver.findElement(By.name("local_minutes")).sendKeys("300");
		driver.findElement(By.name("inter_minutes")).sendKeys("200");
		driver.findElement(By.name("sms_pack")).sendKeys("100");
		driver.findElement(By.name("minutes_charges")).sendKeys("3");
		driver.findElement(By.name("inter_charges")).sendKeys("2");
		driver.findElement(By.name("sms_charges")).sendKeys("1");
	   
		
	}
	
	@When("User enters tariff plan fields with two dim list")
	public void user_enters_tariff_plan_fields_with_two_dim_list(DataTable custData) {

		List<List<String>> data = custData.asLists(String.class);
		
		driver.findElement(By.name("rental")).sendKeys(data.get(2).get(0));
		driver.findElement(By.name("local_minutes")).sendKeys(data.get(2).get(1));
		driver.findElement(By.name("inter_minutes")).sendKeys(data.get(3).get(2));
		driver.findElement(By.name("sms_pack")).sendKeys(data.get(2).get(3));
		driver.findElement(By.name("minutes_charges")).sendKeys(data.get(2).get(4));
		driver.findElement(By.name("inter_charges")).sendKeys(data.get(2).get(5));
		driver.findElement(By.name("sms_charges")).sendKeys(data.get(2).get(6));
		
		
	}
	
	@When("User enters tariff plan fields with two dim map")
	public void user_enters_tariff_plan_fields_with_two_dim_map(DataTable custData) {

		List<Map<String, String>> data = custData.asMaps(String.class,String.class);
		
		driver.findElement(By.name("rental")).sendKeys(data.get(3).get("MR"));
		driver.findElement(By.name("local_minutes")).sendKeys(data.get(2).get("FLM"));
		driver.findElement(By.name("inter_minutes")).sendKeys(data.get(3).get("FIM"));
		driver.findElement(By.name("sms_pack")).sendKeys(data.get(2).get("FSP"));
		driver.findElement(By.name("minutes_charges")).sendKeys(data.get(2).get("LMC"));
		driver.findElement(By.name("inter_charges")).sendKeys(data.get(2).get("IMC"));
		driver.findElement(By.name("sms_charges")).sendKeys(data.get(2).get("SMC"));
		
		
	}
	
	@When("User enters tariff plan fields {string},{string},{string},{string},{string},{string},{string}")
	public void user_enters_tariff_plan_fields(String string, String string2, String string3, String FSP, String string5, String string6, String string7) {
	    
		driver.findElement(By.name("rental")).sendKeys(string);
		driver.findElement(By.name("local_minutes")).sendKeys(string2);
		driver.findElement(By.name("inter_minutes")).sendKeys(string3);
		driver.findElement(By.name("sms_pack")).sendKeys(FSP);
		driver.findElement(By.name("minutes_charges")).sendKeys(string5);
		driver.findElement(By.name("inter_charges")).sendKeys(string6);
		driver.findElement(By.name("sms_charges")).sendKeys(string7);
		
		
	}

	@When("User click on tariff submit button")
	public void user_click_on_tariff_submit_button() throws Throwable {
		
		
	    
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		
	}
	
	public void handleFrame() throws Throwable {
		 Thread.sleep(3000);
		 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
		 driver.findElement(By.id("closeBtn")).click();
		 driver.switchTo().parentFrame();

	}


}
