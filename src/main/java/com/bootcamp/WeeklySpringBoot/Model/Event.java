package com.bootcamp.WeeklySpringBoot.Model;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name="startOn", nullable = false)
    private LocalDateTime startOn;
    @Column(name = "endOn", nullable = false)
    private LocalDateTime endOn;
    @Positive
    @Column(name = "participant", nullable = false)
    private Integer participant;
    @Column(name="location",nullable = false)
    private String location;

    public Event(){

    }

    public Event(
        Integer id,
        String title,
        LocalDateTime startOn,
        LocalDateTime endOn,
        Integer participant,
        String location
        ){if(!endOn.isAfter(startOn)){
        throw new IllegalArgumentException("Complete must be after start");
    }
        this.id = id;
        this.title = title;
        this.startOn = startOn;
        this.endOn = endOn;
        this.participant = participant;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public  String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartOn() {
        return startOn;
    }

    public void setStartOn(LocalDateTime startOn) {
        this.startOn = startOn;
    }

    public LocalDateTime getEndOn() {
        return endOn;
    }

    public void setEndOn(LocalDateTime endOn) {
        this.endOn = endOn;
    }

    public Integer getParticipant() {
        return participant;
    }

    public void setParticipant(Integer participant) {
        this.participant = participant;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
