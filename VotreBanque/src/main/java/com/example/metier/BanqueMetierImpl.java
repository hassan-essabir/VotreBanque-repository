package com.example.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CompteRepository;
import com.example.dao.OperationRepository;
import com.example.entities.Compte;
import com.example.entities.CompteCourant;
import com.example.entities.Operation;
import com.example.entities.Retrait;
import com.example.entities.Versement;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp = compteRepository.findOne(codeCpte);
		if (cp == null)
			throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		double facilitescaisse = 0;
		if (cp instanceof CompteCourant)
			facilitescaisse = ((CompteCourant) cp).getDevouvert();
		if (cp.getSolde() + facilitescaisse < montant)
			throw new RuntimeException("Solde insuffisant");
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);

	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		if (codeCpte1.equals(codeCpte2))
			throw new RuntimeException("Impossible d'effectuer le virement sur le meme compte");
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);

	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		// TODO Auto-generated method stub
		return operationRepository.listOperation(codeCpte, new PageRequest(
				page, size));
	}

}
