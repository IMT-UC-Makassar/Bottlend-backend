package com.rvm.rvm.repository;

import org.springframework.data.repository.CrudRepository;
import com.rvm.rvm.entity.User;

public interface UserRepository extends CrudRepository<User, String>{  
} 
