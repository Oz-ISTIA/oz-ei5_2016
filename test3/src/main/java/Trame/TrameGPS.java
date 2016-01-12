/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trame;

import java.nio.ByteBuffer;

/**
 *
 * @author usrlocal
 */
public class TrameGPS extends Trame {

    double time;
    double lat;
    double lon;
    double alt;

    public TrameGPS(String trameBrut) {
        super(trameBrut);
        calculValeurGPS();
    }

    public void calculValeurGPS() {
        byte[] dataGPS = super.getData();
        time = ByteBuffer.wrap(new byte[]{dataGPS[0],dataGPS[1],dataGPS[2],dataGPS[3],dataGPS[4],dataGPS[5],dataGPS[6],dataGPS[7]}).getDouble();
        lat = ByteBuffer.wrap(new byte[]{dataGPS[8],dataGPS[9],dataGPS[10],dataGPS[11],dataGPS[12],dataGPS[13],dataGPS[14],dataGPS[15]}).getDouble();
        lon = ByteBuffer.wrap(new byte[]{dataGPS[16],dataGPS[17],dataGPS[18],dataGPS[19],dataGPS[20],dataGPS[21],dataGPS[22],dataGPS[23]}).getDouble();
        alt = ByteBuffer.wrap(new byte[]{dataGPS[24],dataGPS[25],dataGPS[26],dataGPS[27],dataGPS[28],dataGPS[29],dataGPS[30],dataGPS[31]}).getDouble();
    }

    public double getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getAlt() {
        return alt;
    }
}
