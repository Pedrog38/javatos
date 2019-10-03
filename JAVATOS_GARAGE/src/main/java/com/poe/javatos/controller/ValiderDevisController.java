package com.poe.javatos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.form.DevisForm;
import com.poe.javatos.form.ListeDevisAValiderForm;
import com.poe.javatos.form.ListeDevisForm;
import com.poe.javatos.mapper.ListeDevisAValiderMapper;
import com.poe.javatos.mapper.DevisMapper;
import com.poe.javatos.mapper.ListeDevisMapper;
import com.poe.javatos.service.IServiceDevis;

@Controller
@RequestMapping(value = {"/commercial/","/admin/"})
public class ValiderDevisController {

	
	
	@Autowired
	private IServiceDevis serviceDevis;
	
	@Autowired
	AfficherListeLignesDevisController ctrlAfficheLigneDevis;
	
	@GetMapping(value="/DevisValidation")
	public String afficherDevisAValider(final ModelMap model) 
	{			
		final List<Devis> listNouveauxDevis = serviceDevis.findByStatutNouveauDevis();
		List<DevisForm> listDevisForms = new ArrayList<>();
		for (Devis devis : listNouveauxDevis) 
		{
			float prixHT = serviceDevis.calculerPrixHTDevis(devis);
			float prixTTC = serviceDevis.calculerPrixTTCDevis(devis);
			Integer delai =serviceDevis.calculerDelaisDevis(devis);
			DevisForm devisForm = DevisMapper.remplirDevisForm(devis, prixHT, prixTTC, delai);		
			listDevisForms.add(devisForm);
		}
		final ListeDevisAValiderForm listeDevisForm = ListeDevisAValiderMapper.remplirListeDevisAVForm(listDevisForms);
		model.addAttribute("listeDevisValiderForm", listeDevisForm);
		
		return "validerDevis";
	}

	@PostMapping(value="/TraiterDevisAV")
	public String traiterListeDevis(@Valid @ModelAttribute(value="listeDevisValiderForm") 
	 final ListeDevisAValiderForm listeDevisForm,final BindingResult bindingResult, final ModelMap model)
	{
		return serviceDevis.traiterDevis(listeDevisForm, model);
	}

}

	
	
	

