package com.bootcamp.WeeklySpringBoot.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "Organizer")
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="event_id",nullable = false)
    private Event event;
    @NotEmpty
    @Column(name = "name_organizer", nullable = false)
    private String name_organizer;
    @Column(name = "role", nullable = false)
    private String role;

    public Organizer(){

    }
    public Organizer(
            Integer id,
            Event event,
            String name_organizer,
            String role
    ){
        this.id =id;
        this.event=event;
        this.name_organizer =name_organizer;
        this.role=role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public  String getName_organizer() {
        return name_organizer;
    }

    public void setName_organizer( String name_organizer) {
        this.name_organizer = name_organizer;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
