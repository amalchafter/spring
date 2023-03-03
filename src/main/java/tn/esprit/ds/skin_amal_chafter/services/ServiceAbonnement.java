package tn.esprit.ds.skin_amal_chafter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skin_amal_chafter.entities.Abonnement;
import tn.esprit.ds.skin_amal_chafter.repositories.AbonnementRepository;

import java.util.List;

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
}
