package com.revature.project1.daos;

import java.util.List;

public interface GenericDao <T>{
	List<T> getAll();
	T getByName(String name);
	T getById(int id);
	T update(T entity);
	T insert(T entity);
	void delete(T entity);
	void deleteAll();
}
