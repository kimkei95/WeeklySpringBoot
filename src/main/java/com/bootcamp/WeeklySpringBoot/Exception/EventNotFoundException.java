package com.bootcamp.WeeklySpringBoot.Exception;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Integer id) {
        super("event not found");
    }
}
