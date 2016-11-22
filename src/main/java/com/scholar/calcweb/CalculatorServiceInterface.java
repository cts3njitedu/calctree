package com.scholar.calcweb;

import javax.ws.rs.core.Response;

import com.scholar.calcweb.model.Expression;


public interface CalculatorServiceInterface {


	public Response getResult(Expression expr);
		
	
}
