package manas.springboot.sampe.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manas.springboot.sampe.myapp.beans.Event;
import manas.springboot.sampe.myapp.repository.EventsRepository;




@Service("eventsService")
@Transactional
public class EventsServiceImpl implements EventsService{

	@Autowired
	private EventsRepository eventsRepository;

	public Event findById(Long id) {
		return eventsRepository.findOne(id);
	}

	public Event findByName(String name) {
		return eventsRepository.findByName(name);
	}

	public void saveEvent(Event event) {
		eventsRepository.save(event);
	}

	public void updateEvent(Event event){
		saveEvent(event);
	}
	
	public void deleteEventById(Long id){
		eventsRepository.delete(id);
	}

	public void deleteAllEvents(){
		eventsRepository.deleteAll();
	}

	
	public List<Event> findAllEvents(){
		return eventsRepository.findAll();
	}

	public boolean isEventExist(Event event) {
		return findByName(event.getName()) != null;
	}

}
