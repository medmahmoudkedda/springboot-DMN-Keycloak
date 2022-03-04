package com.smart.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNDecisionResult;
import org.kie.dmn.api.core.DMNResult;
import org.kie.internal.command.CommandFactory;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.DMNServicesClient;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DroolsDMNConfig {

	@Value("${kie.dmnInsurancePremium.containerId}")
	private String dmnInsurancePremiumcontainerId;
	
	@Value("${kie.dmnBMI.containerId}")
	private String dmnBMIcontainerId;
	
	@Value("${kie.dmnTraffic.containerId}")
	private String dmnTrafficcontainerId;

	@Value("${kie.server.user}")
	private String user;

	@Value("${kie.server.pwd}")
	private String password;

	@Value("${kie.server.url}")
	private String url;
	
	@Value("${kie.dmnInsurancePremium.modelNamespace}")
	private String InsurancePremiummodelNamespace;

	@Value("${kie.dmnInsurancePremium.modelName}")
	private String InsurancePremiummodelName;
	
	@Value("${kie.dmnBMI.modelNamespace}")
	private String BMImodelNamespace;

	@Value("${kie.dmnBMI.modelName}")
	private String BMImodelName;
	
	
	@Value("${kie.dmnTraffic.modelNamespace}")
	private String TrafficmodelNamespace;

	@Value("${kie.dmnTraffic.modelName}")
	private String TrafficmodelName;
	

	public DMNServicesClient dmnClientConfig() {
		
		KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(url, user, password, 60000);
		config.setMarshallingFormat(MarshallingFormat.JSON);
		
		KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(config);
		
		DMNServicesClient dmnClient = kieServicesClient.getServicesClient(DMNServicesClient.class );
		
		return dmnClient;
		
	}

	public Insuranc_Premium consultdmnInsurancePremium(Insuranc_Premium premium) {

			DMNContext dmnContext = dmnClientConfig().newContext(); 
			dmnContext.set("Age", premium.getAge());
			dmnContext.set("Had previous incidents", premium.isHasPreIncident());
			
			ServiceResponse<DMNResult> serverResp = dmnClientConfig().evaluateAll(dmnInsurancePremiumcontainerId,InsurancePremiummodelNamespace,InsurancePremiummodelName,dmnContext);
			DMNResult dmnResulte = serverResp.getResult();   
			
			for (DMNDecisionResult dr : dmnResulte.getDecisionResults()) {
				System.out.println("Insurance Premium, Age = "+premium.getAge()+", Has previous incident = "+ premium.isHasPreIncident()+", Decision name = '" + dr.getDecisionName() + "', Result = " + dr.getResult());
				premium.setPremium(Double.parseDouble(dr.getResult() + ""));
			}
			
			return premium;

	}


	public BMI consultdmnbmi(BMI bmi) {
		
		DMNContext dmnContext = dmnClientConfig().newContext(); 
		dmnContext.set("Height", bmi.getHeight());
		dmnContext.set("Weight", bmi.getWeight());
		
		ServiceResponse<DMNResult> serverResp = dmnClientConfig().evaluateAll(dmnBMIcontainerId,BMImodelNamespace,BMImodelName,dmnContext);
		DMNResult dmnResulte = serverResp.getResult();   
		
		for (DMNDecisionResult dr : dmnResulte.getDecisionResults()) {
			System.out.println("BMI, Height = "+bmi.getHeight()+"cm, Weight = "+ bmi.getWeight() +"kg, Decision name = '" + dr.getDecisionName() + "', Result = " + dr.getResult());
			bmi.setLevel(dr.getResult() + "");
		}
		
		return bmi;
	}

	public Traffic_Violation consultdmnTrafficViolation(Traffic_Violation traffic_Violation) {
		
		DMNContext dmnContext = dmnClientConfig().newContext(); 
		dmnContext.set("Driver", traffic_Violation.getDriver());
		dmnContext.set("Violation", traffic_Violation.getViolation());
		
		ServiceResponse<DMNResult> serverResp = dmnClientConfig().evaluateAll(dmnTrafficcontainerId,TrafficmodelNamespace,TrafficmodelName,dmnContext);
		DMNResult dmnResulte = serverResp.getResult();   
		
		for (DMNDecisionResult dr : dmnResulte.getDecisionResults()) {
			System.out.println("Traffic violation, Driver = "+traffic_Violation.getDriver()+", Violation = "+ traffic_Violation.getViolation() +", Decision name = '" + dr.getDecisionName() + "', Result = " + dr.getResult());
			
			if(dr.getResult().equals("Yes")) {
				traffic_Violation.getDriver().setSuspended(true);
			}
		}
		return traffic_Violation;
	}

}
