package mekong.slidescreenlibrary.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import mekong.slidescreenlibrary.R;
import mekong.slidescreenlibrary.Models.ScreenData;
import mekong.slidescreenlibrary.Utils.Util;

/**
 * Created by brucel33 on 17/06/17.
 */

public class ScreenFragment extends Fragment {
    private static final String TAG = ScreenFragment.class.getSimpleName();

    public ScreenFragment() {

    }

    private ScreenData layout;
    private RelativeLayout relativeLayout;
    private ImageView imageView;
    private TextView title;
    private TextView description;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout =  getArguments().getParcelable("layout");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.slide, container, false);

        relativeLayout = (RelativeLayout) rootView.findViewById(R.id.SlideScreenLayout);
        imageView = (ImageView) rootView.findViewById(R.id.imageView);
        title = (TextView) rootView.findViewById(R.id.title);
        description = (TextView)rootView.findViewById(R.id.description);

        setupViews();
        return rootView;

    }

    private void setupViews(){
        relativeLayout.setBackgroundColor(layout.getBackgroundColor());
        setupImage();
        setupTitle();
        setupDescription();
    }

    private void setupTitle(){
        title.setText(layout.getTitle());
        title.setTextColor(layout.getFontColor());
        title.setTextSize(layout.getTitleTextSize());
    }

    private void setupDescription(){
        description.setText(layout.getDescription());
        description.setTextColor(layout.getFontColor());
        description.setTextSize(layout.getDescriptionTextSize());
    }

    private void setupImage(){

        final int imageWidth = Util.getDisplayMetrics().widthPixels;
        final int imageHeight = (int) (Util.getDisplayMetrics().heightPixels * 0.6);

        final RelativeLayout.LayoutParams imageParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        imageParams.width = imageWidth;
        imageParams.height = imageHeight;
        imageView.setLayoutParams(imageParams);

        if (layout.getImage() > 0 ){
            Glide.with(this)
                    .load(layout.getImage())
                    .into(imageView);
        }


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        title = null;
        description = null;
        imageView = null;
        relativeLayout = null;
    }
}
