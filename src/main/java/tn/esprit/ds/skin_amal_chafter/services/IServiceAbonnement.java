package tn.esprit.ds.skin_amal_chafter.services;

import tn.esprit.ds.skin_amal_chafter.entities.Abonnement;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.entities.TypeAbonnement;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IServiceAbonnement {

    List<Abonnement> retrieveAllAbonnement();
    Abonnement addAbonnement(Abonnement abonnement);

    Abonnement updateAbonnement (Abonnement abonnement);
    void removeAbonnement (Long numAbon);
    Abonnement retrieveAbonnement (Long numAbon);

    Set<Abonnement> getSubscriptionByType(TypeAbonnement typeAbon);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate dateDebut, LocalDate dateFin);
}
