package com.vinay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
