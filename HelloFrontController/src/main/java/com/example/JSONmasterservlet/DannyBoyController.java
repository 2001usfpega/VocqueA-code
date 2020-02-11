package com.example.JSONmasterservlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.SuperVillain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DannyBoyController {
	public static void dannyFinder(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		SuperVillain danny = new SuperVillain("Danny Boy", "Technopath", 250_000);
		
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(danny));
	}
}
