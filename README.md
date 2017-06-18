# SimpleSlideScreen
Simple library example of a slide screen in android


![alt text](https://github.com/RathVong/SimpleSlideScreen/blob/master/layout.png)


The library has not been tested thoroughly yet. 








Creating in view in your layout is simple ->






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
        layout.setImage(R.drawable.f);

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
        layout.setImage(R.drawable.f);

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
        layout.setImage(R.drawable.f);

        return layout;
    }

    private ArrayList<ScreenData> initLayout(){

        ArrayList<ScreenData> layout = new ArrayList<>();
        layout.add(layout1());
        layout.add(layout2());
        layout.add(layout3());
        return layout;
    }
   
