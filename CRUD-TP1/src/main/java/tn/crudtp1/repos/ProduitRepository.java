package tn.crudtp1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.crudtp1.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
