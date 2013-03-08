/*
 *                    BITIVERSE SOFTWARE DEVELOPMENT LICENSE EXTENSION
 *    Bitiverse is open-source software, which is largely licensed under the LGPL v3.
 *      This software is developed and maintained by the Bitiverse Development Squad.
 * 
 *    This project makes use of the Lightweight Java Game Library (LWJGL) Project.
 * 
 *    Some code in this project is in the public domain.
 */
package com.bitiverse.resources.test;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author luke
 */
public class RT2D extends Component {
    
    public int w = 800, h = 600;
    
    public RT2D(){
        this.setPreferredSize(new Dimension(w, h));
        this.setSize(w, h);
    }

    @Override
    public void paint(Graphics g) {
    }
    
}
