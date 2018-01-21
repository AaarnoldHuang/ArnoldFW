package tk.arnoldwho.arnold.arnoldfw;

import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created by arnold on 18-1-21.
 */

public class Appinfo {
    public String appName="";
    public String packageName="";
    public Drawable appIcon=null;
    public void print()
    {
        Log.v("app","Name:"+appName+" Package:"+packageName);
    }

}
