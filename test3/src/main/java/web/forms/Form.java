/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.forms;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.Metier;
import Trame.*;
import org.primefaces.context.RequestContext;

@ManagedBean
@RequestScoped
public class Form implements Serializable {

    private Metier metier = new Metier();
    private TrameLidar trameLidar;
    private TrameGPS trameGPS;
    private RequestContext context = RequestContext.getCurrentInstance();
    private String adresse = ""; 
    
    public TrameLidar getTrameLidar() {
        return trameLidar;
    }

    public void setTrameLidar(TrameLidar trameLidar) {
        this.trameLidar = trameLidar;
    }

    public TrameGPS getTrameGPS() {
        return trameGPS;
    }

    public void setTrameGPS(TrameGPS trameGPS) {
        this.trameGPS = trameGPS;
    }

    public void lectureTrames(){
        trameLidar = metier.getTrameLidar();
        context.addCallbackParam("trame", trameLidar.getLidar());
    }

    public void avancerRobot(){
        TrameMoteur trameMoteur = new TrameMoteur(127,127);
        System.out.println(trameMoteur);
        metier.ecritureTrame(metier.getClientMotor(), trameMoteur.getTrame());
    }

    public void droitRobot(){
        TrameMoteur trameMoteur = new TrameMoteur(127,-127);
        System.out.println(trameMoteur);
        metier.ecritureTrame(metier.getClientMotor(), trameMoteur.getTrame());
    }
    
    public void gaucheRobot(){
        TrameMoteur trameMoteur = new TrameMoteur(-127,127);
        System.out.println(trameMoteur);
        metier.ecritureTrame(metier.getClientMotor(), trameMoteur.getTrame());
    }
    
    public void reculerRobot(){
        TrameMoteur trameMoteur = new TrameMoteur(-127,-127);
        System.out.println(trameMoteur);
        metier.ecritureTrame(metier.getClientMotor(), trameMoteur.getTrame());
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String Adresse) {
        this.adresse = Adresse;
    }
    public void Connect()
    {
        metier.setAdresse(adresse);
        metier.connect();
    }
}