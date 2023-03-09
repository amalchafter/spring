package tn.esprit.ds.skin_amal_chafter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.services.IServiceSkieur;
import tn.esprit.ds.skin_amal_chafter.services.ServiceSkieur;

import java.util.List;

@RestController
@RequestMapping("/skieur")
public class
SkieurController {
    @Autowired
    IServiceSkieur sk;
    //localhost:9090/retrieveAllSkieurs
    @GetMapping
    public List<Skieur> getall()
    {
        return sk.retrieveAllSkieurs();
    }
    @GetMapping("{numSkieur}")
    public  Skieur retrieveSkieur (@PathVariable Long numSkieur)
    {
        return sk.retrieveSkieur(numSkieur);
    }
    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur skieur)
    {
       return  sk.addSkieur(skieur);
    }

    @PutMapping
    public Skieur updateSkieur (@RequestBody Skieur skieur)
    {
        return sk.updateSkieur(skieur);
    }

    @DeleteMapping("{numSkieur}")
    public void removeSkieur (@PathVariable Long numSkieur)
    {
        sk.removeSkieur(numSkieur);
    }

    @PutMapping("{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable Long numSkieur, @PathVariable Long numPiste)
    {
        return sk.assignSkierToPiste(numSkieur,numPiste);
    }
}
