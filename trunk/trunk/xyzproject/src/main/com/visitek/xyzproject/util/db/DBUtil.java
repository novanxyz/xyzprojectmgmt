package com.visitek.xyzproject.util.db;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public interface DBUtil {

	public void delete(Object entity);

	public Connection getConnection();

	public Session getCurrentSession();

	public void initialize(boolean serverMode);

	public Object load(Class classname, Serializable id);

	public Query namedQuery(String queryname);

	public List query(String query);

	public void save(Object entity);

	public void update(Object entity);

}
