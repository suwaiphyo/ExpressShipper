package com.smk.ExpressShipper528;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import com.smk.ExpressShipper528.R;
import com.mikepenz.iconics.IconicsDrawable;

/**
 * Created by SMK on 1/6/2016.
 */
public class BaseAppCompatActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public IconicsDrawable getIconicDrawable(String icon){
        return new IconicsDrawable(this)
                .icon(icon)
                .color(getResources().getColor(R.color.colorWhite))
                .sizeDp(24);
    }

    public IconicsDrawable getIconicDrawable(String icon, int color, int size){
        return new IconicsDrawable(this)
                .icon(icon)
                .color(getResources().getColor(color))
                .sizeDp(size);
    }

    public IconicsDrawable getIconicDrawable(String icon, int size){
        return new IconicsDrawable(this)
                .icon(icon)
                .sizeDp(size);
    }
}
