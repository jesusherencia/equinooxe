package com.equinooxe.domain.util;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mitchellbosecke.pebble.extension.Filter;

/**
 * Simple toString ZonedDateTime for Pebble
 * Warning: this drop timezone part as the app only need simple,
 * format displaying,  Locale is ignored!
 * @author mboullouz
 *
 */
public class ZonedDateTimePebbleFilter implements Filter {
	private final List<String> argumentNames = new ArrayList<>();

	public ZonedDateTimePebbleFilter() {
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
