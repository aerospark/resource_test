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
import com.bitiverse.resources.Resources;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luke
 */
public class RT2D extends Component {
    
    public int w = 800, h = 600;
    
    Ellipse2D.Float circle = null;
    
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
        pump.locx = 120;
        pump.locy = 60;
        pan.locx = 60;
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
        
        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(100);
                        for(ResourceUser u : users){
                            u.run();
                        }
                        repaint();
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            }
            
        }).start();
        
    }
    
    int idx = 0;

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,w,h);
        for(ResourceUser u : users){    
            idx = 0;
            g.setColor(Color.WHITE);
            g.drawString(u.toString(), u.locx, u.locy);
            for(int rad : u.buffer){
                g.setColor(new Color(255-idx*4,idx*4,255-idx,42));
                g.fillOval(u.locx-rad/4, u.locy-rad/4, rad/2, rad/2);
                idx++;
            }
        }
    }
    
}
