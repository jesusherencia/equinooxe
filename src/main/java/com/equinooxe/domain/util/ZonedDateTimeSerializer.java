package com.equinooxe.domain.util;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * A simple serializer for Jackson
 * NB please not that the timezone part is omitted for simplicity!
 * @author mboullouz
 *
 */
public class ZonedDateTimeSerializer extends StdSerializer<ZonedDateTime> {
    private static final long serialVersionUID = 1L;

    public ZonedDateTimeSerializer(){
        super(ZonedDateTime.class);
    }

    @Override
    public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider sp) throws IOException, JsonProcessingException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        gen.writeString(value.format(formatter));
    }
}