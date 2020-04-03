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


public class AddTariffPlanSteps {
	

	
	@Given("User click on add tariff button")
	public void user_click_on_add_tariff_button() throws Throwable {
		handleFrame();
		
		Hook.driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	    
	}

	@Then("User should be received congratulation message")
	public void user_should_be_received_congratulation_message() throws Throwable {
		handleFrame();
		
		Assert.assertEquals(Hook.driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).getText(), "Congratulation you add Tariff Plan");
		
		
	    
	}
	
	@When("User enters tariff plan fields")
	public void user_enters_tariff_plan_fields() throws Throwable {
		
		handleFrame();
		
		Hook.driver.findElement(By.name("rental")).sendKeys("400");
		Hook.driver.findElement(By.name("local_minutes")).sendKeys("300");
		Hook.driver.findElement(By.name("inter_minutes")).sendKeys("200");
		Hook.driver.findElement(By.name("sms_pack")).sendKeys("100");
		Hook.driver.findElement(By.name("minutes_charges")).sendKeys("3");
		Hook.driver.findElement(By.name("inter_charges")).sendKeys("2");
		Hook.driver.findElement(By.name("sms_charges")).sendKeys("1");
	   
		
	}
	
	@When("User enters tariff plan fields with two dim list")
	public void user_enters_tariff_plan_fields_with_two_dim_list(DataTable custData) {

		List<List<String>> data = custData.asLists(String.class);
		
		Hook.driver.findElement(By.name("rental")).sendKeys(data.get(2).get(0));
		Hook.driver.findElement(By.name("local_minutes")).sendKeys(data.get(2).get(1));
		Hook.driver.findElement(By.name("inter_minutes")).sendKeys(data.get(3).get(2));
		Hook.driver.findElement(By.name("sms_pack")).sendKeys(data.get(2).get(3));
		Hook.driver.findElement(By.name("minutes_charges")).sendKeys(data.get(2).get(4));
		Hook.driver.findElement(By.name("inter_charges")).sendKeys(data.get(2).get(5));
		Hook.driver.findElement(By.name("sms_charges")).sendKeys(data.get(2).get(6));
		
		
	}
	
	@When("User enters tariff plan fields with two dim map")
	public void user_enters_tariff_plan_fields_with_two_dim_map(DataTable custData) {

		List<Map<String, String>> data = custData.asMaps(String.class,String.class);
		
		Hook.driver.findElement(By.name("rental")).sendKeys(data.get(3).get("MR"));
		Hook.driver.findElement(By.name("local_minutes")).sendKeys(data.get(2).get("FLM"));
		Hook.driver.findElement(By.name("inter_minutes")).sendKeys(data.get(3).get("FIM"));
		Hook.driver.findElement(By.name("sms_pack")).sendKeys(data.get(2).get("FSP"));
		Hook.driver.findElement(By.name("minutes_charges")).sendKeys(data.get(2).get("LMC"));
		Hook.driver.findElement(By.name("inter_charges")).sendKeys(data.get(2).get("IMC"));
		Hook.driver.findElement(By.name("sms_charges")).sendKeys(data.get(2).get("SMC"));
		
		
	}
	
	@When("User enters tariff plan fields {string},{string},{string},{string},{string},{string},{string}")
	public void user_enters_tariff_plan_fields(String string, String string2, String string3, String FSP, String string5, String string6, String string7) {
	    
		Hook.driver.findElement(By.name("rental")).sendKeys(string);
		Hook.driver.findElement(By.name("local_minutes")).sendKeys(string2);
		Hook.driver.findElement(By.name("inter_minutes")).sendKeys(string3);
		Hook.driver.findElement(By.name("sms_pack")).sendKeys(FSP);
		Hook.driver.findElement(By.name("minutes_charges")).sendKeys(string5);
		Hook.driver.findElement(By.name("inter_charges")).sendKeys(string6);
		Hook.driver.findElement(By.name("sms_charges")).sendKeys(string7);
		
		
	}

	@When("User click on tariff submit button")
	public void user_click_on_tariff_submit_button() throws Throwable {
		
		
	    
		Hook.driver.findElement(By.xpath("//input[@value='submit']")).click();
		
	}
	
	public void handleFrame() throws Throwable {
		 Thread.sleep(3000);
		 Hook.driver.switchTo().frame(Hook.driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
		 Hook.driver.findElement(By.id("closeBtn")).click();
		 Hook.driver.switchTo().parentFrame();

	}


}
