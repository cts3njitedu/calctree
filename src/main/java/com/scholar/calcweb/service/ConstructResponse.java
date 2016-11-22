package com.scholar.calcweb.service;

import com.scholar.calcweb.model.Result;

public class ConstructResponse {
	
	
	public static Result getResult(String result){
		
		Result res = new Result();
		
		
		res.setResult(result);
		return res;
		
		
	}

}
