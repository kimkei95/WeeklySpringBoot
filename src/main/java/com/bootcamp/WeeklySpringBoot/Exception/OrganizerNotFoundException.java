package com.bootcamp.WeeklySpringBoot.Exception;

public class OrganizerNotFoundException extends RuntimeException {
    public OrganizerNotFoundException(Integer id) {
        super("id not found");
    }
}
