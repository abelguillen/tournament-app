package com.aguillen.tournamentapp.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LocalDateAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
     
	@Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
		ZonedDateTime ldtZoned = locDateTime.atZone(ZoneId.systemDefault());
    	ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));
    	ZonedDateTime bsAsZoned = utcZoned.withZoneSameInstant(ZoneId.of("America/Buenos_Aires"));
        return bsAsZoned.toLocalDateTime() == null ? null : Timestamp.valueOf(locDateTime);
    }
 
    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
    	LocalDateTime locDateTime = sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime();
    	ZonedDateTime ldtZoned = locDateTime.atZone(ZoneId.systemDefault());
    	ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));
    	ZonedDateTime bsAsZoned = utcZoned.withZoneSameInstant(ZoneId.of("America/Buenos_Aires"));
        return bsAsZoned.toLocalDateTime();
    }
}
