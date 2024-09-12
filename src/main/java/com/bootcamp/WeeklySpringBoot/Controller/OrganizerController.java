package com.bootcamp.WeeklySpringBoot.Controller;

import com.bootcamp.WeeklySpringBoot.Model.Organizer;

import com.bootcamp.WeeklySpringBoot.Model.Participant;
import com.bootcamp.WeeklySpringBoot.Service.OrganizerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/organizer")
public class OrganizerController {
    private final OrganizerService organizerService;


    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }
    @GetMapping("")
    public List<Organizer> findAll(){
        return organizerService.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Organizer create(@Valid @RequestBody Organizer organizer){
        return organizerService.create(organizer);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Organizer organizerDetails,
                                    @PathVariable Integer id){
        Optional<Organizer> organizer = organizerService.findById(id);

        if(organizer.isPresent()){
            Organizer existingOrganizer = organizer.get();

            existingOrganizer.setEvent(organizerDetails.getEvent());
            existingOrganizer.setName_organizer(organizerDetails.getName_organizer());
            existingOrganizer.setRole(organizerDetails.getRole());

            Organizer updatedOrganizer = organizerService.create(existingOrganizer);

            return ResponseEntity.ok(updatedOrganizer);

        }else {
            // Jika participant tidak ditemukan, kembalikan respons 404 dengan pesan error
            Map<String, String> response = new HashMap<>();
            response.put("status", "404");
            response.put("message", "organizer not found");
            return ResponseEntity.status(404).body(response);
        }


    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        organizerService.delete(id);
    }
}
