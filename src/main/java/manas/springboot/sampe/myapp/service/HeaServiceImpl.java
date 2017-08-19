package manas.springboot.sampe.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manas.springboot.sampe.myapp.beans.User;
import manas.springboot.sampe.myapp.repository.UserRepository;

@Service("heaService")
public class HeaServiceImpl implements HeaService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(Long id) {
	
		return userRepository.findById(id);
	}

	@Override
	public void getAllUser() {
		
		
	}

}
