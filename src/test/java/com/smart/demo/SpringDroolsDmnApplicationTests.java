package com.smart.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smart.models.BMI;
import com.smart.models.Driver;
import com.smart.models.Insuranc_Premium;
import com.smart.models.Traffic_Violation;
import com.smart.models.Violation;
import com.smart.services.DroolsDMNConfig;

@SpringBootTest
class SpringDroolsDmnApplicationTests {
	
	@Autowired
	private DroolsDMNConfig drdmnconfig;
	
	@Test
	void bmi_test() {
		BMI bmi = new BMI(172,30);
		System.out.println("BMI From test before DMN " + bmi);
		drdmnconfig.consultdmnbmi(bmi);
		System.out.println("BMI From test after DMN " + bmi);
		assertTrue(bmi.getLevel().equalsIgnoreCase("underweight"));
	}
	
	
	@Test
	void traffic_test() {
		Traffic_Violation traffic = new Traffic_Violation(new Violation(100,80,"speed"), new Driver(20, 18) );
		System.out.println("Traffic From test before DMN " + traffic);
		drdmnconfig.consultdmnTrafficViolation(traffic);
		System.out.println("Traffic From test after DMN " + traffic);
		assertTrue(traffic.getDriver().isSuspended());
	}
	
	
	@Test
	void insurance_test() {
		Insuranc_Premium insuranc = new Insuranc_Premium(false, 45);
		System.out.println("Insuranc From test before DMN " + insuranc);
		drdmnconfig.consultdmnInsurancePremium(insuranc);
		System.out.println("Insuranc From test after DMN " + insuranc);
		assertTrue(insuranc.getPremium() == 1000);
	}
	

}
