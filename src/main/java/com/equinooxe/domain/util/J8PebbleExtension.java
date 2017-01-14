package com.equinooxe.domain.util;

import java.util.HashMap;
import java.util.Map;

import com.equinooxe.service.util.EqLogger;
import com.mitchellbosecke.pebble.extension.AbstractExtension;
import com.mitchellbosecke.pebble.extension.Filter;

public class J8PebbleExtension extends AbstractExtension {

    @Override
    public Map<String, Filter> getFilters() {
    	EqLogger.info("..J8DateFilter..Loaded");
        Map<String, Filter> functions = new HashMap<String, Filter>();
        functions.put("zonedDate", new J8DateFilter());
        return functions;
    }
}
