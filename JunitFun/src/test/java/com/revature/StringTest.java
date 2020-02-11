package com.revature;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.example.whatever.AccountTab;

class StringTest {
	
	@BeforeAll
	static void beforeAllofem() {
		System.out.println("Before ALL");
	}
	
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("We just ran: " + info.getDisplayName());
	}
	@DisplayName("Length Check")

	@Test
	void meh() {
		AccountTab isa = new AccountTab();
		assertTrue(isa.talktome(true));
	}

}
