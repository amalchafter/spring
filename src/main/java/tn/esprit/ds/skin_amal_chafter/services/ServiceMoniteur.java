package tn.esprit.ds.skin_amal_chafter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skin_amal_chafter.entities.Moniteur;
import tn.esprit.ds.skin_amal_chafter.repositories.MoniteurRepository;

import java.util.List;

@Service
public class ServiceMoniteur implements IServiceMoniteur{
    @Autowired
    MoniteurRepository m;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
         return m.findAll();

    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return m.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return m.save(moniteur);
    }

    @Override
    public void removeMoniteur(Long numMoniteur) {
        m.deleteById(numMoniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return m.findById(numMoniteur).orElse(null);
    }
}
