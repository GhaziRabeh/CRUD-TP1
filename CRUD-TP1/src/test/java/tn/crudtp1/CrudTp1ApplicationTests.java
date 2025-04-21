package tn.crudtp1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.crudtp1.entities.Produit;
import tn.crudtp1.repos.ProduitRepository;

import java.util.Date;
import java.util.List;

@SpringBootTest
class CrudTp1ApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	@Test
	public void testCreateProduit(){
		Produit produit = new Produit("PC Dell",2200.500,new Date());
		produitRepository.save(produit);
	}

	@Test
	public void findAllProduits(){
		List<Produit> produits = produitRepository.findAll();

		for (Produit produit : produits) {
			System.out.println(produit);
		}
	}

	@Test
	public void findProduitById(){
		Produit produit = produitRepository.findById(1L).get();
		System.out.println(produit);

	}
	@Test
	public void updateProduit(){
		Produit produit = produitRepository.findById(1L).get();
		produit.setPrix(100.00);
		produitRepository.save(produit);
	}

	@Test
	public void deleteProduit(){
		Produit produit =produitRepository.findById(1L).get();
		produitRepository.delete(produit);
	}



}
