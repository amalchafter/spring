package tn.esprit.ds.skin_amal_chafter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skin_amal_chafter.entities.Abonnement;
import tn.esprit.ds.skin_amal_chafter.entities.TypeAbonnement;
import tn.esprit.ds.skin_amal_chafter.repositories.AbonnementRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service

public class ServiceAbonnement implements  IServiceAbonnement{
    @Autowired
    AbonnementRepository a;
    @Override
    public List<Abonnement> retrieveAllAbonnement() {
        return a.findAll();
    }

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return a.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return a.save(abonnement);
    }

    @Override
    public void removeAbonnement(Long numAbon) {
        a.deleteById(numAbon);
    }

    @Override
    public Abonnement retrieveAbonnement(Long numAbon) {
        return a.findById(numAbon).orElse(null);
    }

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement typeAbon) {
        return a.findAbonnementByTypeAbon(typeAbon);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate dateDebut, LocalDate dateFin) {
        return a.findAbonnementByDateDabutAndDateFin(dateDebut,dateFin);
    }
}
