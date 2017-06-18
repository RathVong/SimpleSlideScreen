package mekong.slidescreenlibrary;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by brucel33 on 17/06/17.
 */

public class SlideOptions {

        SharedPreferences pref;
        SharedPreferences.Editor editor;
        Context _context;

        // shared pref mode
        int PRIVATE_MODE = 0;

        // Shared preferences file name
        private static final String PREF_NAME = "SlideScreenOptions";

        private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

        private static final String IS_SHOW_ONLY_ONCE = "IsShowOnlyOnce";

        public SlideOptions(Context context) {
            this._context = context;
            pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
            editor = pref.edit();
        }

        public void setFirstTimeLaunch(boolean isFirstTime) {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
            editor.commit();
        }


    public void setShowOnlyOnce(boolean isShowOnce) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isShowOnce);
        editor.commit();
    }

        public boolean isShowOnlyOnce(){
            return pref.getBoolean(IS_SHOW_ONLY_ONCE, false);
        }
        public boolean isFirstTimeLaunch() {
            return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
        }


}
