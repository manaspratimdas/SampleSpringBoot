package manas.springboot.sampe.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import manas.springboot.sampe.myapp.beans.Event;

@Repository
public interface EventsRepository extends JpaRepository<Event, Long> {

    Event findByName(String name);
    
}
