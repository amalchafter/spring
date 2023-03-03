package tn.esprit.ds.skin_amal_chafter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skin_amal_chafter.entities.Inscription;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.services.IServiceInscription;
import tn.esprit.ds.skin_amal_chafter.services.IServiceSkieur;

import java.util.List;

@RestController
@RequestMapping("/insription")
public class InscriptionController {
    @Autowired
    IServiceInscription i;
    //localhost:9090/retrieveAllSkieurs
    @GetMapping
    public List<Inscription> getall()
    {
        return i.retrieveAllInscription();
    }
    @GetMapping("{numInscription}")
    public  Inscription retrieveInscription (@PathVariable Long numInscription)
    {
        return i.retrieveInscription(numInscription);
    }
    @PostMapping
    public Inscription addInscription(@RequestBody Inscription inscription)
    {
        return  i.addInscription(inscription);
    }

    @PutMapping
    public Inscription updateInscription (@RequestBody Inscription inscription)
    {
        return i.updateInscription(inscription);
    }

    @DeleteMapping("{numInscription}")
    public void removeInscription (@PathVariable Long numInscription)
    {
        i.removeinscription(numInscription);
    }
}
