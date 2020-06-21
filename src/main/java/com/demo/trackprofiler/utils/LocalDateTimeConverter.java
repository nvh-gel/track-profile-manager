package com.demo.trackprofiler.utils;

import org.dozer.CustomConverter;

import java.time.LocalDateTime;

public class LocalDateTimeConverter implements CustomConverter {

    @Override
    public Object convert(Object dest, Object src, Class<?> aClass, Class<?> bClass1) {
        if (src == null) {
            return null;
        }
        if (src instanceof LocalDateTime) {
            return src;
        }
        return null;
    }
}
