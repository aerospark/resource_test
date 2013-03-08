/*
 *                    BITIVERSE SOFTWARE DEVELOPMENT LICENSE EXTENSION
 *    Bitiverse is open-source software, which is largely licensed under the LGPL v3.
 *      This software is developed and maintained by the Bitiverse Development Squad.
 * 
 *    This project makes use of the Lightweight Java Game Library (LWJGL) Project.
 * 
 *    Some code in this project is in the public domain.
 */
package com.bitiverse.resources.consumers;

import com.bitiverse.resources.ResourceUser;

/**
 *
 * @author luke
 */
public class Void extends ResourceUser {

    @Override
    public void run() {
        for(int i = 0; i < buffer.length; i++){
            buffer[i]-=32;
            consumeResources(i, 32);
        }
    }
    
}
