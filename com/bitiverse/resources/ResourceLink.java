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

/**
 *
 * @author luke
 */
public class ResourceLink extends ResourceUser{
    
    public int thistype = 0, bandware = 0;

    public ResourceLink(int type, int bandware){
        thistype = type;
        this.bandware = bandware;
    }

    @Override
    public int getResources(int type, int amount) {
        return pullFromBuffer(type, amount);
    }
    
    @Override
    public void run() {
        if(buffer[thistype]<bandware*4)requestResources(thistype, bandware);
    }
    
}
