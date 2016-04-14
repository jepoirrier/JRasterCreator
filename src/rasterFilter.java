/*
 * rasterFilter.java
 *
 * Created on 29 décembre 2006, 23:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package rastercreator;

import java.io.File;

/**
 *
 * @author Jean-Etienne
 */
public class rasterFilter extends javax.swing.filechooser.FileFilter {
    
    /** Creates a new instance of rasterFilter */
    public rasterFilter() {
    }
    
    public String getDescription() {
        return "Raster files (*.raster)";
    }

    public boolean accept(File f) {
        String filename = f.getName();
        return filename.endsWith(".raster");
    }
    
}
