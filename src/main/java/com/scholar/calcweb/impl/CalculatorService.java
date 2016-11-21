package com.scholar.calcweb.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.scholar.calcweb.CalculatorServiceInterface;
import com.scholar.calcweb.model.Result;

@Path("/")
public class CalculatorService implements CalculatorServiceInterface {

	@Override
	@GET
	@Produces("application/json")
	public Result hello() {
		// TODO Auto-generated method stub
		
		Result result = new Result();
		result.setResult("This is working");
		return result;
	}

}
