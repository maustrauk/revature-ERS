package com.revature.project1.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.LogHelper;
import com.revature.project1.models.ReimbType;

public class ReimbTypeDaoImpl implements ReimbTypeDao{
	private DBConnection dbCon;
	private final LogHelper log = new LogHelper();
	
	public ReimbTypeDaoImpl() {
	}

	public ReimbTypeDaoImpl(DBConnection dbCon) {
		this.dbCon = dbCon;
	}

	@Override
	public List<ReimbType> getAll() {
		List<ReimbType> reimbTypeList = new ArrayList<ReimbType>();
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_reimbursement_type";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) 
			{
				reimbTypeList.add(new ReimbType(result.getInt(1), result.getString(2)));
			}
		} catch (SQLException e) {
			log.callFatalLogger(e);
			}
		return reimbTypeList;
	}

	@Override
	public ReimbType getByName(String name) {
		ReimbType reimbType = new ReimbType();
		
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_reimbursement_type rt where rt.reimb_type = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				reimbType = new ReimbType(result.getInt(1), result.getString(2));
			}
		} catch (SQLException e) {
			log.callFatalLogger(e);
		}
		return reimbType;
	}

	@Override
	public ReimbType getById(int id) {
		ReimbType reimbType = new ReimbType();
		
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_reimbursement_type rt where rt.reimb_type_id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				reimbType = new ReimbType(result.getInt(1), result.getString(2));
			}
		} catch (SQLException e) {
			log.callFatalLogger(e);
		}
		return reimbType;
	}

	@Override
	public ReimbType update(ReimbType entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbType insert(ReimbType entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ReimbType entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
}
