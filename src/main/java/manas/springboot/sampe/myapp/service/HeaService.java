package manas.springboot.sampe.myapp.service;

import manas.springboot.sampe.myapp.beans.User;

public interface HeaService {

	public User getUserById(Long id);
	
	public void getAllUser();
	
}
