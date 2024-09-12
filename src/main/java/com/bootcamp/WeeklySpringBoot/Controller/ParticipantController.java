package com.bootcamp.WeeklySpringBoot.Controller;

import com.bootcamp.WeeklySpringBoot.Model.Event;
import com.bootcamp.WeeklySpringBoot.Model.Participant;
import com.bootcamp.WeeklySpringBoot.Service.EventService;
import com.bootcamp.WeeklySpringBoot.Service.ParticipantService;
import jakarta.servlet.http.Part;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/participant")
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }
    @GetMapping("")
    public List<Participant> findAll(){
        return participantService.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Participant create(@Valid @RequestBody Participant participant){
        return participantService.create(participant);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Participant participantDetails,
                                 @PathVariable Integer id){
        Optional<Participant> participant = participantService.findById(id);

        if(participant.isPresent()){
            Participant existingParticipant = participant.get();

            existingParticipant.setEvent(participantDetails.getEvent());
            existingParticipant.setParticipant_name(participantDetails.getParticipant_name());
            existingParticipant.setEmail(participantDetails.getEmail());

            Participant updatedParticipant = participantService.create(existingParticipant);

            return ResponseEntity.ok(updatedParticipant);

        }else {
            // Jika participant tidak ditemukan, kembalikan respons 404 dengan pesan error
            Map<String, String> response = new HashMap<>();
            response.put("status", "404");
            response.put("message", "Participant not found");
            return ResponseEntity.status(404).body(response);
        }


    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        participantService.delete(id);
    }

}
