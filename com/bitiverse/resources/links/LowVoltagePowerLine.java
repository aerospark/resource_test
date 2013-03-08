/*
 *                    BITIVERSE SOFTWARE DEVELOPMENT LICENSE EXTENSION
 *    Bitiverse is open-source software, which is largely licensed under the LGPL v3.
 *      This software is developed and maintained by the Bitiverse Development Squad.
 * 
 *    This project makes use of the Lightweight Java Game Library (LWJGL) Project.
 * 
 *    Some code in this project is in the public domain.
 */
package com.bitiverse.resources.links;

import com.bitiverse.resources.ResourceLink;
import com.bitiverse.resources.Resources;

/**
 *
 * @author luke
 */
public class LowVoltagePowerLine extends ResourceLink {
    public LowVoltagePowerLine(){
        super(Resources.TYPE_ELECTRICITY, 64);
    }
}
