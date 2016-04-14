/*
 * rasterCollection.java
 *
 * Created on 29 décembre 2006, 21:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package rastercreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 *
 * @author Jean-Etienne
 */
public class rasterCollection {
    
    private ArrayList rpList;
    
    /** Creates a new instance of rasterCollection */
    public rasterCollection() {
        rpList = new ArrayList();
        // Create a list of rasterPoints with default value = false
        for(double y = 1; y >= -1; y = y - 0.1){
            for(double x = -1; x <= 1; x = x + 0.1)
                    rpList.add(new rasterPoint(x, y, false));
        }
    }
    
    public int getSize() {
        return rpList.size();
    }
    
    public rasterPoint getN(int n) {
        return (rasterPoint)rpList.get(n - 1);
    }
    
    public ArrayList getList() {
        return rpList;
    }

    /**
     * Clear all rasterPoints (set their status to false)
     *
     * @author Jean-Etienne Poirrier
     */
    public void clear() {
        Iterator itr = rpList.iterator();
        while(itr.hasNext()) {
            rasterPoint rp = (rasterPoint)itr.next();
            rp.setStatus(false);
        }
        System.out.println("Clear done");
    }

    /**
     * Save all rasterPoints with a true status in a text file at the raster
     * format
     *
     * @param f the absolute, full name of the file (pathname + filename)
     * @throws IOException
     */
    public void save(String f) throws IOException {
        // get filename for name
        File fn = new File(f);
        String file = fn.getName();
        int point = file.lastIndexOf('.');
        file = file.substring(0, point);
        
        String initString = "<measuringraster name=\"" + file + "\" date=\"" + getTimeAndDate() + "\" creator=\"jrc\" version=\"1.0\">";
        PrintWriter out = new PrintWriter(new FileWriter(f));
        out.println(initString);
        
        Iterator itr = rpList.iterator();
        while(itr.hasNext()) {
            rasterPoint rp = (rasterPoint)itr.next();
            //rp.toString();
            if(rp.getStatus())
                out.println("\t" + "<pos x=\"" + rp.getXf() + "\" y=\"" + rp.getYf() + "\"/>");
        }
        out.println("</measuringraster>");
        out.close();
    }
    
    /**
     * get time and date of the moment when it is evoqued in a format suitable
     * for a raster file, e.g. 2004-12-15T14:45:32 (yyyy-mm-ddThh:mm:ss)
     *
     * @return string containing date and time
     * @author Jean-Etienne poirrier
     */
    public static String getTimeAndDate()
    {
        StringBuffer buf = new StringBuffer();
        Calendar cal = Calendar.getInstance();
        int day     = cal.get(Calendar.DAY_OF_MONTH);
        int month   = cal.get(Calendar.MONTH) + 1;
        int year    = cal.get(Calendar.YEAR);
        int hour24  = cal.get(Calendar.HOUR_OF_DAY);
        int min     = cal.get(Calendar.MINUTE);
        int sec     = cal.get(Calendar.SECOND );
//        int msec    = cal.get(Calendar.MILLISECOND );

        buf.append(year);
        buf.append('-');
        if(month < 10)
            buf.append('0');
        buf.append(month);
        buf.append('-');
        if(day < 10)
            buf.append('0');
        buf.append(day);
        buf.append('T');
        if(hour24 < 10)
            buf.append('0');
        buf.append(hour24);
        buf.append(':');
        if(min < 10)
            buf.append('0');
        buf.append(min);
        buf.append(':');
        if(sec < 10)
            buf.append('0');
        buf.append(sec);

        return buf.toString();
    }
}
