package util;

import java.io.File;
import javax.swing.filechooser.*;

/* ImageFilter.java  is used to filter out only image files in Save As dialog */
public class CustomFileFilter extends FileFilter  implements java.io.Serializable
{


    private String fileExtension;
    private String description;

    public CustomFileFilter(String fileExtension, String description)
    {
        this.fileExtension = fileExtension;
        this.description = description;
    }

    //Accept all directories and all gif, jpg, tiff, or png files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = getExtension(f);
        if (extension != null) {
            if (extension.equalsIgnoreCase(fileExtension) )//||
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return description;
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1)
        {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
