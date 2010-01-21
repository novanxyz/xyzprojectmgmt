package com.visitek.xyzproject.util.scriptengine;

import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;

import com.visitek.xyzproject.app.Constants;

public class DBScriptEngine implements ScriptEngine {
	
	static Connection db;
	Statement sql;
	
	
	
	static {
		db =Constants.database.getConnection();
	}
	
	
	public DBScriptEngine(String formula) throws SQLException {
		super();
		sql = db.prepareCall(formula);
		
	}

	public Bindings createBindings() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eval(String script) throws ScriptException {
		ResultSet rs ;
		try {
			if ((rs = sql.executeQuery(script))!=null){
				return rs.getObject(0);
			}
		} catch (SQLException e) {
			throw new ScriptException(e.getMessage());			
		}
		
		return null;
	}

	public Object eval(Reader reader) throws ScriptException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eval(String script, ScriptContext context)
			throws ScriptException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eval(Reader reader, ScriptContext context)
			throws ScriptException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eval(String script, Bindings n) throws ScriptException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eval(Reader reader, Bindings n) throws ScriptException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bindings getBindings(int scope) {
		// TODO Auto-generated method stub
		return null;
	}

	public ScriptContext getContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public ScriptEngineFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public void put(String key, Object value) {
		// TODO Auto-generated method stub

	}

	public void setBindings(Bindings bindings, int scope) {
		// TODO Auto-generated method stub

	}

	public void setContext(ScriptContext context) {
		// TODO Auto-generated method stub

	}

}
