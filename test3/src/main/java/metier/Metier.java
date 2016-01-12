/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Trame.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Metier {

    private Socket clientLidar;
    private Socket clientMotor;
    private Socket clientGPS;
    private OutputStream output;
    private String adresse;

    public void connect() {
        System.out.println("Adresse : " + adresse);
        adresse = "172.20.81.49";
        try {
            clientLidar = new Socket("172.20.81.49", 3337);
            clientMotor = new Socket("172.20.81.49", 3331);
            clientGPS = new Socket("172.20.81.49", 3334);
        } catch (Exception e) {

        }
    }

    public String lectureTrame(Socket client) {
        String reponse = "";
        String thisLine;
        boolean end = false;
        System.out.println("ici" + client.getPort());
        try {
            InputStream input = client.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
            thisLine = buffer.readLine() + (char) 0;
            reponse += thisLine;
            do {
                thisLine = buffer.readLine() + (char) 0;
                if (thisLine.contains("NAIO")) {
                    String[] temp = thisLine.split("NAIO");
                    reponse += temp[0];
                    end = true;
                } else {
                    reponse += thisLine;
                }
            } while (!end);
            System.out.println("Result : " + reponse);
            input.close();
        } catch (Exception e) {
            System.out.println("Exception : " + e.toString());
        }
        return reponse;
    }

    public void ecritureTrame(Socket client, byte[] trame) {
        try {
            output = client.getOutputStream();
            output.write(trame);
            output.close();
        } catch (Exception e) {

        }
    }

    public TrameLidar getTrameLidar() {
        return new TrameLidar(lectureTrame(clientLidar));
    }

    public TrameGPS getTrameGPS() {
        return new TrameGPS(lectureTrame(clientGPS));
    }

    public Socket getClientMotor() {
        return clientMotor;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }
}
