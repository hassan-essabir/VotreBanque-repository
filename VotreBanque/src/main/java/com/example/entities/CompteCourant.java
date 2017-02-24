package com.example.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	private double devouvert;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(String codeCompte, Date dateCreation, double solde,
			Client client, double devouvert) {
		super(codeCompte, dateCreation, solde, client);
		this.devouvert = devouvert;
	}

	public double getDevouvert() {
		return devouvert;
	}

	public void setDevouvert(double devouvert) {
		this.devouvert = devouvert;
	}

}
