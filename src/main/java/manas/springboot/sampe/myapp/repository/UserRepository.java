package manas.springboot.sampe.myapp.repository;

import org.springframework.data.repository.Repository;

import manas.springboot.sampe.myapp.beans.Product;
import manas.springboot.sampe.myapp.beans.User;

public interface UserRepository  extends Repository<User,Long>{

	
	Product findById(Long id);
}
