package com.apside.prono.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apside.prono.model.Event;
import com.apside.prono.service.EventService;

@RestController
@RequestMapping(value = "/event")
public class EventRestController {

    @Autowired
    private EventService eventService;

    @GetMapping(produces = "application/json", path = "/allevent")
    public Iterable<Event> getAllEvents() {

        return eventService.getAllEvents();
    }

    @PostMapping(consumes = "application/json", path = "/newevent")
    public Event createEvent(@RequestBody Event event) {

        return eventService.createEvent(event);
    }

    @GetMapping(produces = "application/json", path = "/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PutMapping(consumes = "application/json", produces = "application/json", path = "/modifyevent")
    public Event modifyEvent(@RequestBody Event event) {
        return eventService.modifyEvent(event);
    }

    @DeleteMapping(path = "/deleteplayer")
    public void deleteEvent(@RequestBody Event event) {
        eventService.deleteEvent(event);
    }
}
