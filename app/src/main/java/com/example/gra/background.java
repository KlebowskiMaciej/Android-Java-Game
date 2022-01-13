package com.example.gra;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class background {
    int x,y;

    Bitmap background;

    background (int ScreenX, int ScreenY, Resources res)
    {
        background= BitmapFactory.decodeResource(res,R.drawable.background);
        background=Bitmap.createScaledBitmap(background,ScreenX,ScreenY,false);
    }
}
