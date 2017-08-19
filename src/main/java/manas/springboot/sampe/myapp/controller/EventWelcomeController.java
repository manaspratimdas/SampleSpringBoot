package manas.springboot.sampe.myapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventWelcomeController {

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", "welcome");
		return "welcome";
	}
	
	@RequestMapping("/addEvent")
	public String addEvent(Map<String, Object> model) {
		model.put("message", "addevent");
		return "addEvent";
	}

	@RequestMapping("/listEvent")
	public String listEvent(Map<String, Object> model) {
		model.put("message", "addevent");
		return "listEvent";
	}
	@RequestMapping("/eventCreated")
	public String eventCreated(Map<String, Object> model) {
		model.put("message", "addevent");
		return "eventCreated";
	}
}