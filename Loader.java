
import com.bitiverse.resources.test.RT2D;
import javax.swing.JFrame;

/*
 *                    BITIVERSE SOFTWARE DEVELOPMENT LICENSE EXTENSION
 *    Bitiverse is open-source software, which is largely licensed under the LGPL v3.
 *      This software is developed and maintained by the Bitiverse Development Squad.
 * 
 *    This project makes use of the Lightweight Java Game Library (LWJGL) Project.
 * 
 *    Some code in this project is in the public domain.
 */


/**
 *
 * @author luke
 */
public class Loader {
    public static void main(String[] str){
        JFrame j = new JFrame("RT2D");
        j.add(new RT2D());
        j.pack();
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
