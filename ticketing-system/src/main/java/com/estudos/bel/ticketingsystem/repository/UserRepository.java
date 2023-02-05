package com.estudos.bel.ticketingsystem.repository;

import com.estudos.bel.ticketingsystem.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
