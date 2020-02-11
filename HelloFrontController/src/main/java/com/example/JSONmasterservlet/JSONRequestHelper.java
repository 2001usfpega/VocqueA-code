package com.example.JSONmasterservlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.SuperVillain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/HelloFrontController/dannyboy.json":
			DannyBoyController.dannyFinder(req,res);
			break;
		case "/HelloFrontController/billy.json":
			BillyController.billyFinder(req, res);
			break;
		default: 
			System.out.println("in default case");
			SuperVillain nullVill = new SuperVillain(null, null, 0);
			res.getWriter().write(new ObjectMapper().writeValueAsString(nullVill));
		}
	}
}
