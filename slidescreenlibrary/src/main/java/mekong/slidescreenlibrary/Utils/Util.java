package mekong.slidescreenlibrary.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by brucel33 on 17/06/17.
 */

public class Util {
    public static int pixelToDP(int pixelDP){
        float density =  Resources.getSystem().getDisplayMetrics().density;
        return (int)(pixelDP * density);
    }

    public static DisplayMetrics getDisplayMetrics(){
        return Resources.getSystem().getDisplayMetrics();
    }
}
