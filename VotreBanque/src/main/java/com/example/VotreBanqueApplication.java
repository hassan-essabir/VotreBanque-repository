package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dao.ClientRepository;
import com.example.dao.CompteRepository;
import com.example.dao.OperationRepository;
import com.example.entities.Client;
import com.example.entities.Compte;
import com.example.entities.CompteCourant;
import com.example.entities.CompteEpargne;
import com.example.entities.Operation;
import com.example.entities.Retrait;
import com.example.entities.Versement;
import com.example.metier.IBanqueMetier;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;

	public static void main(String[] args) {
		SpringApplication.run(VotreBanqueApplication.class, args);
		// ClientRepository clientRepository =
		// ctx.getBean(ClientRepository.class);
		// clientRepository.save(new Client("Hassan", "hassan@gmail.com"));
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*
		Client c1 = clientRepository.save(new Client("Hassan",
				"hassan@gmail.com"));
		Client c2 = clientRepository.save(new Client("Rachid",
				"rachid@gmail.com"));

		Compte cp1 = compteRepository.save(new CompteCourant("c1", new Date(),
				9000, c1, 6000));
		Compte cp2 = compteRepository.save(new CompteEpargne("c2", new Date(),
				6000, c2, 5.5));

		operationRepository.save(new Versement(new Date(), 9000, cp1));
		operationRepository.save(new Versement(new Date(), 6000, cp1));
		operationRepository.save(new Versement(new Date(), 2300, cp1));
		operationRepository.save(new Retrait(new Date(), 9000, cp1));

		operationRepository.save(new Versement(new Date(), 2300, cp2));
		operationRepository.save(new Versement(new Date(), 400, cp2));
		operationRepository.save(new Versement(new Date(), 2300, cp2));
		operationRepository.save(new Retrait(new Date(), 3000, cp2));
		
		banqueMetier.verser("c1", 111111);
		*/
	}
}
