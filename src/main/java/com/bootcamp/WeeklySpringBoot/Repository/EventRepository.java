package com.bootcamp.WeeklySpringBoot.Repository;


import com.bootcamp.WeeklySpringBoot.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findAllByLocation(String location);

    List<Event> findByTitle(String title);
}
