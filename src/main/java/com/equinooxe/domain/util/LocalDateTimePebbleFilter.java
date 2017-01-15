package com.equinooxe.domain.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mitchellbosecke.pebble.extension.Filter;

public class LocalDateTimePebbleFilter implements Filter {
	private final List<String> argumentNames = new ArrayList<>();

	public LocalDateTimePebbleFilter() {
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
		LocalDateTime in =(LocalDateTime) input;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		return in.format(formatter);
	}
}