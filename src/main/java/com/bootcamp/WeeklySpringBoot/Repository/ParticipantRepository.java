package com.bootcamp.WeeklySpringBoot.Repository;

import com.bootcamp.WeeklySpringBoot.Model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

}
