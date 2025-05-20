package tn.crudtp1.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.crudtp1.entities.Produit;
import tn.crudtp1.services.ProduitService;

import java.text.ParseException;
import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @RequestMapping("/myView")
    public String myView()
    {
        return "myView";
    }

    @RequestMapping("/listProduit")
    public String listProduit(ModelMap modelMap,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "5") int size) {

        Page<Produit> produitPage = produitService.getProduitsPage(page, size);

        modelMap.addAttribute("produits", produitPage.getContent());
        modelMap.addAttribute("pages", produitPage.getTotalPages());
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        modelMap.addAttribute("lastPage", produitPage.getTotalPages() > 0 ? produitPage.getTotalPages() - 1 : 0);

        return "listProduit";
    }




    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("produit", new Produit());
        return "createProduit";
    }

    @RequestMapping("/saveProduit")
    public String saveProduit(@Valid @ModelAttribute("produit") Produit produit,
                              BindingResult result,
                              ModelMap modelMap) throws ParseException {
        if (result.hasErrors()) return "createProduit";
        Produit saveProduit = produitService.saveProduit(produit);
        String msg = "produit enregistré avec Id " + saveProduit.getIdProduit();
        modelMap.addAttribute("msg", msg);
        return "redirect:/listProduit";
    }
    @RequestMapping("/supprimerProduit")
    public String supprimerProduit(@RequestParam("id") Long id,
                                   ModelMap modelMap)
    {
        produitService.deleteProduitById(id);
        List<Produit> prods = produitService.getAllProduits();
        modelMap.addAttribute("produits", prods);
        return "redirect:/listProduit";
    }
    @RequestMapping("/modifierProduit")
    public String editerProduit(@RequestParam("id") Long id,
                                ModelMap modelMap
                                )
    {
        Produit p= produitService.getProduit(id);
        modelMap.addAttribute("produit", p);
        return "editerProduit";
    }
    @RequestMapping("/updateProduit")
    public String updateProduit(@Valid @ModelAttribute("produit") Produit produit,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "editerProduit";
        }

        produitService.updateProduit(produit);
        return "redirect:/listProduit";
    }


}


