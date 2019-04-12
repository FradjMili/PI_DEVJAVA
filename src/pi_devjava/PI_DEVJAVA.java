/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_devjava;

import Entities.Annonce;
import Entities.Demande;
import Service.ServiceAnnonce;
import Service.ServiceDemande;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author USER
 */
public class PI_DEVJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            Annonce a1=new Annonce(1,"speciality","description","titre",500,1);
            Date dated=new Date(2018, 5, 6);
            int year =2018-1900;
              Date datef=new Date(year, 0,20);
              
              
SimpleDateFormat formmat1 = new SimpleDateFormat("yyyy/MM/dd");

String formatterdf = formmat1.format(datef);

        System.out.println(formatterdf);    

            Annonce a2 = new Annonce(1, 20, "speciality", formatterdf, formatterdf, "description", "titre", 5, 6);
      ServiceAnnonce ser1=new ServiceAnnonce();
      ser1.AjouterAnnonce(a2);
//      int year=2015;
//      year=year-1900;
//        System.out.println(new Date(year, 5, 6));
//      
      
       //ser1.SupprimerAnnonce(36);
//ser1.modifierAnnonce(50, "aa", "description", "titre", 50, 0);
//ser1.afficherAnnonce();

//------------------
Demande d1=new Demande( 10 ,  11 ,  12,  "String", 1 , "String");
 ServiceDemande dem1=new ServiceDemande();
 //dem1.AjouterDemande(d1);
 //dem1.SupprimerDemande(25);
//dem1.modifierDemande( 10 ,  11 ,  12,  "titre", 1 , "titre");
//dem1.afficherDemande();

//        System.out.println(ser1.listAnnonce());
    }
    
}
