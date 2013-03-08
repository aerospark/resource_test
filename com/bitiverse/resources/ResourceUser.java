/*
 *                    BITIVERSE SOFTWARE DEVELOPMENT LICENSE EXTENSION
 *    Bitiverse is open-source software, which is largely licensed under the LGPL v3.
 *      This software is developed and maintained by the Bitiverse Development Squad.
 * 
 *    This project makes use of the Lightweight Java Game Library (LWJGL) Project.
 * 
 *    Some code in this project is in the public domain.
 */
package com.bitiverse.resources;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author luke
 */
public abstract class ResourceUser implements Runnable {
    
    public int locx = 10, locy = 10, unrenderedsent = 0, lastsentx = 0, lastsenty = 0; //used for this rendering test only (to be removed)
    
    public int[] buffer = new int[64]; // 64 resource types (for now)
    public ArrayList<ResourceUser> connections = new ArrayList<>();
    
    public int getResources(int type, int amount, int tox, int toy){return 0;} //not a resource provider
    
    public void requestResources(int type, int amount){
        int a = 0;
        for(ResourceUser u : connections){
            a += u.getResources(type, amount-a, locx, locy);
            if(a>=amount) break;
        }
        System.out.println(toString() + " requested " + amount + " of " + type+", received a total of " + a + " from " + connections.size() + " connected users.");
        buffer[type] += a;
    }
    
    public int pullFromBuffer(int type, int amount   /* used for this render test */, int tox, int toy){
        int a = 0;
        lastsentx = tox;
        lastsenty = toy;
        if(buffer[type]>=amount) {
            buffer[type]-= amount;
            unrenderedsent += amount; //used for this rendering test only (to be removed)
            return amount;
        }else{
            a = buffer[type];
            buffer[type] = 0;
        }
        unrenderedsent += a; //used for this rendering test only (to be removed)
        return a;
    }
    
}
