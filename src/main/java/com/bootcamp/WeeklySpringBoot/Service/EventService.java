package com.bootcamp.WeeklySpringBoot.Service;

import com.bootcamp.WeeklySpringBoot.Exception.EventNotFoundException;
import com.bootcamp.WeeklySpringBoot.Model.Event;
import com.bootcamp.WeeklySpringBoot.Repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public List<Event> findAll(){
    return eventRepository.findAll();
    }
//    Event findById(@PathVariable Integer id) {
//        Optional<Event> event = eventRepository.findById(id);
//        if (event.isEmpty()) {
//            throw new EventNotFoundException(id);
//        }
//        return event.get();
//    }
    public Event create(Event event) {
        return eventRepository.save(event);
    }
    public void update(Event event, Integer id) {
        if(!eventRepository.existsById(id)){
            throw new EventNotFoundException(id);
        }
        Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
        Event updatedEvent = new Event(
                id,
                event.getTitle(),
                event.getStartOn(),
                event.getEndOn(),
                event.getParticipant(),
                event.getLocation()
        );
        eventRepository.save(updatedEvent);
    }
    public void delete(Integer id) {
        eventRepository.delete(
                eventRepository
                        .findById(id)
                        .orElseThrow(()-> new EventNotFoundException(id)));
    }
    List<Event> findByLocation(@PathVariable String location){
        return eventRepository.findAllByLocation(location);
    }
    List<Event> findByTitle(@PathVariable String title){
        return eventRepository.findByTitle(title);
    }
}
