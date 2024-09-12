package com.bootcamp.WeeklySpringBoot.Service;

import com.bootcamp.WeeklySpringBoot.Exception.EventNotFoundException;
import com.bootcamp.WeeklySpringBoot.Exception.OrganizerNotFoundException;
import com.bootcamp.WeeklySpringBoot.Exception.ParticipantNotFoundException;
import com.bootcamp.WeeklySpringBoot.Model.Organizer;

import com.bootcamp.WeeklySpringBoot.Model.Participant;
import com.bootcamp.WeeklySpringBoot.Repository.OrganizerRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {
    private final OrganizerRepository organizerRepository;


    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }
    public List<Organizer> findAll() {
        return organizerRepository.findAll();
    }
    public Optional<Organizer> findById(Integer id){
        return  organizerRepository.findById(id);
    }
    public Organizer create(Organizer organizer){
        return organizerRepository.save(organizer);
    }
    public void update(Integer id) {
        if(!organizerRepository.existsById(id)){
            throw new OrganizerNotFoundException(id);
        }
        Organizer existingOrganizer = organizerRepository.findById(id).orElseThrow(() -> new OrganizerNotFoundException(id));
       Organizer updatedOrganizer = new Organizer(
                id,
                existingOrganizer.getEvent(),
                existingOrganizer.getName_organizer(),
               existingOrganizer.getRole()
        );
        organizerRepository.save(updatedOrganizer);
    }
    public void delete(Integer id) {
        organizerRepository.delete(
                organizerRepository
                        .findById(id)
                        .orElseThrow(()-> new OrganizerNotFoundException(id)));
    }

}
