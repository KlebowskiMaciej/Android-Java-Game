
package com.example.gra;
import android.content.res.Resources;

import static com.example.gra.GameView.ScreenRatioX;
import static com.example.gra.GameView.ScreenRatioY;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class user {

    public boolean isGoingLEFT=false, isGoingRIGHT=false;
    int x,y,width,height;
    Bitmap user1,bg;

    user(int ScreenX, int ScreenY, Resources res)
    {
        user1= BitmapFactory.decodeResource(res,R.drawable.doodle);
        width=user1.getWidth();
        height=user1.getHeight();



        user1=Bitmap.createScaledBitmap(user1,width,height,false);

        y=(int) (64*ScreenRatioY);
        x=ScreenX/2;

    }

}
