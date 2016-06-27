
package server;

import java.io.File;
import javax.swing.filechooser.FileFilter;


class imagefilter extends FileFilter {

    public imagefilter() {
    }

    @Override
    public boolean accept(File file) {
       if(file.getName().toLowerCase().endsWith(".jpg")||
               file.getName().toLowerCase().endsWith(".png")
               ){
           return true;
       }else if(file.isDirectory())
           return true;
       else
           return false;
    }

    @Override
    public String getDescription() {
        return "Image Files";
    }
    
}
