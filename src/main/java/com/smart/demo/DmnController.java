package com.smart.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DmnController {
	@Autowired
	private DroolsDMNConfig drdmnconfig;
	
	@GetMapping("/bmi")
	public BMI testdmn(@RequestBody BMI bmi) {
		BMI dmnBMI = drdmnconfig.consultdmnbmi(bmi);
		return dmnBMI;
	}
	
	@GetMapping("/insurancepremium")
	public Insuranc_Premium insurancePremium(@ModelAttribute Insuranc_Premium premium) {
		Insuranc_Premium dmnPremium = drdmnconfig.consultdmnInsurancePremium(premium);
		return dmnPremium;
	}
	
	@GetMapping("/trafficviolation")
	public Traffic_Violation traffic_violation(@RequestBody Traffic_Violation traffic_Violation) {
		Traffic_Violation dmnTraffic_Violation = drdmnconfig.consultdmnTrafficViolation(traffic_Violation);
		return dmnTraffic_Violation;
	}
	
	
	
	
	
	
	

}
