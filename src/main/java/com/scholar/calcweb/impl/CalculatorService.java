package com.scholar.calcweb.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.scholar.calcweb.CalculatorServiceInterface;
import com.scholar.calcweb.model.Expression;
import com.scholar.calcweb.service.Calculator;
import com.scholar.calcweb.service.RpnCalculator;

@Path("/")
public class CalculatorService implements CalculatorServiceInterface {

	@Override
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response getResult(Expression expr) {
		// TODO Auto-generated method stub
		
		RpnCalculator calculator = new RpnCalculator(expr.getExpression());
	
		
		return Response.status(200).entity(calculator.execute()).build();
	}

}
