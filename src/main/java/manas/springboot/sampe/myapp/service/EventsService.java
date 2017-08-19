package manas.springboot.sampe.myapp.service;


import java.util.List;

import manas.springboot.sampe.myapp.beans.Event;

public interface EventsService {
	
	Event findById(Long id);

	Event findByName(String name);

	void saveEvent(Event event);

	void updateEvent(Event event);
	
	
	void deleteEventById(Long id);

	void deleteAllEvents();

	List<Event> findAllEvents();

	boolean isEventExist(Event event);
}