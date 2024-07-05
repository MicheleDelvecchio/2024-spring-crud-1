package com.example.spring_test3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_test3.pojo.ContoBancario;
import com.example.spring_test3.repo.ContoBancarioRepo;

@Service
public class ContoBancarioService {

    @Autowired
    private ContoBancarioRepo contoBancarioRepo;

    public void save(ContoBancario c) {
        contoBancarioRepo.save(c);
    }

    public List<ContoBancario> getAllContoBancario() {

        return contoBancarioRepo.findAll();
    }

    public Optional<ContoBancario> getContoBancarioById(int id) {
        return contoBancarioRepo.findById(id);
    }

    public boolean delete(int id) {
        Optional<ContoBancario> conto = contoBancarioRepo.findById(id);
        if (conto.isPresent()) {
            contoBancarioRepo.delete(conto.get());
            return true;
        } else {
            throw new IllegalArgumentException("Conto non trovato");
        }
    }

}
