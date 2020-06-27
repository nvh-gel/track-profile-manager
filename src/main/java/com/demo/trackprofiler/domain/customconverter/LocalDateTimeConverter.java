package com.demo.trackprofiler.domain.customconverter;

import org.dozer.CustomConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Custom Dozer mapper convert for java8 LocalDateTime<>Date
 */
public class LocalDateTimeConverter implements CustomConverter {

    /**
     * Convert between LocalDateTime and Date
     *
     * @param dest      object to convert to
     * @param src       object to convert from
     * @param destClass Class to convert to
     * @param srcClass  class to convert from
     * @return converted object
     */
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
