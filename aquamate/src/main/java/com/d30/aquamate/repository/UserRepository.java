package com.d30.aquamate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.d30.aquamate.dao.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
