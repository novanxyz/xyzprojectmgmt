package com.visitek.xyzproject.util;

import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.visitek.xyzproject.service.exception.FormulaException;

public class FormulaIntepreter {
	static int FORMULA_SIMPLE = 0;
	static int FORMULA_REGEX = 1;
	static int FORMULA_DBQUERY = 2;
	
	
	String formula;
	String paramName;
	int type;
	
	static ScriptEngineManager scrmgr ;
	static ScriptEngine engine;
	ScriptContext context;
	
	static {
		
		scrmgr = new ScriptEngineManager();
		engine = scrmgr.getEngineByName("Javascript");
			
	}
	
	public FormulaIntepreter(String formula) throws FormulaException{
		
		if (formula.startsWith("file://")){
			String ext = formula.substring(formula.lastIndexOf('.')+1);
			engine = scrmgr.getEngineByExtension(ext);						
		}else{
			this.formula = parseExpression(formula);
		}
		
		// automatically parse formula execution order by surround it by parenthese
				
	}
	
	public String parseExpression(String formula) {
		
		int kb = 0;
		int kt = formula.length();
		String t = formula; 

		String r = "";
		
		if (formula.length()==0) return "";
		
		for (int i=0;i<formula.length();i++){			
		  if (formula.charAt(i)=='('){
			kt = findEnclosure(i, formula,'(',')');
			
			if (kt < i) {// g ada ??? tambah di belakang
				t = formula + ")";
			}else {
				t = formula.substring(0, i-1) + parseExpression(formula.substring(i+1, kt-1)) + formula.substring(kt+1,formula.length());
			}			
		  }else if (formula.charAt(i)=='\''){ 
			  kt = findEnclosure(i,formula,'\'','\'');
			  
			  if (kt < i) {// g ada ??? tambah di belakang
					t = formula + '\'';
				}else {
					t = formula;
				}  			 
		  }else if ((formula.charAt(i) >64 && formula.charAt(i)<91) ||
				  (formula.charAt(i) >96 && formula.charAt(i)<123) ){
			// let it
			  r = t + kb;
			  t= r;
			continue;
		  }
		  
		}
		
		
		
		
		return null;
	}

	private int findEnclosure(int i, String exp, char openchar, char closechar) {
		int r ,o;
				
		r = exp.indexOf(closechar, i+1);
		o = exp.indexOf(openchar);
		if (closechar != openchar && o  < r) {
			r = exp.indexOf(closechar,findEnclosure(o,exp,openchar,closechar)+1);
		}		
		return r;
	}

	public int isRegisteredFormula(String formula){
		
		return -1;
	}
	
	
	public Object eval(Object input) throws FormulaException, ScriptException, NoSuchMethodException{
		

		if (isRegisteredFormula(formula)>= 0){
			Invocable invoker = (Invocable)engine;
			
			return invoker.invokeFunction(formula, input);
		}
		
		setParameter(input);
		return null;
	}

	private void setParameter(Object input) {
		
		
		
	}
	
	
	
	
	  
	

}
