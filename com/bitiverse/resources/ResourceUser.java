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

import java.util.ArrayList;

/**
 *
 * @author luke
 */
public abstract class ResourceUser implements Runnable {
    public int[] buffer = new int[64]; // 64 resource types (for now)
    public ArrayList<ResourceUser> connections = new ArrayList<>();
    public int getResources(int type, int amount){return 0;} //not a resource provider
    public void consumeResources(int type, int amount){
        int a = 0;
        for(ResourceUser u : connections){
            a += u.getResources(type, amount-a);
            if(a>=amount) break;
        }
        buffer[type] += a;
    }
    public int pullFromBuffer(int type, int amount){
        int a = 0;
        
        if(buffer[type]>=amount) {
            buffer[type]-= amount;
            return amount;
        }else{
            a = buffer[type];
            buffer[type] = 0;
        }
        
        return a;
    }
}
