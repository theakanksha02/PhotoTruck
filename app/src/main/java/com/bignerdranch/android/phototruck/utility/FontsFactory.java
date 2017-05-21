package com.bignerdranch.android.phototruck.utility;

import android.content.Context;
import android.graphics.Typeface;


public class FontsFactory {

    private static Typeface tfBold;
    private static Typeface tfRegular;

    /**
     * creating a static variable of TypeFace is veryuseful  as createFromAsset is processor intensive job
     * that take few milliseconds. so this makes list little sluggish.
     * Saving the TypeFace as in static variable come in handy.
     * */

    public static Typeface fontBold(Context ctx){
        if (tfBold==null){
            tfBold =  Typeface.createFromAsset(ctx.getAssets(), "fonts/Raleway-Bold.ttf");
            return tfBold;
        } else {
            return  tfBold;
        }

    }




    public static Typeface fontRegular(Context ctx){
        if (tfRegular==null){
            tfRegular = Typeface.createFromAsset(ctx.getAssets(), "fonts/Raleway-Regular.ttf");
            return tfRegular;
        } else {
            return tfRegular;
        }
    }




}
