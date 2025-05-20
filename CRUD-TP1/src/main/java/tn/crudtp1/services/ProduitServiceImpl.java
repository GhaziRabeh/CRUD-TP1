package tn.crudtp1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.crudtp1.entities.Category;
import tn.crudtp1.entities.Produit;
import tn.crudtp1.repos.ProduitRepository;

import java.util.List;

@Service
public class  ProduitServiceImpl implements ProduitService  {

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
    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }
    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepository.findByNomProduitContains(nom);
    }
    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }
    @Override
    public List<Produit> findByCategorie(Category categorie) {
        return produitRepository.findByCategorie(categorie);
    }
    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return produitRepository.findByCategorieIdCat(id);
    }
    @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitRepository.findByOrderByNomProduitAsc();
    }
    @Override
    public List<Produit> trierProduitsNomsPrix() {
        return produitRepository.trierProduitsNomsPrix();
    }

    @Override
    public Page<Produit> getProduitsPage(int page, int size) {
        return produitRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public  Page<Produit> getAllProduitsParPage(int i, int i1) {
        return produitRepository.findAll(PageRequest.of(i, i1));
    }


}
