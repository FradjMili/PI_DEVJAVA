/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservices;

import entities.FosUser;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface IUserServices {
    public interface IPersonneService {
    
    public void ajoutUtilisateur(FosUser p);
    public void updateUtilisateur(FosUser p);
    public void supprimerUtilisateur(FosUser p);
    public ArrayList<FosUser> afficherUtilisateur();

}
}
