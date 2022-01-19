package com.example.gra;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * @author Maciej Kłębowski
 * @version 1.0
 * klasa odpowiedzialna za tło.
 */
public class background
{

    /**
     * Zmiene klasy
     */
    public int x,y;
    Bitmap background;

    /**
     * Konstruktor klasy
     */
    background (int screenWidth, int screenHeight,Resources res)
    {
        background= BitmapFactory.decodeResource(res,R.drawable.background);
        background=Bitmap.createScaledBitmap(background,screenWidth,screenHeight,false);
    }
}
