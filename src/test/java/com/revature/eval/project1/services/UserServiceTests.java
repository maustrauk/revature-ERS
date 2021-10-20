package com.revature.eval.project1.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.project1.daos.UserDaoImpl;
import com.revature.project1.models.User;
import com.revature.project1.services.UserService;

public class UserServiceTests {
	
	@Mock
	private UserDaoImpl uDao;
	private UserService uServ;
	private User testUser1;
	private User insertUser;
	private User testUser2;
	private User updateUser;
	private User testUser3;
	private List<User> allUsers;
	private List<User> emptyList;

	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		uServ = new UserService(uDao);
		
		testUser1 = new User(1, "testUsername1", "testPassword", "testFirstName", "testLastName", "test@mail", 1);
		insertUser = new User("insertTest", "insertTest", "insertTest", "insertTest", "test@mail", 1);
		testUser2 = new User(2,"insertTest", "insertTest", "insertTest", "insertTest", "test@mail", 1);
		updateUser = new User(1, "test", "testPassword", "testFirstName", "testLastName", "test@mail", 1);
		testUser3 = new User(3,"insertTest", "insertTest", "insertTest", "insertTest", "test@mail", 1);
		
		allUsers = new ArrayList<User>();
		allUsers.add(testUser1);
		allUsers.add(testUser2);
		
		emptyList = new ArrayList<User>();
		
		when(uDao.getByName("testUsername1")).thenReturn(testUser1);
		when(uDao.getById(1)).thenReturn(testUser1);
		when(uDao.insert(insertUser)).thenReturn(testUser2);
		when(uDao.getByName(insertUser.getUserName())).thenReturn(null);
		when(uDao.update(updateUser)).thenReturn(updateUser);
		when(uDao.getById(testUser3.getUserId())).thenReturn(null);
		when(uDao.getAll()).thenReturn(allUsers);
		when(uDao.getUserListByUserRoleId(1)).thenReturn(allUsers);
		when(uDao.getUserListByUserRoleId(2)).thenReturn(emptyList);
	}
	
	//Tests
	
	@Test
	public void testGetUserByNameSuccess() {
		assertEquals(uServ.getUserByName("testUsername1"), testUser1);
	}
	
	@Test
	public void testGetUserByNameUnsuccess() {
		assertThrows(NullPointerException.class, () -> uServ.getUserByName("testUsername"));
	}
	
	@Test
	public void testGetUserByIdSuccess() {
		assertEquals(uServ.getUserById(1), testUser1);
	}
	
	@Test
	public void testGetUserByIdUnsuccess() {
		assertThrows(NullPointerException.class, () -> uServ.getUserById(0));
	}
	
	@Test
	public void testInsertUserSuccess() {
		assertEquals(uServ.insertUser(insertUser), testUser2);
	}
	
	@Test
	public void testInsertUserUnsuccess() {
		assertEquals(uServ.insertUser(testUser1), null);
	}
	
	@Test
	public void testUpdateUserSuccess() {
		assertEquals(uServ.updateUser(updateUser), updateUser);
	}
	
	@Test
	public void testUpdateUserUnsuccess() {
		assertEquals(uServ.updateUser(testUser3), null);
	}
	
	@Test
	public void testGetAllUsersSuccess() {
		assertEquals(uServ.getAllUsers(), allUsers);
	}
	
	@Test
	public void testGetAllUsersByRoleIdSuccess() {
		assertEquals(uServ.getAllByRoleId(1), allUsers);
	}
	
	@Test
	public void testGetAllUsersByRoleIdUnsuccess() {
		assertEquals(uServ.getAllByRoleId(2), emptyList);
	}
	
	@Test
	public void testUserVerifyLoginCredentialsSuccess() {
		assertEquals(uServ.verifyLoginCredentials("testUsername1", "testPassword"), testUser1);
	}
	
	@Test
	public void testUserVerifyLoginCredentialsUnsuccess() {
		assertEquals(uServ.verifyLoginCredentials("testUsername1", "word"), null);
	}
}
