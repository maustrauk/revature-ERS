package com.revature.project1.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.LogHelper;
import com.revature.project1.models.User;

public class UserDaoImpl implements UserDao{
	private DBConnection dbCon;
	private final LogHelper log = new LogHelper();
	
	public UserDaoImpl() {
	}

	public UserDaoImpl(DBConnection dbCon) {
		this.dbCon = dbCon;
	}

	@Override
	public List<User> getAll() {
		List<User> usersList = new ArrayList<User>();
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_users";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) 
			{
				usersList.add(new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getInt(7)));
			}
		} catch (SQLException e) {
			log.callFatalLogger(e);
			return null;
			}
		return usersList;
	}

	@Override
	public User getByName(String name) {
		User user = new User();
		
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_users u where u.ers_username = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				user = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getInt(7));
			}
		} catch (SQLException e) {
			log.callFatalLogger(e);
			return null;
		}
		return user;
	}

	@Override
	public User getById(int id) {
		User user = new User();
		
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_users u where u.ers_users_id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				user = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getInt(7));
			}
		} catch (SQLException e) {
			log.callFatalLogger(e);
			return null;
		}
		return user;
	}

	@Override
	public User update(User entity) {
		User newUser = new User();
		
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "{? = call update_user(?,?,?,?,?,?,?)}";
			CallableStatement statement = con.prepareCall(sql);
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.setInt(2, entity.getUserId());
			statement.setString(3, entity.getUserName());
			statement.setString(4, entity.getUserPassword());
			statement.setString(5, entity.getUserFirstName());
			statement.setString(6, entity.getUserLastName());
			statement.setString(7, entity.getUserEmail());
			statement.setInt(8, entity.getUserRoleId());
			statement.execute();
			
			System.out.println(statement.getString(1));
			newUser = getByName(entity.getUserName());
			
		} catch (SQLException e) {
			log.callFatalLogger(e);
			return null;
		}
		
		
		return newUser;
	}

	@Override
	public User insert(User entity) {
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "{? = call insert_user(?,?,?,?,?,?)}";
			CallableStatement statement = con.prepareCall(sql);
			statement.registerOutParameter(1, Types.INTEGER);
			statement.setString(2, entity.getUserName());
			statement.setString(3, entity.getUserPassword());
			statement.setString(4, entity.getUserFirstName());
			statement.setString(5, entity.getUserLastName());
			statement.setString(6, entity.getUserEmail());
			statement.setInt(7, entity.getUserRoleId());
			statement.execute();
			
			entity = getById(statement.getInt(1));
			
		} catch (SQLException e) {
			log.callFatalLogger(e);
			return null;
		}
		
		return entity;
	}

	@Override
	public void delete(User entity) {
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "{? = call delete_user(?)}";
			CallableStatement statement = con.prepareCall(sql);
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.setInt(2, entity.getUserId());
			statement.execute();
			
			System.out.println(statement.getString(1));
			
		} catch (SQLException e) {
			log.callFatalLogger(e);
		}
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	
}
