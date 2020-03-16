package com.erofeev.demo.service.converter;

public interface Converter<S, T> {
    T convert(S source);
}