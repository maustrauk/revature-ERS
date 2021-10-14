package com.revature.eval.project1.services;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.revature.project1.models.Role;

public class RoleServiceTest {
//	@Mock
//	private RoleDaoImpl rDao;
//	private RoleService rServ;
//	private Role testRole;
//	private List<Role> allRoles;
//	
//	@SuppressWarnings("deprecation")
//	@BeforeEach
//	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//		rServ = new RoleService(rDao);
//		testRole = new Role(1,"EMPLOYEE");
//		allRoles = new ArrayList<Role>();
//		allRoles.add(testRole);
//		
//		when(rDao.getByName("EMPLOYEE")).thenReturn(testRole);
//		when(rDao.getById(1)).thenReturn(testRole);
//		when(rDao.getAll()).thenReturn(allRoles);
//	}
//	
//	@Test
//	public void testGetRoleByNameSuccess() {
//		assertEquals(rServ.getRoleByName("EMPLOYEE"), testRole);
//	}
//	
//	@Test
//	public void  testGetRoleByIdSuccess() {
//		assertEquals(rServ.getRoleById(1), testRole);
//	}
//	
//	@Test
//	public void testGetAllRolesSuccess() {
//		assertEquals(rServ.getAllRoles(), allRoles);
//	}
//	
//	@Test
//	public void testGetRoleByIdUnsuccess() {
//		assertThrows(NullPointerException.class, () -> rServ.getRoleById(10));
//	}
//	@Test
//	public void testGetRoleByNameUnsuccess() {
//		assertThrows(NullPointerException.class, () -> rServ.getRoleByName("Test"));
//	}
}
