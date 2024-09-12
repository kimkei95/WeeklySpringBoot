package com.bootcamp.WeeklySpringBoot.Model;

import jakarta.persistence.*;

@Entity
@Table(name ="participants")
    public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="event_id",nullable = false)
    private Event event;

    @Column(name = "participant_name", nullable = false)
    private String participant_name;
    @Column(name = "email",nullable = false)
    private String email;

        public Participant(){

        }

    public Participant(
            Integer id,
            Event event,
            String participant_name,
            String email
    ){
            this.id =id;
            this.event=event;
            this.participant_name =participant_name;
            this.email=email;
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

    public String getParticipant_name() {
        return participant_name;
    }

    public void setParticipant_name(String participant_name) {
        this.participant_name = participant_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
