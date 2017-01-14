package com.equinooxe.domain.util;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mitchellbosecke.pebble.extension.Filter;

public class J8DateFilter implements Filter {
	private final List<String> argumentNames = new ArrayList<>();

	public J8DateFilter() {
		argumentNames.add("format");
		argumentNames.add("existingFormat");
	}

	@Override
	public List<String> getArgumentNames() {
		return argumentNames;
	}

	@Override
	public Object apply(Object input, Map<String, Object> args) {
		if (input == null) {
            return "Unknown_date";
        }
		LocalDateTime in =((ZonedDateTime) input).toLocalDateTime();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return in.format(formatter);
	}

}
