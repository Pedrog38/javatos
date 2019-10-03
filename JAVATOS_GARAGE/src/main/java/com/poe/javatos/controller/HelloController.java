package com.poe.javatos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.poe.javatos.bean.Client;
import com.poe.javatos.service.crud.IServiceClientCrud;
@RestController
public class HelloController {
    @Autowired
    IServiceClientCrud serviceClient;
    
    @GetMapping("/helloo")
   String salutToutLeMonde()
   {
       return "Hello the world";
   }
   @GetMapping(value="/helloClient", produces = "application/json")
   public Client helloClient()
   {
       Client c = new Client();
       c.setId(1);
       c.setNom("Fucking Awesome");
       c.setPrenom("Adèle");
       return c;
   }
   @GetMapping(value="/helloClient/{id}", produces = "application/json")
   public Client helloClientId(@PathVariable(value = "id") Integer idClient)
   {
       Client c = new Client();
       c.setId(idClient);
       c.setNom("Fucking Awesome");
       c.setPrenom("Adèle");
       return c;
   }
   @GetMapping(value="/helloClientReel/{id}", produces = "application/json")
   public Client helloClientIdReel(@PathVariable(value = "id") Integer idClient)
   {
       Client c = serviceClient.findByIdClient(idClient);
       return c;
   }
   @GetMapping(value="/helloClientReelException/{id}", produces = "application/json")
   public @ResponseBody ResponseEntity<Client> helloClientIdReelException(@PathVariable(value = "id") Integer idClient)
   {
       try
       {            
           Client c = serviceClient.findByIdClient(idClient);
           return ResponseEntity.ok().body(c);
       }
       catch(Exception e)
       {
           return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
           //return ResponseEntity.badRequest().body(null);
       }
   }
}
