package tn.esprit.ds.skin_amal_chafter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skin_amal_chafter.entities.Piste;
import tn.esprit.ds.skin_amal_chafter.services.IServicePiste;

import java.util.List;

@RestController
@RequestMapping("/piste")
public class PisteController {
    @Autowired
    IServicePiste p;
    @GetMapping
    public List<Piste> getAll()
    {
        return p.retrieveAllPistes();
    }

    @PostMapping
    public Piste add(@RequestBody Piste piste)
    {
        return p.addPiste(piste);
    }

    @PutMapping
    public Piste update(@RequestBody Piste piste)
    {
        return p.updatePiste(piste);
    }

    @DeleteMapping("{numpiste}")
    public void update(@PathVariable long numpiste)
    {
        p.removePiste(numpiste);
    }

    @GetMapping("{nummpiste}")
    public Piste getById(@PathVariable long numpiste)
    {
        return p.retrievePiste(numpiste);
    }
}
