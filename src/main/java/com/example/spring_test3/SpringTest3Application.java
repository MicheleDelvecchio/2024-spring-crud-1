package com.example.spring_test3;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring_test3.pojo.ContoBancario;
import com.example.spring_test3.service.ContoBancarioService;

@SpringBootApplication
public class SpringTest3Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringTest3Application.class, args);
    }

    @Autowired
    private ContoBancarioService cbs;

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("------------CONTO 1---------------");
            ContoBancario cb1 = new ContoBancario();

            cb1.deposito(32);
            cb1.deposito(21);
            cb1.prelievo(32);
            cbs.save(cb1);
            System.out.println(cb1);

            System.out.println("------------CONTO 2---------------");
            ContoBancario cb2 = new ContoBancario();

            cb2.deposito(421);
            cb2.prelievo(321);
            cbs.save(cb2);
            System.out.println(cb2);

            System.out.println("------------CONTO 3---------------");
            ContoBancario cb3 = new ContoBancario();
            cbs.save(cb3);
            System.out.println(cb3);

            System.out.println("------------STAMPO TUTTI I CONTI--------------");
            cbs.getAllContoBancario().forEach(System.out::println); //RES.3 

            Optional<ContoBancario> oldCBOpt = cbs.getContoBancarioById(2);

            if (oldCBOpt.isEmpty()) {
                System.out.println("Conto non esistente!");
                return;
            }
            ContoBancario oldCB = oldCBOpt.get();
            System.out.println(oldCB);
            oldCB.setId(0);
            cbs.save(oldCB);

            // ELIMINO UN CONTO
            Optional<ContoBancario> delCB = cbs.getContoBancarioById(3);
            if (delCB.isEmpty()) {
                System.out.println("Conto non esistente!");
                return;
            }
            cbs.delete(3);

            System.out.println("------------STAMPO TUTTI I CONTI--------------");
            cbs.getAllContoBancario().forEach(System.out::println); //RES.2

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}

/**
 * REPO: 2024-spring-crud-1
 *
 * TODO:
 *
 * Generare nuovo progetto SpringBoot, e, dopo aver importato le dipendenze per
 * il db collegare correttamente il progetto a nuovo db tramite DbEaver.
 *
 * Creare l'entita' ContoBancario descritta come segue: Questa classe
 * rappresenta un conto bancario. Un conto bancario ha un saldo iniziale di 0.
 * Un conto bancario può essere incrementato o decrementato. Se si tenta di
 * prelevare più di quanto si ha, viene lanciata un'eccezione. Se si tenta di
 * depositare un importo negativo, viene lanciata un'eccezione.
 *
 * Dopo aver definito e testato la classe, aggiungere le annotazioni per
 * renderla una tabella del db.
 *
 * Dopo aver verificato il corretto funzionamento, predisporre repository e
 * service per le 4 operazioni di CRUD (Create, Read, Update, Delete).
 *
 * Testare adeguatamente la classe pura e tutte le operazini di CRUD all'interno
 * del metodo run della classe principale (Application) dopo aver opportunamente
 * implementato l'interfaccia CommandLineRunner.
 *
 */
