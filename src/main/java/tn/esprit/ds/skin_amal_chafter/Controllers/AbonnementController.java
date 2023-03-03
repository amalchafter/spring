package tn.esprit.ds.skin_amal_chafter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skin_amal_chafter.entities.Abonnement;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.services.IServiceAbonnement;
import tn.esprit.ds.skin_amal_chafter.services.IServiceSkieur;

import java.util.List;

@RestController
@RequestMapping("/abonnement")
public class AbonnementController {
    @Autowired
    IServiceAbonnement a;
    //localhost:9090/retrieveAllSkieurs
    @GetMapping
    public List<Abonnement> getall()
    {
        return a.retrieveAllAbonnement();
    }
    @GetMapping("{numAbon}")
    public  Abonnement retrieveAbonnement (@PathVariable Long numAbon)
    {
        return a.retrieveAbonnement(numAbon);
    }
    @PostMapping
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement)
    {
        return  a.addAbonnement(abonnement);
    }

    @PutMapping
    public Abonnement updateAbonnement (@RequestBody Abonnement abonnement)
    {
        return a.updateAbonnement(abonnement);
    }

    @DeleteMapping("{numAbon}")
    public void removeAbonnement (@PathVariable Long numAbon)
    {
        a.removeAbonnement(numAbon);
    }
}
