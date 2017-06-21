package com.mekongmessenger.SlideScreenExample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import mekong.slidescreenlibrary.ScreenData;
import mekong.slidescreenlibrary.SlideScreenActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SlideScreenActivity.start(this, initLayout());
    }

    private ScreenData layout1(){
        ScreenData layout = new ScreenData();
        layout.setTitleTextSize(8);
        layout.setDescriptionTextSize(5);
        layout.setLeftButtonColors("#F5B041");
        layout.setRightButtonColors("#F5B041");
        layout.setTitle("Images");
        layout.setDescription("Images are automatically adjusted \n to fit the width and height of the screen.");
        layout.setImage(R.drawable.food);

        return layout;
    }

    private ScreenData layout2(){
        ScreenData layout = new ScreenData();
        layout.setTitleTextSize(8);
        layout.setDescriptionTextSize(5);
        layout.setLeftButtonColors("#F5B041");
        layout.setRightButtonColors("#F5B041");
        layout.setTitle("Scrolling");
        layout.setDescription("Easily scroll from left to right. ");
        layout.setImage(R.drawable.balloons);

        return layout;
    }

    private ScreenData layout3(){
        ScreenData layout = new ScreenData();
        layout.setTitleTextSize(8);
        layout.setDescriptionTextSize(5);
        layout.setLeftButtonColors("#F5B041");
        layout.setRightButtonColors("#F5B041");
        layout.setTitle("Modify");
        layout.setDescription("Modify button colours or button names. ");
        layout.setImage(R.drawable.dessert);

        return layout;
    }

    private ArrayList<ScreenData> initLayout(){
        ArrayList<ScreenData> layout = new ArrayList<>();
        layout.add(layout1());
        layout.add(layout2());
        layout.add(layout3());
        return layout;
    }
}
