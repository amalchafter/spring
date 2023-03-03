package tn.esprit.ds.skin_amal_chafter.services;

import tn.esprit.ds.skin_amal_chafter.entities.Abonnement;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;

import java.util.List;

public interface IServiceAbonnement {

    List<Abonnement> retrieveAllAbonnement();
    Abonnement addAbonnement(Abonnement abonnement);

    Abonnement updateAbonnement (Abonnement abonnement);
    void removeAbonnement (Long numAbon);
    Abonnement retrieveAbonnement (Long numAbon);
}
