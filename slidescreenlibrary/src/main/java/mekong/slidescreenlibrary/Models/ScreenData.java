package mekong.slidescreenlibrary.Models;


import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by brucel33 on 17/06/17.
 */

public class ScreenData implements Parcelable{


    //The colors of the background and font will only accept hexideximal String color format
    // and return int


    private String title;
    private String description;
    private int image;
    private int backgroundColor = Color.WHITE;
    private int fontColor = Color.BLACK;
    private int dotsActiveColor = Color.BLACK;
    private int dotsInActiveColor = Color.GRAY;
    private int leftButtonColors = Color.RED;
    private int rightButtonColors = Color.RED;
    private int titleTextSize = 16;
    private int descriptionTextSize = 16;
    private String leftButtonText = "Skip";
    private String rightButtonText = "Next";
    private String lastButtonText = "Got it!";


    protected ScreenData(Parcel in) {
        title = in.readString();
        description = in.readString();
        image = in.readInt();
        backgroundColor = in.readInt();
        fontColor = in.readInt();
        dotsActiveColor = in.readInt();
        dotsInActiveColor = in.readInt();
        leftButtonColors = in.readInt();
        rightButtonColors = in.readInt();
        titleTextSize = in.readInt();
        descriptionTextSize = in.readInt();
        leftButtonText = in.readString();
        rightButtonText = in.readString();
        lastButtonText = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(image);
        dest.writeInt(backgroundColor);
        dest.writeInt(fontColor);
        dest.writeInt(dotsActiveColor);
        dest.writeInt(dotsInActiveColor);
        dest.writeInt(leftButtonColors);
        dest.writeInt(rightButtonColors);
        dest.writeInt(titleTextSize);
        dest.writeInt(descriptionTextSize);
        dest.writeString(leftButtonText);
        dest.writeString(rightButtonText);
        dest.writeString(lastButtonText);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ScreenData> CREATOR = new Creator<ScreenData>() {
        @Override
        public ScreenData createFromParcel(Parcel in) {
            return new ScreenData(in);
        }

        @Override
        public ScreenData[] newArray(int size) {
            return new ScreenData[size];
        }
    };

    public int getLeftButtonColors() {
        return leftButtonColors;
    }

    public void setLeftButtonColors(String leftButtonColors) {
        this.leftButtonColors = Color.parseColor(leftButtonColors);
    }

    public int getRightButtonColors() {
        return rightButtonColors;
    }

    public void setRightButtonColors(String rightButtonColors) {
        this.rightButtonColors = Color.parseColor(rightButtonColors);
    }

    public String getLeftButtonText() {
        return leftButtonText;
    }

    public void setLeftButtonText(String leftButtonText) {
        this.leftButtonText = leftButtonText;
    }

    public String getRightButtonText() {
        return rightButtonText;
    }

    public void setRightButtonText(String rightButtonText) {
        this.rightButtonText = rightButtonText;
    }

    public String getLastButtonText() {
        return lastButtonText;
    }

    public void setLastButtonText(String lastButtonText) {
        this.lastButtonText = lastButtonText;
    }

//All dimentions will return a DP value of the pixel




    public int getTitleTextSize() {
        return titleTextSize;
    }

    public int getDescriptionTextSize() {
        return descriptionTextSize;
    }

    public void setTitleTextSize(int titleTextSize) {
        this.titleTextSize = titleTextSize;
    }

    public void setDescriptionTextSize(int descriptionTextSize) {
        this.descriptionTextSize = descriptionTextSize;
    }

    public ScreenData(){

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }



    public int getDotsActiveColor() {
        return dotsActiveColor;
    }

    public void setDotsActiveColor(String color){
        this.dotsActiveColor = Color.parseColor(color);
    }

    public int getDotsInActiveColor() {
        return dotsInActiveColor;
    }

    public void setDotsInActiveColor(String color) {
        this.dotsInActiveColor = Color.parseColor(color);
    }

    //Init colors
    public void setBackGroundColor(String color){
        this.backgroundColor = Color.parseColor(color);
    }

    public void setFontColor(String color){
        this.fontColor = Color.parseColor(color);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getFontColor() {
        return fontColor;
    }


}
