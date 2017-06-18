package mekong.slidescreenlibrary;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by brucel33 on 17/06/17.
 */

class Utils {
    public static int pixelToDP(int pixelDP){
        float density =  Resources.getSystem().getDisplayMetrics().density;
        return (int)(pixelDP * density);
    }
}
