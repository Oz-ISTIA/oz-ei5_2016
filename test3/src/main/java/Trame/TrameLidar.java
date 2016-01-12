/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trame;

import exception.TrameException;
import java.nio.ByteBuffer;

public class TrameLidar extends Trame {

    int[] lidar;
    byte[] albedo;

    public TrameLidar(String trameBrut) {
        super(trameBrut);
        if(getId() != 7 || getTaille() != 3*271){
            throw new TrameException("Trame Lidar invalide ",200);
        }
        lidar = new int[271];
        albedo = new byte[271];
        for (int i = 0, j = 0; i < lidar.length; i++, j += 2) {
            lidar[i] = ByteBuffer.wrap(new byte[]{0, 0, getByte(j), getByte(j + 1)}).getInt();
        }
        for (int i = 0; i < albedo.length; i++) {
            albedo[i] = getByte(271*2 + i);
        }
    }

    public String getLidar() {
        String out = "[";
        for (int i = 0; i < lidar.length; i++) {
            out += String.format("%d,",lidar[i]);
        }
        out+= "0]";
        return out;
    }
}
