package com.example.JSONmasterservlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.SuperVillain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BillyController {
	public static void billyFinder(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		SuperVillain billy = new SuperVillain("Billy", "Imprisonment", 225_000);
		
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(billy));
	}
}