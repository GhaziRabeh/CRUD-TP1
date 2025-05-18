package tn.crudtp1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.crudtp1.entities.Category;
import tn.crudtp1.entities.Produit;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);



    @Query("select p from Produit p where p.nomProduit like %:nom and p.prix > :prix")
    List<Produit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);


    @Query("select p from Produit p where p.categorie = ?1")
    List<Produit> findByCategorie (Category categorie);

    List<Produit> findByOrderByNomProduitAsc();

    @Query("select p from Produit p order by p.nomProduit ASC, p.prix DESC")
    List<Produit> trierProduitsNomsPrix ();

    List<Produit> findByCategorieIdCat(Long id);
}
