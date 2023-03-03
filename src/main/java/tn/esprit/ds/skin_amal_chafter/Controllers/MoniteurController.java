package tn.esprit.ds.skin_amal_chafter.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skin_amal_chafter.entities.Moniteur;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.services.IServiceMoniteur;

import java.util.List;

@RestController
@RequestMapping("/moniteur")
public class MoniteurController {
    @Autowired
    IServiceMoniteur m;

    @GetMapping
    public List<Moniteur> getall()

    {
        return m.retrieveAllMoniteurs();
    }
    @GetMapping("{numMoniteur}")
    public  Moniteur retrieveMoniteur (@PathVariable Long numMoniteur)
    {
        return m.retrieveMoniteur(numMoniteur);
    }
    @PostMapping
    public Moniteur addMoniteur (@RequestBody Moniteur moniteur)
    {
        return  m.addMoniteur(moniteur);
    }

    @PutMapping
    public Moniteur updateMoniteur (@RequestBody Moniteur moniteur)
    {
        return m.updateMoniteur(moniteur);
    }

    @DeleteMapping("{numMoniteur}")
    public void removeMoniteur (@PathVariable Long numMoniteur)
    {
        m.removeMoniteur(numMoniteur);
    }
}
