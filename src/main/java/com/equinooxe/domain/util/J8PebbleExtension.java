package com.equinooxe.domain.util;

import java.util.HashMap;
import java.util.Map;

import com.equinooxe.service.util.EqLogger;
import com.mitchellbosecke.pebble.extension.AbstractExtension;
import com.mitchellbosecke.pebble.extension.Filter;

/**
 * A set of Java8 filters and functions for Pebble template engine
 * @author mboullouz
 *
 */
public class J8PebbleExtension extends AbstractExtension {

    @Override
    public Map<String, Filter> getFilters() {
    	EqLogger.info("..J8DateFilter..Loaded");
        Map<String, Filter> functions = new HashMap<String, Filter>();
        functions.put("zonedDate", new ZonedDateTimePebbleFilter());
        functions.put("localDate", new LocalDateTimePebbleFilter());
        functions.put("since", new SinceDatePebbleFilter());
        return functions;
    }
}
