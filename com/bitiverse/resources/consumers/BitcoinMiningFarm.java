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
import com.bitiverse.resources.Resources;

/**
 *
 * @author luke
 */
public class BitcoinMiningFarm extends ResourceUser {

    @Override
    public void run() {
        if(buffer[Resources.TYPE_ELECTRICITY]<1024) requestResources(Resources.TYPE_ELECTRICITY, 128);
        buffer[Resources.TYPE_ELECTRICITY]-=84;
    }
    
}
