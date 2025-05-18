package tn.crudtp1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.crudtp1.entities.Produit;
import tn.crudtp1.services.ProduitService;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class ProduitRESTController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/all")
    public List<Produit> findAll() {
        return produitService.getAllProduits();
    }
    @GetMapping("/{id}")
    public Produit findById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    @PostMapping("/create")
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }

    @PutMapping("{id}/update")
    public Produit updateProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }


}
