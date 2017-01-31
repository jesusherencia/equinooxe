package com.equinooxe.domain.util;

import java.util.HashMap;
import java.util.Map;

import com.mitchellbosecke.pebble.extension.AbstractExtension;
import com.mitchellbosecke.pebble.extension.Filter;
import com.mitchellbosecke.pebble.extension.Function;

/**
 * A set of Java8 filters and functions for Pebble template engine
 * @author mboullouz
 *
 */
public class J8PebbleExtension extends AbstractExtension {
  
    @Override
    public Map<String, Filter> getFilters() {
        Map<String, Filter> filters = new HashMap<String, Filter>();
        filters.put("zonedDate", new ZonedDateTimePebbleFilter());
        filters.put("localDate", new LocalDateTimePebbleFilter());
        filters.put("since", new SinceDatePebbleFilter());
        return filters;
    }
    @Override
    public Map<String, Function> getFunctions() {
    	 Map<String, Function> functions = new HashMap<String, Function>();
    	 functions.put(StringPebbleUtilsFunction.FUNCTION_NAME, new StringPebbleUtilsFunction());
    	 return functions;
    }
}
