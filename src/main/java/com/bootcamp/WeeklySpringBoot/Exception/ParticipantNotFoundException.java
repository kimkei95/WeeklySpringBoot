package com.bootcamp.WeeklySpringBoot.Exception;

public class ParticipantNotFoundException extends RuntimeException {
    public ParticipantNotFoundException(Integer id) {
        super("id not found");
    }
}
