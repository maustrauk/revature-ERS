package com.revature.project1.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.LogHelper;
import com.revature.project1.models.ReimbStatus;

public class ReimbStatusDaoImpl implements ReimbStatusDao{
	private DBConnection dbCon;
	private final LogHelper log = new LogHelper();

	public ReimbStatusDaoImpl() {
	}
	
	public ReimbStatusDaoImpl(DBConnection dbCon) {
		this.dbCon = dbCon;
	}

	@Override
	public List<ReimbStatus> getAll() {
		List<ReimbStatus> reimbStatusList = new ArrayList<ReimbStatus>();
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_reimbursement_status";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) 
			{
				reimbStatusList.add(new ReimbStatus(result.getInt(1), result.getString(2)));
			}
		} catch (SQLException e) {
			log.callFatalLogger(e);
			}
		return reimbStatusList;
	}

	@Override
	public ReimbStatus getByName(String name) {
		ReimbStatus reimbStatus = new ReimbStatus();
		
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_reimbursement_status rs where rs.reimb_status = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				reimbStatus = new ReimbStatus(result.getInt(1), result.getString(2));
			}
		} catch (SQLException e) {
			log.callFatalLogger(e);
		}
		return reimbStatus;
	}

	@Override
	public ReimbStatus getById(int id) {
		ReimbStatus reimbStatus = new ReimbStatus();
		
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_reimbursement_status rs where rs.reimb_status_id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				reimbStatus = new ReimbStatus(result.getInt(1), result.getString(2));
			}
		} catch (SQLException e) {
			log.callFatalLogger(e);
		}
		return reimbStatus;
	}

	@Override
	public ReimbStatus update(ReimbStatus entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbStatus insert(ReimbStatus entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ReimbStatus entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
