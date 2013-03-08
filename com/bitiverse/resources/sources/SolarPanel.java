/*
 *                    BITIVERSE SOFTWARE DEVELOPMENT LICENSE EXTENSION
 *    Bitiverse is open-source software, which is largely licensed under the LGPL v3.
 *      This software is developed and maintained by the Bitiverse Development Squad.
 * 
 *    This project makes use of the Lightweight Java Game Library (LWJGL) Project.
 * 
 *    Some code in this project is in the public domain.
 */
package com.bitiverse.resources.sources;

import com.bitiverse.resources.ResourceUser;
import com.bitiverse.resources.Resources;

/**
 *
 * @author luke
 */
public class SolarPanel extends ResourceUser {

    @Override
    public int getResources(int type, int amount, int tox, int toy) {
        return pullFromBuffer(type, amount, tox, toy);
    }
    
    @Override
    public void run() {
        if(buffer[Resources.TYPE_ELECTRICITY]<64)buffer[Resources.TYPE_ELECTRICITY]++;
    }
    
}
