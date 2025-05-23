package tn.crudtp1.services;

import org.springframework.data.domain.Page;
import tn.crudtp1.entities.Category;
import tn.crudtp1.entities.Produit;

import java.util.List;

public interface ProduitService {
    Produit saveProduit(Produit p);
    Produit updateProduit(Produit p);
    void deleteProduit(Produit p);
    void deleteProduitById(Long id);
    Produit getProduit(Long id);
    List<Produit> getAllProduits();
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
    List<Produit> findByNomPrix (String nom, Double prix);
    List<Produit> findByCategorie (Category categorie);
    List<Produit> findByCategorieIdCat(Long id);
    List<Produit> findByOrderByNomProduitAsc();
    List<Produit> trierProduitsNomsPrix();
    //Page<Produit> getAllProduitsParPage(int page, int size);


    Page<Produit> getProduitsPage(int page, int size);

    Page<Produit> getAllProduitsParPage(int i, int i1);
}
