package com.bootcamp.WeeklySpringBoot.Controller;

import com.bootcamp.WeeklySpringBoot.Model.Event;
import com.bootcamp.WeeklySpringBoot.Service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("")
    public List<Event> findAll(){
    return eventService.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Event create(@Valid @RequestBody Event event){
        return eventService.create(event);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Event event,
                       @PathVariable Integer id){
        eventService.update(event,id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        eventService.delete(id);
    }

}
