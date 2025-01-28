package ru.gb.springdemo.model;

public enum Profile {
    ADMIN,
    USER,
    READER;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder( this )
                .toString();
    }
}
