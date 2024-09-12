package com.bootcamp.WeeklySpringBoot.Repository;

import com.bootcamp.WeeklySpringBoot.Model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {

}
