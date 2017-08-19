package manas.springboot.sampe.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import manas.springboot.sampe.myapp.beans.User;
import manas.springboot.sampe.myapp.service.HeaService;

@RestController
@RequestMapping("/hea")
public class HeaController {
	
	@Autowired
	HeaService heaService;
	
	@RequestMapping(value = "/display/{id}", method = RequestMethod.GET)
	public User displayUser(@PathVariable Long id) {

		return heaService.getUserById(id);
	}

}
