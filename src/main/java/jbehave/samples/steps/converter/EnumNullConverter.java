package jbehave.samples.steps.converter;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import  org.jbehave.core.steps.ParameterConverters;
import  org.jbehave.core.steps.ParameterConverters.EnumConverter;
import org.jbehave.core.steps.ParameterConverters.ParameterConvertionFailed;

/**
 * 
 */
public class EnumNullConverter extends EnumConverter {
	
	public static final String DEFAULT_NULL_VALUE = "null";
	
	@Override
	public Object convertValue(String value, Type type) {
		if (value.equals(DEFAULT_NULL_VALUE)) {
			return null;
		}
		return super.convertValue(value, type);
    }

}
