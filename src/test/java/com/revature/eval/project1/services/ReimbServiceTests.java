package com.revature.eval.project1.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.project1.daos.ReimbursementDaoImpl;
import com.revature.project1.services.ReimbursementService;

public class ReimbServiceTests {
	@Mock
	private ReimbursementDaoImpl rDao;
	private ReimbursementService rServ;
	private String testPath;
	private byte[] testByteA;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		rServ = new ReimbursementService(rDao);
		testPath = "images.jpg";
		testByteA = new byte[] {};
	}
	
	
	//Tests
	
	@Test
	public void testReimbGetFileStreamSuccess() {
		assertTrue(rServ.getFileStream(testPath).getClass().getSimpleName() == testByteA.getClass().getSimpleName());
	}
	
	@Test
	public void testReimbGetFileStreamUnsuccess() {
		assertEquals(rServ.getFileStream("some stuf"), null);
	}

}
