package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.Model;
import com.poe.javatos.service.crud.IServiceCommandeCrud;
import com.poe.javatos.service.crud.IServiceLigneCommandeCrud;
import com.poe.javatos.service.crud.ServiceCommandeCrudImpl;
import com.poe.javatos.service.crud.ServiceLigneCommandeCrudImpl;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.ServiceClientCrudImpl;
import com.poe.javatos.service.crud.IServiceUtilisateurCrud;
import com.poe.javatos.service.crud.ServiceUtilisateurCrudImpl;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.ServiceModelCrudImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsCRUDBeanLigneCommande{
    
	@Autowired
	IServiceLigneCommandeCrud daoLC;
	@Autowired
    IServiceCommandeCrud daoC;
	@Autowired
    IServiceClientCrud daoClient;
	@Autowired
    IServiceUtilisateurCrud daoUtilisateur;
	@Autowired
    IServiceModelCrud daoModel;
	
	
	
	@Test
    public void testCrudLignesCommande() {
		
		 
    
         
         // créer au moins 2 objet LigneCommande et les setter 
         LigneCommande lc10 = new LigneCommande();
         lc10.setId(1);
         lc10.setCommande(daoC.findByIdCommande(1)); 
         lc10.setStatut("StatutLC10");
         lc10.setModel(daoModel.findByIdModel(1));
         lc10.setQuantite(10);
         lc10.setNbResvervees(6);
         
         LigneCommande lc11 = new LigneCommande();
         lc11.setId(2);
         lc11.setCommande(daoC.findByIdCommande(1)); //si on la
         lc11.setStatut("StatutLC11");
         lc11.setModel(daoModel.findByIdModel(2));//model2 a créer ?
         lc11.setQuantite(11);
         lc11.setNbResvervees(7);
         
         LigneCommande lc20 = new LigneCommande();
         lc20.setId(3);
         lc20.setCommande(daoC.findByIdCommande(2)); //si on lance le test Commande en premier. 
         lc20.setStatut("StatutLC20");
         lc20.setModel(daoModel.findByIdModel(1));//model1 a créer ?
         lc20.setQuantite(20);
         lc20.setNbResvervees(16);
         
         LigneCommande lc21 = new LigneCommande();
         lc21.setId(4);
         lc21.setCommande(daoC.findByIdCommande(2)); //si on lance le test Commande en premier. 
         lc21.setStatut("StatutLC21");
         lc21.setModel(daoModel.findByIdModel(2));//model2 a créer ? 
         lc21.setQuantite(21);
         lc21.setNbResvervees(17);
         
         
         daoLC.createLigneCommande(lc10);
         daoLC.createLigneCommande(lc11);
         daoLC.createLigneCommande(lc20);
         daoLC.createLigneCommande(lc21);
         
         // test récupération de données
LigneCommande LCRecup10 = daoLC.findByIdLigneCommande(1);
         
         assertNotNull(LCRecup10);
         
         assertEquals(daoC.findByIdCommande(1).getId(),LCRecup10.getCommande().getId());
         assertEquals("StatutLC10",LCRecup10.getStatut());
         assertEquals(daoModel.findByIdModel(1).getId(),LCRecup10.getModel().getId());
         assertEquals(Integer.valueOf(10),LCRecup10.getQuantite());
         assertEquals(Integer.valueOf(6),LCRecup10.getNbResvervees());
               
LigneCommande LCRecup11 = daoLC.findByIdLigneCommande(2);
         
         assertNotNull(LCRecup11);
         
         assertEquals(daoC.findByIdCommande(1).getId(),LCRecup11.getCommande().getId());
         assertEquals("StatutLC11",LCRecup11.getStatut());
         assertEquals(daoModel.findByIdModel(2).getId(),LCRecup11.getModel().getId());
         assertEquals(Integer.valueOf(11),LCRecup11.getQuantite());
         assertEquals(Integer.valueOf(7),LCRecup11.getNbResvervees());

LigneCommande LCRecup20 = daoLC.findByIdLigneCommande(3);
         
         assertNotNull(LCRecup20);
         
         assertEquals(daoC.findByIdCommande(2).getId(),LCRecup20.getCommande().getId());
         assertEquals("StatutLC20",LCRecup20.getStatut());
         assertEquals(daoModel.findByIdModel(1).getId(),LCRecup20.getModel().getId());
         assertEquals(Integer.valueOf(20),LCRecup20.getQuantite());
         assertEquals(Integer.valueOf(16),LCRecup20.getNbResvervees());
         
LigneCommande LCRecup21 = daoLC.findByIdLigneCommande(4);
         
         assertNotNull(LCRecup21);
         
         assertEquals(daoC.findByIdCommande(2).getId(),LCRecup21.getCommande().getId());
         assertEquals("StatutLC21",LCRecup21.getStatut());
         assertEquals(daoModel.findByIdModel(2).getId(),LCRecup21.getModel().getId());
         assertEquals(Integer.valueOf(21),LCRecup21.getQuantite());
         assertEquals(Integer.valueOf(17),LCRecup21.getNbResvervees());

// next      
         LigneCommande lc10Modifie = lc10;
         lc10Modifie.setStatut("StatutModifieLc10");
         
         LigneCommande lc11Modifie = lc11;
         lc11Modifie.setStatut("StatutModifieLc11");
         
         LigneCommande lc20Modifie = lc20;
         lc20Modifie.setStatut("StatutModifieLc20");
         
         LigneCommande lc21Modifie = lc21;
         lc21Modifie.setStatut("StatutModifieLc21");
         
         daoLC.updateLigneCommande(lc10Modifie);
         daoLC.updateLigneCommande(lc11Modifie);
         daoLC.updateLigneCommande(lc20Modifie);
         daoLC.updateLigneCommande(lc21Modifie);
        
                
LigneCommande lCRecupModifie10 = daoLC.findByIdLigneCommande(1);
         
         assertNotNull(lCRecupModifie10);
         
         assertEquals(daoC.findByIdCommande(1).getId(),lCRecupModifie10.getCommande().getId());
         assertEquals("StatutModifieLc10",lCRecupModifie10.getStatut());
         assertEquals(daoModel.findByIdModel(1).getId(),lCRecupModifie10.getModel().getId());
         assertEquals(Integer.valueOf(10),lCRecupModifie10.getQuantite());
         assertEquals(Integer.valueOf(6),lCRecupModifie10.getNbResvervees());
         
LigneCommande lCRecupModifie11 = daoLC.findByIdLigneCommande(2);
         
         assertNotNull(lCRecupModifie11);
         
         assertEquals(daoC.findByIdCommande(1).getId(),lCRecupModifie11.getCommande().getId());
         assertEquals("StatutModifieLc11",lCRecupModifie11.getStatut());
         assertEquals(daoModel.findByIdModel(2).getId(),lCRecupModifie11.getModel().getId());
         assertEquals(Integer.valueOf(11),lCRecupModifie11.getQuantite());
         assertEquals(Integer.valueOf(7),lCRecupModifie11.getNbResvervees());
         
LigneCommande lCRecupModifie20 = daoLC.findByIdLigneCommande(3);
         
         assertNotNull(lCRecupModifie20);
         
         assertEquals(daoC.findByIdCommande(2).getId(),lCRecupModifie20.getCommande().getId());
         assertEquals("StatutModifieLc20",lCRecupModifie20.getStatut());
         assertEquals(daoModel.findByIdModel(1).getId(),lCRecupModifie20.getModel().getId());
         assertEquals(Integer.valueOf(20),lCRecupModifie20.getQuantite());
         assertEquals(Integer.valueOf(16),lCRecupModifie20.getNbResvervees());
         
LigneCommande lCRecupModifie21 = daoLC.findByIdLigneCommande(4);
         
         assertNotNull(lCRecupModifie21);
         
         assertEquals(daoC.findByIdCommande(2).getId(),lCRecupModifie21.getCommande().getId());
         assertEquals("StatutModifieLc21",lCRecupModifie21.getStatut());
         assertEquals(daoModel.findByIdModel(2).getId(),lCRecupModifie21.getModel().getId());
         assertEquals(Integer.valueOf(21),lCRecupModifie21.getQuantite());
         assertEquals(Integer.valueOf(17),lCRecupModifie21.getNbResvervees());
         
          
List<LigneCommande> allLigneCommande = daoLC.findAllLigneCommande();
         assertEquals(4, allLigneCommande.size());
       //get(0)  
         assertEquals(daoC.findByIdCommande(1).getId(),allLigneCommande.get(0).getCommande().getId());
         assertEquals("StatutModifieLc10",allLigneCommande.get(0).getStatut());
         assertEquals(daoModel.findByIdModel(1).getId(),allLigneCommande.get(0).getModel().getId());
         assertEquals(Integer.valueOf(10),allLigneCommande.get(0).getQuantite());
         assertEquals(Integer.valueOf(6),allLigneCommande.get(0).getNbResvervees());
         
       //get(1)
         assertEquals(daoC.findByIdCommande(1).getId(),allLigneCommande.get(1).getCommande().getId());
         assertEquals("StatutModifieLc11",allLigneCommande.get(1).getStatut());
         assertEquals(daoModel.findByIdModel(2).getId(),allLigneCommande.get(1).getModel().getId());
         assertEquals(Integer.valueOf(11),allLigneCommande.get(1).getQuantite());
         assertEquals(Integer.valueOf(7),allLigneCommande.get(1).getNbResvervees());
         
       //get(2)
         assertEquals(daoC.findByIdCommande(2).getId(),allLigneCommande.get(2).getCommande().getId());
         assertEquals("StatutModifieLc20",allLigneCommande.get(2).getStatut());
         assertEquals(daoModel.findByIdModel(1).getId(),allLigneCommande.get(2).getModel().getId());
         assertEquals(Integer.valueOf(20),allLigneCommande.get(2).getQuantite());
         assertEquals(Integer.valueOf(16),allLigneCommande.get(2).getNbResvervees());
         
       //get(3)
         assertEquals(daoC.findByIdCommande(2).getId(),allLigneCommande.get(3).getCommande().getId());
         assertEquals("StatutModifieLc21",allLigneCommande.get(3).getStatut());
         assertEquals(daoModel.findByIdModel(2).getId(),allLigneCommande.get(3).getModel().getId());
         assertEquals(Integer.valueOf(21),allLigneCommande.get(3).getQuantite());
         assertEquals(Integer.valueOf(17),allLigneCommande.get(3).getNbResvervees());
         
        
    }
    
}