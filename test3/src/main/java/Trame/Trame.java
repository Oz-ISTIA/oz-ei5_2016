/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trame;

import exception.TrameException;
import java.nio.ByteBuffer;

public class Trame {

    byte id;
    int taille;
    byte[] data;
    byte[] trame;

    public Trame(){
       
    }
    
    public Trame(String trameBrut) {
        if (!trameBrut.isEmpty()) {
            trame = new byte[trameBrut.length()];
            for (int i = 0; i < trame.length; i++) {
                trame[i] = (byte) trameBrut.charAt(i);
            }
        } else {
            throw new TrameException("Trame vide !", 100);
        }
        id = trame[6];
        taille = ByteBuffer.wrap(new byte[]{trame[7], trame[8], trame[9], trame[10]}).getInt();
        data = new byte[taille];
        for (int i = 0; i < data.length; i++) {
            data[i] = trame[i + 11];
        }
    }

    public int getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }
    
    public void setData(byte[] data) {
        this.data = data;
    }
    
    public byte getByte(int index){
        return data[index];
    }
    
    public int getTaille() {
        return taille;
    }

    public byte[] getTrame() {
        return trame;
    }
    
    @Override
    public String toString(){
        String out = "|";
        for(int i = 0 ; i < trame.length;i++){
            out += trame[i] + "|";
        }
        out += "<";
        return out;
    }
}
