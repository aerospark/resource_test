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

import com.bitiverse.resources.ResourceUser;
import com.bitiverse.resources.buffers.WaterTower;
import com.bitiverse.resources.consumers.ResourceVoid;
import com.bitiverse.resources.processors.HardWaterFusionPlant;
import com.bitiverse.resources.sources.SolarPanel;
import com.bitiverse.resources.sources.WaterPump;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 *
 * @author luke
 */
public class RT2D extends Component {
    
    public int w = 800, h = 600;
    
    Ellipse2D.Double circle = null;
    
    ArrayList<ResourceUser> users = new ArrayList<>();
    
    public RT2D(){
        this.setPreferredSize(new Dimension(w, h));
        this.setSize(w, h);
        SolarPanel pan = new SolarPanel();
        WaterPump pump = new WaterPump();
        pump.connections.add(pan);
        WaterTower tower = new WaterTower();
        tower.connections.add(pan);
        tower.connections.add(pump);
        HardWaterFusionPlant plant = new HardWaterFusionPlant();
        plant.connections.add(pan);
        plant.connections.add(tower);
        ResourceVoid rvoid = new ResourceVoid();
        rvoid.connections.add(plant);
        
        rvoid.locx = 120;
        rvoid.locy = h-30;
        pump.locx = 60;
        pump.locy = 60;
        pan.locx = 120;
        pan.locy = 70;
        tower.locx = 180;
        tower.locy = 80;
        plant.locx = w/2;
        plant.locy = h/2;
        
        users.add(pan);
        users.add(pump);
        users.add(tower);
        users.add(plant);
        users.add(rvoid);
        
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,w,h);
        g.setColor(Color.WHITE);
        for(ResourceUser u : users){
            g.drawString(u.toString(), u.locx, u.locy);
        }
    }
    
}
