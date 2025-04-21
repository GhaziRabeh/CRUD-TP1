package tn.crudtp1.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.crudtp1.entities.Produit;
import tn.crudtp1.repos.ProduitRepository;

import java.util.List;

public class ProduitServiceImpl extends ProduitService{

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }


    @Override
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }


    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }


    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }


    @Override
    public void deleteProduitById(Long id){
     produitRepository.deleteById(id);
    }
    @Override
    public void deleteProduit(Produit produit) {
        produitRepository.delete(produit);
    }
}
