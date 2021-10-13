package com.revature.project1.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.LogHelper;
import com.revature.project1.models.Role;

public class RoleDaoImpl implements RoleDao{
	
	private DBConnection dbCon;
	private final LogHelper log = new LogHelper();
	
	public RoleDaoImpl() {
	}
	
	public RoleDaoImpl(DBConnection dbCon) {
		this.dbCon = dbCon;
	}

	@Override
	public List<Role> getAll() {
		List<Role> rolesList = new ArrayList<Role>();
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_user_roles";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				rolesList.add(new Role(result.getInt(1), result.getString(2)));
			}
			
		} catch (SQLException e) {
			log.callFatalLogger(e);
			return null;
		}
		
		return rolesList;
	}

	@Override
	public Role getByName(String name) {
		Role role = new Role();
		
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_user_roles r where r.user_role = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				role = new Role(result.getInt(1), result.getString(2));
			}
		} catch (SQLException e) {
			log.callFatalLogger(e);
			return null;
		}
		return role;
	}

	@Override
	public Role getById(int id) {
		Role role = new Role();
		
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_user_roles r where r.ers_user_role_id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				role = new Role(result.getInt(1), result.getString(2));
			}
		} catch (SQLException e) {
			log.callFatalLogger(e);
			return null;
		}
		return role;
	}

	@Override
	public Role update(Role entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role insert(Role entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Role entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
