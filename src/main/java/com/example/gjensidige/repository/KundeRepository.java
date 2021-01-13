package com.example.gjensidige.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gjensidige.model.*;

@Repository
public interface KundeRepository extends JpaRepository<Kunde, Long>{

}