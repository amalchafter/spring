package tn.esprit.ds.skin_amal_chafter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skin_amal_chafter.entities.Piste;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.repositories.PisteRepository;

import java.util.List;

@Service
public class ServicePiste implements IServicePiste{
    @Autowired
    PisteRepository p;
    @Override
    public List<Piste> retrieveAllPistes() {
       return  p.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return p.save(piste);

    }

    @Override
    public Piste updatePiste(Piste piste) {
        return p.save(piste);
    }

    @Override
    public void removePiste(Long numPiste) {
      p.deleteById(numPiste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return p.findById(numPiste).orElse(null);
    }
}
