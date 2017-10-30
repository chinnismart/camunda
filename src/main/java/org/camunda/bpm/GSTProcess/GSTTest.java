package org.camunda.bpm.GSTProcess;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

@ProcessApplication
public class GSTTest extends ServletProcessApplication {
    @PostDeploy
 	public void checkGSTDecision(ProcessEngine pe) {
		DecisionService mydecisions = pe.getDecisionService();
		System.out.println("Enter in to service" +mydecisions);
		VariableMap  myvariables =Variables.createVariables().putValue("goodsType", "Cinema tickets");
	 DmnDecisionTableResult result	= mydecisions.evaluateDecisionTableByKey("gst", myvariables);
	 double gstRates = result.getSingleEntry();
	 System.out.println(gstRates + "");

	}

}