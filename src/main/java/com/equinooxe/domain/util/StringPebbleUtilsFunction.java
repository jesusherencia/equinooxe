/*******************************************************************************
 * This file is part of Pebble.
 *
 * Copyright (c) 2014 by Mitchell Bösecke
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.equinooxe.domain.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.mitchellbosecke.pebble.extension.Function;

/**
 * Add some utils from good ApacheCommon
 * @author mboullouz
 *
 */
public class StringPebbleUtilsFunction implements Function {

	public static final String FUNCTION_NAME = "StringUtils";

	private static final String PARAM_FIRST_STR = "first";
	private static final String PARAM_SECOND_STR = "second";
	private static final String PARAM_OPERATION = "operation";
	
	private static final String CONTAINS_OP = "contains";
	private static final String BLANK_OP = "blank";

	private final List<String> argumentNames = new ArrayList<>();

	public StringPebbleUtilsFunction() {
		this.argumentNames.add(PARAM_FIRST_STR);
		this.argumentNames.add(PARAM_SECOND_STR);
		this.argumentNames.add(PARAM_OPERATION);
	}

	@Override
	public List<String> getArgumentNames() {
		return this.argumentNames;
	}

	@Override
	public Object execute(Map<String, Object> args) {

		String first = (String) args.get(PARAM_FIRST_STR);
		String second = (String) args.get(PARAM_SECOND_STR);
		String operation = (String) args.get(PARAM_OPERATION);
		
		if(StringUtils.equalsIgnoreCase(operation, CONTAINS_OP)){
			return StringUtils.contains(first, second);
		}
		if(StringUtils.equalsIgnoreCase(operation, BLANK_OP)){
			return StringUtils.isBlank(first);
		}

		return null;
	}
}
