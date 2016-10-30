package com.sketchproject;

/**
 * InnerClasses
 * Created by Angga on 24/07/2016.
 */
public class Button {
    private String title;
    private OnClickListener onClickListener;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public void onClick(){
        this.onClickListener.onClick(this.title);
    }

    public interface  OnClickListener{
        void onClick(String title);
    }
}
