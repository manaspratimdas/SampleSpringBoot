package manas.springboot.sampe.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import manas.springboot.sampe.myapp.beans.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	public Account findByUsername(String username);
}
