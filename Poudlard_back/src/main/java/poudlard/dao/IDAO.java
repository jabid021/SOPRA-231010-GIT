package poudlard.dao;

import java.util.List;

public interface IDAO<T,K> {

	String urlBdd = "jdbc:mysql://localhost:3306/poudlard?characterEncoding=UTF-8";
	String loginBdd = "root";
	String passwordBdd = "";
	
	public T findById(K id);
	public List<T> findAll();
	public T insert(T obj);
	public T update(T obj);
	public void delete(K id);
	
}
