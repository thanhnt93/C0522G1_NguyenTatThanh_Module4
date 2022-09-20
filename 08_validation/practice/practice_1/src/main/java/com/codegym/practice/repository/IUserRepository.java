package com.codegym.practice.repository;

import com.codegym.practice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository <User,Integer>{
}
