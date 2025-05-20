package tn.crudtp1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import tn.crudtp1.entities.Category;
import tn.crudtp1.entities.Produit;
import tn.crudtp1.repos.ProduitRepository;
import tn.crudtp1.services.ProduitService;

import java.util.Date;
import java.util.List;

@SpringBootTest
class CrudTp1ApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private ProduitService produitService;
/*
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
/*
	@Test
	public void deleteProduit(){
		Produit produit =produitRepository.findById(1L).get();
		produitRepository.delete(produit);
	}

 */
@Test
	public void testFindByNomProduit () {
	List<Produit> produits = produitRepository.findByNomProduit("PC Acer");
	for (Produit p : produits) {
		System.out.println(p);
	}
}
	@Test
	public void testFindByNomProduitContaine () {
		List<Produit> produits = produitRepository.findByNomProduitContains("PC");
		for (Produit p : produits) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByNomPrix()
	{
		List<Produit> prods = produitRepository.findByNomPrix("Pc Acer", 2000.0);
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testfindByCategorie()
	{
		Category cat = new Category();
		cat.setIdCat(1L);
		List<Produit> prods = produitRepository.findByCategorie(cat);
		for (Produit p : prods)
		{
			System.out.println(p);
		}


	}
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
		List<Produit> prods =
				produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}

	@Test
	public void testTrierProduitsNomsPrix()
	{
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testFindByNomProduitContains()
	{
		Page<Produit> prods = produitService.getAllProduitsParPage(0,2);
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getTotalPages());
		prods.getContent().forEach(p -> {System.out.println(p.toString());
		});
	}

}
