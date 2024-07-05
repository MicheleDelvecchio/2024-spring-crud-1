package com.example.spring_test3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_test3.pojo.ContoBancario;

@Repository
public interface ContoBancarioRepo extends JpaRepository<ContoBancario, Integer> {

}
