package com.smart.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keycloak.adapters.AdapterDeploymentContext;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.spi.HttpFacade;
import org.keycloak.adapters.springsecurity.facade.SimpleHttpFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.models.BMI;
import com.smart.models.Insuranc_Premium;
import com.smart.models.Traffic_Violation;
import com.smart.services.DroolsDMNConfig;

@Controller
public class DmnController {
	@Autowired
	private DroolsDMNConfig drdmnconfig;
	
	@Autowired
    private  AdapterDeploymentContext adapterDeploymentContext;
	
	@GetMapping("/bmi")
	public BMI testdmn(@RequestBody BMI bmi) {
		System.out.println("Before DMN " + bmi);
		BMI dmnBMI = drdmnconfig.consultdmnbmi(bmi);
		System.out.println("After DMN " + bmi);
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
	
	
	@GetMapping(path = "/")
	public String index() {
	    return "This my public RSA key 987654321";
	}
	    
	@GetMapping(path = "/secret")
	public String customers() {
	    return "This my private RSA key 789456231";
	}
	
	@GetMapping("/changePassword")
    public String changePassword(
            RedirectAttributes attributes,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException {
        HttpFacade facade = new SimpleHttpFacade(request, response);
        KeycloakDeployment deployment  =   adapterDeploymentContext.resolveDeployment(facade);
        attributes.addAttribute("referrer", deployment.getResourceName());
        attributes.addAttribute("referrer_uri", request.getHeader("referer"));
        return "redirect:"+ deployment.getAccountUrl();
    }
	
	
}
