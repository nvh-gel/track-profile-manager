package com.demo.trackprofiler.domain.customconverter;

import org.dozer.CustomConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateTimeConverter implements CustomConverter {

    @Override
    public Object convert(Object dest, Object src, Class<?> destClass, Class<?> srcClass) {
        if (src == null) {
            return null;
        }
        if (src instanceof LocalDateTime) {
            return Date.from(((LocalDateTime) src).atZone(ZoneId.systemDefault()).toInstant());
        } else if (src instanceof Date) {
            return LocalDateTime.ofInstant(((Date) src).toInstant(), ZoneId.systemDefault());
        }
        return null;
    }
}
