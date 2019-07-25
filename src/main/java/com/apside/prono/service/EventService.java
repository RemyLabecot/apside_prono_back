package com.apside.prono.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apside.prono.model.Event;
import com.apside.prono.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	public Iterable <Event> getAllEvents() {
		return eventRepository.findAll();
	}
	
	@Transactional
	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public Event getEventById(Long id) {
		return eventRepository.findById(id).get();
	}
	
	@Transactional
	public Event modifyEvent(Event event) {
		Event eventModif = getEventById(event.getId());

		eventModif.setId(event.getId());
		eventModif.setLabel(event.getLabel());
		eventModif.setEventDate(event.getEventDate());
		eventModif.setOpenDate(event.getOpenDate());
		eventModif.setCloseDate(event.getCloseDate());
		eventModif.setCloseDate(event.getCloseDate());
		eventModif.setCoeff(event.getCoeff());
		eventModif.setContest(event.getContest());
		
		return eventModif;
	}
	
	@Transactional
	public void deleteEvent(Event event) {
		eventRepository.delete(event);
	}
	
}
