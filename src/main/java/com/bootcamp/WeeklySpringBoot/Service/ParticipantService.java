package com.bootcamp.WeeklySpringBoot.Service;


import com.bootcamp.WeeklySpringBoot.Exception.EventNotFoundException;
import com.bootcamp.WeeklySpringBoot.Exception.ParticipantNotFoundException;
import com.bootcamp.WeeklySpringBoot.Model.Participant;

import com.bootcamp.WeeklySpringBoot.Repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;


    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    public Optional<Participant> findById(Integer id){
        return  participantRepository.findById(id);
    }
    public Participant create(Participant participant){
        return participantRepository.save(participant);
    }
//    public void update(Participant, Integer id) {
//        if(!participantRepository.existsById(id)){
//            throw new ParticipantNotFoundException(id);
//        }
//        Participant existingParticipant = participantRepository.findById(id).orElseThrow(() -> new ParticipantNotFoundException(id));
//        Participant updatedParticipant = new Participant(
//                id,
//                existingParticipant.getEvent(),
//                existingParticipant.getParticipant_name(),
//                existingParticipant.getEmail()
//        );
//        participantRepository.save(updatedParticipant);
//    }
public void update(Integer id) {
    if(!participantRepository.existsById(id)){
        throw new ParticipantNotFoundException(id);
    }
    Participant existingParticipant = participantRepository.findById(id).orElseThrow(() -> new ParticipantNotFoundException(id));
    Participant updatedParticipant = new Participant(
            id,
            existingParticipant.getEvent(),
            existingParticipant.getParticipant_name(),
            existingParticipant.getEmail()
    );
    participantRepository.save(updatedParticipant);
}
    public void delete(Integer id) {
        participantRepository.delete(
                participantRepository
                        .findById(id)
                        .orElseThrow(()-> new EventNotFoundException(id)));
    }

}
