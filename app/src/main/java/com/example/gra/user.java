
package com.example.gra;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 *
 *  * @author Maciej Kłębowski
 *  * @version 1.0
 * Klasa odpowiedzialna za postać i jej poruszanie.
 */
public class user
{

    //variable
    public boolean JUMP_LEFT=false, JUMP_RIGHT=false,falling=false,GameOver =false;
    public int x,y,width,height,counter=0;
    public int xVelocity=15;
    public int yVelocity=15;


    Bitmap user1;

    /**
     * Konstrutktor klasy

     */
    user(int screenWidth, int screenHeight,Resources res)
    {
        user1= BitmapFactory.decodeResource(res,R.drawable.doodle);
        width=user1.getWidth();
        height=user1.getHeight();
        user1=Bitmap.createScaledBitmap(user1,width,height,false);
        y=screenHeight-height;
        x=(screenWidth-width)/2;

    }

    /**
     * Metoda określająca poruszanie obiektów

     */
    public void move(int screenWidth, int screenHeight) {


            if ((x < 0) && (y < 0)) {
                x = screenWidth / 2;
                y = screenHeight / 2;
            } else {

              y-=yVelocity;
              if(!falling)
                counter++;
              if(counter>10)
              {
                  falling=true;
                  counter = 0;
                  yVelocity=yVelocity*-1;
              }
            }

            // coordinate-x moving
            if(JUMP_LEFT)
                x-=xVelocity;

            if(JUMP_RIGHT)
                x+=xVelocity;


            //control out of the window
            if ((x > screenWidth))
                x=0;

            if(x < 0)
                x=screenWidth;

            if (y > screenHeight - height) {
                GameOver=true;
            }

    }

}
