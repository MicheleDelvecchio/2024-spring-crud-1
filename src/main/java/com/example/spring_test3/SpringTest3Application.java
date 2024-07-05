package com.example.spring_test3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTest3Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringTest3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello!");

    }

}

/**
 * REPO:
 * 2024-spring-crud-1
 * 
 * TODO:
 * 
 * Generare nuovo progetto SpringBoot, e, dopo aver importato le dipendenze per il db
 * collegare correttamente il progetto a nuovo db tramite DbEaver.
 * 
 * Creare l'entita' ContoBancario descritta come segue:
 * Questa classe rappresenta un conto bancario. 
 * Un conto bancario ha un saldo iniziale di 0. 
 * Un conto bancario può essere incrementato o decrementato. 
 * Se si tenta di prelevare più di quanto si ha, viene lanciata un'eccezione. 
 * Se si tenta di depositare un importo negativo, viene lanciata un'eccezione.
 * 
 * Dopo aver definito e testato la classe, aggiungere le annotazioni per renderla
 * una tabella del db.
 * 
 * Dopo aver verificato il corretto funzionamento, predisporre repository e service
 * per le 4 operazioni di CRUD (Create, Read, Update, Delete).
 * 
 * Testare adeguatamente la classe pura e tutte le operazini di CRUD all'interno del
 * metodo run della classe principale (Application) dopo aver opportunamente 
 * implementato l'interfaccia CommandLineRunner.
 * 
 */
