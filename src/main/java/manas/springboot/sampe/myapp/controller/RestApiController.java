package manas.springboot.sampe.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import manas.springboot.sampe.myapp.beans.Event;
import manas.springboot.sampe.myapp.service.EventsService;
import manas.springboot.sampe.myapp.util.CustomErrorType;



@Controller
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	EventsService eventsService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Events---------------------------------------------

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public ResponseEntity listAllEvents() {
		
		System.out.println("list added");
		List<Event> events = eventsService.findAllEvents();
		if (events.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity(events, HttpStatus.OK);
	}

	// -------------------Retrieve Single Event------------------------------------------

	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEvent(@PathVariable("id") long id) {
		logger.info("Fetching Event with id {}", id);
		Event event = eventsService.findById(id);
		if (event == null) {
			logger.error("Event with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Event with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

	// -------------------Create a Event-------------------------------------------

	@RequestMapping(value = "/event/", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public String createEvent(Event event, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Event : {}", event);

		if (eventsService.isEventExist(event)) {
			logger.error("Unable to create. A Event with name {} already exist", event.getName());
			return "";
		}
		eventsService.saveEvent(event);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/event/{id}").buildAndExpand(event.getId()).toUri());
		return "eventCreated";
	}

	// ------------------- Update a Event ------------------------------------------------

	@RequestMapping(value = "/event/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEvent(@PathVariable("id") long id, @RequestBody Event event) {
		logger.info("Updating Event with id {}", id);

		Event currentEvent = eventsService.findById(id);

		if (currentEvent == null) {
			logger.error("Unable to update. Event with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Event with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentEvent.setName(event.getName());

		eventsService.updateEvent(currentEvent);
		return new ResponseEntity<Event>(currentEvent, HttpStatus.OK);
	}

	// ------------------- Delete a Event-----------------------------------------

	@RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEvent(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Event with id {}", id);

		Event event = eventsService.findById(id);
		if (event == null) {
			logger.error("Unable to delete. Event with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Event with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		eventsService.deleteEventById(id);
		return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Events-----------------------------

	@RequestMapping(value = "/event/", method = RequestMethod.DELETE)
	public ResponseEntity<Event> deleteAllEvents() {
		logger.info("Deleting All Events");

		eventsService.deleteAllEvents();
		return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
	}

}