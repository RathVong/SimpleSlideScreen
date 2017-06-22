package mekong.slidescreenlibrary.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import java.util.ArrayList;

import mekong.slidescreenlibrary.Adapters.ViewPagerAdapter;
import mekong.slidescreenlibrary.Fragments.ScreenFragment;
import mekong.slidescreenlibrary.Models.ScreenData;
import mekong.slidescreenlibrary.R;
import mekong.slidescreenlibrary.MySharedPreferences;

public class SlideScreenActivity extends AppCompatActivity {
    public static final int RESULT_FINISHED = 10001;
    public static final String KEY_LAYOUT = "layout";

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private ArrayList<ScreenData> layouts;
    private Button btnSkip, btnNext;
    private MySharedPreferences mySharedPreferences;


    public static void start(Activity activity, ArrayList<ScreenData> layouts){
        final Intent intent = new Intent(activity,SlideScreenActivity.class);
        final Bundle bundle = new Bundle();
        intent.putExtra(KEY_LAYOUT, layouts);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, RESULT_FINISHED);
  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        layouts = getIntent().getParcelableArrayListExtra(KEY_LAYOUT);

        // Checking for first time launch - before calling setContentView()
        mySharedPreferences = new MySharedPreferences(this);
        if (mySharedPreferences.isShowOnlyOnce() && !mySharedPreferences.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setupViews();
    }

    private void setupViews(){
        initViews();
        setupViewPager(viewPager);
        initButtons();
    }

    private void initViews(){
        setContentView(R.layout.activity_slide_screen);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnNext = (Button) findViewById(R.id.btn_next);

        changeStatusBarColor();
    }

    private void initButtons(){
        btnSkip.setTextColor(layouts.get(0).getLeftButtonColors());
        btnNext.setTextColor(layouts.get(0).getRightButtonColors());
        btnSkip.setText(layouts.get(0).getLeftButtonText());
        btnNext.setText(layouts.get(0).getRightButtonText());

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(+1);
                if (current < layouts.size()) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });
    }

    //Setup the viewpager and initalize data passed in bundle

    private void setupViewPager(ViewPager viewPager) {
       final ViewPagerAdapter myViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        final int size = layouts.size();

        for (int i = 0; i < size; i++) {
            myViewPagerAdapter.addFragment(new ScreenFragment(), String.valueOf(i));
            Bundle b = new Bundle();
            b.putParcelable("layout", layouts.get(i));
            myViewPagerAdapter.getmFragmentList().get(i).setArguments(b);
        }


        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        tabLayout.setupWithViewPager(viewPager, true);
        tabLayout.setSelectedTabIndicatorColor(layouts.get(0).getDotsActiveColor());

        //Remove all text from each indicator
        //May add an option to have numbers in the future
        for (int i = 0; i < layouts.size(); i++) {
                tabLayout.getTabAt(i).setText("");
           }


    }




    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        mySharedPreferences.setFirstTimeLaunch(false);
        setResult(RESULT_FINISHED);
        finish();
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {


            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.size() - 1) {
                // last page. make button text to GOT IT
                btnNext.setText(layouts.get(position).getLastButtonText());
                btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                btnNext.setText(layouts.get(position).getRightButtonText());
                btnSkip.setVisibility(View.VISIBLE);
            }

            tabLayout.setSelectedTabIndicatorColor(layouts.get(position).getDotsActiveColor());

            btnSkip.setTextColor(layouts.get(position).getLeftButtonColors());
            btnNext.setTextColor(layouts.get(position).getRightButtonColors());
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


}

