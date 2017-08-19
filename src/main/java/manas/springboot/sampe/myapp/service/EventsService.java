package manas.springboot.sampe.myapp.service;


import java.util.List;

import manas.springboot.sampe.myapp.beans.Event;

public interface EventsService {
	
	Event findById(Long id);

	Event findByName(String name);

	void saveEvent(Event event);

	void updateEvent(Event event);
	
	
	void deleteUserById(Long id);

	void deleteAllUsers();

	List<Event> findAllUsers();

	boolean isUserExist(Event event);
}