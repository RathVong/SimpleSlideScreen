package mekong.slidescreenlibrary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import mekong.slidescreenlibrary.Fragments.ScreenFragment;

public class SlideScreenActivity extends AppCompatActivity {
    public static final int RESULT_FINISHED = 10001;
    private ViewPager viewPager;

    private LinearLayout dotsLayout;
    private TextView[] dots;
    private ArrayList<ScreenData> layouts;
    private Button btnSkip, btnNext;
    private SlideOptions slideOptions;


    public static void start(Activity activity, ArrayList<ScreenData> layouts){
        final Intent intent = new Intent(activity,SlideScreenActivity.class);
        final Bundle bundle = new Bundle();
        bundle.putSerializable("layouts", layouts);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, RESULT_FINISHED);
  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();


            layouts = (ArrayList<ScreenData>) bundle.getSerializable("layouts");




        // Checking for first time launch - before calling setContentView()
        slideOptions = new SlideOptions(this);
        if (slideOptions.isShowOnlyOnce() && !slideOptions.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_slide_screen);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnNext = (Button) findViewById(R.id.btn_next);


        btnSkip.setTextColor(layouts.get(0).getLeftButtonColors());
        btnNext.setTextColor(layouts.get(0).getRightButtonColors());
        btnSkip.setText(layouts.get(0).getLeftButtonText());
        btnNext.setText(layouts.get(0).getRightButtonText());


        // adding bottom dots
        addBottomDots(0);

        // making notification bar transparent
        changeStatusBarColor();

        setupViewPager(viewPager);

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


    private void setupViewPager(ViewPager viewPager) {
       final ViewPagerAdapter myViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


        try {
            final int size = layouts.size();
            for (int i = 0; i < size; i++) {
                myViewPagerAdapter.addFragment(new ScreenFragment(), String.valueOf(i));
                Bundle b = new Bundle();
                b.putParcelable("layout", layouts.get(i));
                myViewPagerAdapter.getmFragmentList().get(i).setArguments(b);
         }

        }catch (Exception e){
            e.printStackTrace();
        }


        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

    }


    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.size()];



        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(layouts.get(currentPage).getDotsInActiveColor());
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(layouts.get(currentPage).getDotsActiveColor());
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        slideOptions.setFirstTimeLaunch(false);
        setResult(RESULT_FINISHED);
        finish();
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

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

