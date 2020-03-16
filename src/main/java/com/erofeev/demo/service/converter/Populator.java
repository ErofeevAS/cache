package com.erofeev.demo.service.converter;

public interface Populator<S, T> {
    void populate(S source, T target);
}
