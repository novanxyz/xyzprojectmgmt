package com.visitek.xyzproject.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.script.ScriptException;

import com.visitek.xyzproject.model.business.Validation;
import com.visitek.xyzproject.model.business.ValidationRule;
import com.visitek.xyzproject.service.exception.FormulaException;
import com.visitek.xyzproject.service.exception.ValidationException;
import com.visitek.xyzproject.util.FormulaIntepreter;
import com.visitek.xyzproject.util.IValidator;

public class PropertyValidator implements IValidator {

	private List getValidation(String className, String field) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object Validate(String className, String field, Object value)
			throws ValidationException, FormulaException, ScriptException,
			NoSuchMethodException {

		Object ret = value;
		List valids = getValidation(className, field);

		Iterator<Validation> it = valids.iterator();

		while (it.hasNext()) {
			Validation valid = it.next();

			Set<ValidationRule> rules = valid.getRules();

			Iterator<ValidationRule> rIt = rules.iterator();

			while (rIt.hasNext()) {
				ValidationRule rule = rIt.next();
				if (!new FormulaIntepreter(rule.getTestExpression())
						.eval(value).equals(null)) {
					if (!rule.getTrueFormula().equals(null))
						ret = new FormulaIntepreter(rule.getTrueFormula())
								.eval(value);

				} else {
					if (rule.getFalseFormula().equals(null))
						throw new ValidationException(rule
								.getExceptionMessage());
					ret = new FormulaIntepreter(rule.getFalseFormula())
							.eval(value);
				}
			}
		}

		return ret;
	}
}
