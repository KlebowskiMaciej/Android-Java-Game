package com.example.gra;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;


public class GameView extends SurfaceView implements Runnable {
    float dy=0;
    private Thread thread;
    private Paint paint;
    private boolean isPlaying;
    private int ScreenX, ScreenY;
    public static float ScreenRatioX, ScreenRatioY;

    private user user1;
    private background background1;
    public GameView(Context context,int ScreenX,int ScreenY)
    {

        super(context);
        this.ScreenX=ScreenX;
        this.ScreenY=ScreenY;
        ScreenRatioX=1920f/ScreenX;
        ScreenRatioY=1080f/ScreenY;
        background1=new background(ScreenX,ScreenY,getResources());
        user1= new user(ScreenX,ScreenY,getResources());
        paint = new Paint();
    }

    @Override
    public void run() {
        while(isPlaying)
        {
            update();
            draw();
            sleep();
        }
    }

    public void resume()
    {
        isPlaying=true;
        thread = new Thread(this);
        thread.start();
    }
    public void pause()
    {
        try {
            isPlaying=false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void update()
    {
        dy+=0.2*ScreenRatioY;
        user1.y+=dy;
        if(user1.y>500*ScreenRatioY)
            dy=-10*ScreenRatioY;

        //przesuwanie ekranu
        if(user1.isGoingLEFT)
        {
            user1.x+=30*ScreenRatioX;
        }
        if(user1.isGoingRIGHT)
        {
            user1.x-=30*ScreenRatioX;
        }




    }
    public void draw()
    {
        if(getHolder().getSurface().isValid())
        {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background,background1.x,background1.y,paint);
            canvas.drawBitmap(user1.user1,user1.x,user1.y,paint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }
    public void sleep()
    {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

  /*  @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(event.getX()<ScreenX /2)
                {
                    user1.isGoingRIGHT=false;
                    user1.isGoingLEFT =true;

                }
                break;
            case MotionEvent.ACTION_UP:
                    user1.isGoingLEFT =false;
                    user1.isGoingRIGHT=true;
                break;
        }

        return true;
    }*/
}
