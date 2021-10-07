package com.revature.project1.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.models.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao{
	private DBConnection dbCon;
	
	public ReimbursementDaoImpl() {
	}

	public ReimbursementDaoImpl(DBConnection dbCon) {
		this.dbCon = dbCon;
	}

	@Override
	public List<Reimbursement> getAll() {
		List<Reimbursement> reimbursementsList = new ArrayList<Reimbursement>();
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_reimbursement";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) 
			{
				reimbursementsList.add(new Reimbursement(result.getInt(1), result.getDouble(2), result.getString(3), result.getString(4), result.getString(5), result.getByte(6), result.getInt(7), result.getInt(8), result.getInt(9), result.getInt(10)));
			}
		} catch (SQLException e) {
			e.fillInStackTrace();
			}
		return reimbursementsList;
	}

	@Override
	public Reimbursement getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getById(int id) {
		Reimbursement reimbursement = new Reimbursement();
		
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "select * from ers_reimbursement re where re.reimb_id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				reimbursement = new Reimbursement(result.getInt(1), result.getDouble(2), result.getString(3), result.getString(4), result.getString(5), result.getByte(6), result.getInt(7), result.getInt(8), result.getInt(9), result.getInt(10));
			}
		} catch (SQLException e) {
			e.fillInStackTrace();
		}
		return reimbursement;
	}

	@Override
	public Reimbursement update(Reimbursement entity) {
		Reimbursement newReimbursement = new Reimbursement();
		
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "{? = call update_user(?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement statement = con.prepareCall(sql);
			statement.registerOutParameter(1, Types.INTEGER);
			statement.setInt(2, entity.getReimbId());
			statement.setDouble(3, entity.getReimbAmount());
			statement.setString(4, entity.getReimbSubmitted());
			statement.setString(5, entity.getReimbResolved());
			statement.setString(6, entity.getReimbDescription());
			statement.setByte(7, entity.getReimbReceipt());
			statement.setInt(8, entity.getReimbAuthor());
			statement.setInt(9, entity.getReimbResolver());
			statement.setInt(10, entity.getReimbStatusId());
			statement.setInt(11, entity.getReimbTypeId());
			
			
			statement.execute();
			
			System.out.println(statement.getString(1));
			newReimbursement = getById(statement.getInt(1));
			
		} catch (SQLException e) {
			e.fillInStackTrace();
		}
		
		
		return newReimbursement;
	}

	@Override
	public Reimbursement insert(Reimbursement entity) {
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "{? = call insert_reimbursement(?,?,?,?,?,?,?,?,?)}";
			CallableStatement statement = con.prepareCall(sql);
			statement.registerOutParameter(1, Types.INTEGER);
			statement.setDouble(2, entity.getReimbAmount());
			statement.setString(3, entity.getReimbSubmitted());
			statement.setString(4, entity.getReimbResolved());
			statement.setString(5, entity.getReimbDescription());
			statement.setByte(6, entity.getReimbReceipt());
			statement.setInt(7, entity.getReimbAuthor());
			statement.setInt(8, entity.getReimbResolver());
			statement.setInt(9, entity.getReimbStatusId());
			statement.setInt(10, entity.getReimbTypeId());
			statement.execute();
			
			entity = getById(statement.getInt(1));
			
		} catch (SQLException e) {
			e.fillInStackTrace();
		}
		
		return entity;
	}

	@Override
	public void delete(Reimbursement entity) {
		try(Connection con = dbCon.getDBConnection()) {
			String sql = "{? = call delete_reimbursement(?)}";
			CallableStatement statement = con.prepareCall(sql);
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.setInt(2, entity.getReimbId());
			statement.execute();
			
			System.out.println(statement.getString(1));
			
		} catch (SQLException e) {
			e.fillInStackTrace();
		}
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
