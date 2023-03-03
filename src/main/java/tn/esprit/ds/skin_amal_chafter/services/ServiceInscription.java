package tn.esprit.ds.skin_amal_chafter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skin_amal_chafter.entities.Inscription;
import tn.esprit.ds.skin_amal_chafter.repositories.InscriptionRepository;

import java.util.List;

@Service

public class ServiceInscription implements IServiceInscription{
    @Autowired
    InscriptionRepository i;
    @Override
    public List<Inscription> retrieveAllInscription() {
        return i.findAll();
    }

    @Override
    public Inscription addInscription(Inscription inscription) {
        return i.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return i.save(inscription);
    }

    @Override
    public void removeinscription(Long numInscription) {
        i.deleteById(numInscription);
    }

    @Override
    public Inscription retrieveInscription(Long numInscription) {
        return i.findById(numInscription).orElse(null);
    }
}
