package com.revature.eval.project1.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.project1.models.Role;
import com.revature.project1.services.RoleService;
import com.revature.project1.daos.RoleDaoImpl;

public class RoleServiceTest {
	@Mock
	private RoleDaoImpl rDao;
	private RoleService rServ;
	private Role testRole;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		rServ = new RoleService(rDao);
		testRole = new Role(1,"EMPLOYEE");
		when(rDao.getByName("EMPLOYEE")).thenReturn(testRole);
		when(rDao.getById(1)).thenReturn(testRole);
	}
	
	@Test
	public void testGetRoleByNameSuccess() {
		assertEquals(rServ.getRoleByName("EMPLOYEE"), testRole);
	}
}
