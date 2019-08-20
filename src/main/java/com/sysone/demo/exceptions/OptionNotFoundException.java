package com.sysone.demo.exceptions;

public class OptionNotFoundException extends RuntimeException {

    public OptionNotFoundException(Long id) {
        super("Could not find option " + id);
    }
}
