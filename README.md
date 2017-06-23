# SimpleSlideScreen
Simple library example of a slide screen in android


![alt text](https://github.com/RathVong/SimpleSlideScreen/blob/master/layout_example.jpg)

Installation:

  compile 'com.rathvong.simpleslidescreen:slidescreenlibrary:1.0.0-alpha'



Creating a view in your activity is simple ->


    





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Start the slide screen and init with your view.
        SlideScreenActivity.start(this, initLayout());
    }

    //** Create your layout  for each view
    private ScreenData layout1(){
        ScreenData layout = new ScreenData();
        
         //Set your title font size
        layout.setTitleTextSize(8);
        
        //Set your description font size
        layout.setDescriptionTextSize(5);   
        
        //Set the color of the left button of your layout
        layout.setLeftButtonColors("#F5B041"); 
        
        //Set the color of the right button of your layout
        layout.setRightButtonColors("#F5B041"); 
        
        //Set the title to be displayed
        layout.setTitle("Images"); 
        
        //Set the description to be displayed
        layout.setDescription("Images are automatically adjusted \n to fit the width and height of the screen."); 
        
        //Set the image drawable to use
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
        layout.setImage(R.drawable.b);

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
        layout.setImage(R.drawable.d);

        return layout;
    }

    //Must create an ArrayList for the views to display.
    private ArrayList<ScreenData> initLayout(){

        ArrayList<ScreenData> layout = new ArrayList<>();
        layout.add(layout1());
        layout.add(layout2());
        layout.add(layout3());
        return layout;
    }
