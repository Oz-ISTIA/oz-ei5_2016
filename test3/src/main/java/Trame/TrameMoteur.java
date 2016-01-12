/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trame;

/**
 *
 * @author usrlocal
 */
public class TrameMoteur extends Trame{
    
    byte LCM;
    byte RCM;
       
    public TrameMoteur(){
        id = (byte) 1;
    }
    
    public TrameMoteur(int lcm,int rcm){
        trame = new byte[17];
        trame[0] = 'N'; 
        trame[1] = 'A';
        trame[2] = 'I'; 
        trame[3] = 'O'; 
        trame[4] = '0'; 
        trame[5] = '1';
        trame[6] = 1;
        trame[10] = 2;
        trame[11] = (byte)lcm;
        trame[12] = (byte)rcm;
        
    }
    
    
}
