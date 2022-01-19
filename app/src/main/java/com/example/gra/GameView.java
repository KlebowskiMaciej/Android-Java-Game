package com.example.gra;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.SurfaceView;


/**
 * * @author Maciej Kłębowski
 * * @version 1.0
 */
public class GameView extends SurfaceView implements Runnable {
    /**
     * Główna klasa odpowiedzialna za rozgrywkę
     */
    /**
     * Zmienne
     */
    private Thread thread;
    private int x=0,value=0,score=0,ResizePlatform=100;
    private final platform[] plat1;
    private final Paint paint;
    private final int screenWidth= Resources.getSystem().getDisplayMetrics().widthPixels;
    private final int screenHeight=Resources.getSystem().getDisplayMetrics().heightPixels;
    private final user user1;
    private final background background1;
    private final GameActivity activity;
    private final SharedPreferences prefs;

    /**
     * Konstruktor klasy
     * @param activity
     */
    public GameView(GameActivity activity)
    {

        super(activity);

        //constructors
        background1=new background(screenWidth,screenHeight,getResources());
        user1= new user(screenWidth,screenHeight,getResources());
        paint = new Paint();
        paint.setTextSize(128);
        paint.setColor(Color.BLACK);
        prefs=activity.getSharedPreferences("game",Context.MODE_PRIVATE);
        this.activity=activity;
        //how many platform we need to play.
        while(x<screenHeight)
        {
            value++;
            x+=100;
        }
        x=100;
        plat1= new platform[value];
        //set platforms
        PlatformXY();
    }

    /**
     * Metoda zawierająca pętle główną rozgrywki.
     */
    @Override
    public void run()
    {
        while(!user1.GameOver)
        {
            update();
            drawing_object();
            sleep();
        }
        activity.startActivity(new Intent(activity,MainActivity.class));
        setScore();
        activity.finish();
        score=0;
    }

    /**
     * Metoda odpowiedzialna za wznawianie rozgrywki.
     */
    public void resume()
    {
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Metoda pauzująca rozgrywkę.
     */
    public void pause()
    {
        try
        {
            thread.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Metoda odpowiedzialna za zmianę sytuacji w grze.
     */
    public void update()
    {
        // character movement
        user1.move(screenWidth,screenHeight);

        //collision of object
        for (platform Plat : plat1)
        {
               if((user1.x+user1.width>Plat.x)&&(user1.x<Plat.x+Plat.width/2)&&(user1.y+user1.height>Plat.y)&&(user1.y<Plat.y+Plat.height/2)&&(user1.yVelocity<0))
                {
                    user1.yVelocity=user1.yVelocity*-1;
                    user1.counter=0;
                    user1.falling=false;
                    score++;
                }
        }

        //lvl
        if(score==50)
            ResizePlatform=120;
        if(score==75)
        {
            ResizePlatform = 140;
            user1.yVelocity=20;
        }
        if(score==100)
            user1.GameOver=true;


        // scrolling the screen
        if(user1.y < 0)
        {
            user1.y = screenHeight - user1.height - user1.height / 4;
            PlatformXY();
        }

    }

    /**
     * Metoda odpowiedzilna za rysowanie obiektów na ekranie.
     */
    public void drawing_object()
    {
        if(getHolder().getSurface().isValid())
        {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background,background1.x,background1.y,paint);
            canvas.drawBitmap(user1.user1,user1.x,user1.y,paint);
            for (platform Plat : plat1)
                canvas.drawBitmap(Plat.platform1, Plat.x, Plat.y, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    /**
     * Metoda odpowiedzialna za zamrażanie rozgrywki na pewien okres czasu.
     */
    public void sleep()
    {
        try
        {
            Thread.sleep(17);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Metoda odpowiedzialna za poruszanie.
     * @param event
     * @return
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if(event.getX()<screenWidth/2)
            {
                user1.JUMP_LEFT=true;
                user1.JUMP_RIGHT=false;
            }
            else
            {
                user1.JUMP_RIGHT=true;
                user1.JUMP_LEFT=false;
            }
        }
        if (event.getAction() == MotionEvent.ACTION_UP)
        {
            user1.JUMP_LEFT=false;
            user1.JUMP_RIGHT=false;
        }
        return true;
    }

    /**
     * Metoda odpowiedzialna za pozycję platform.
     */
    private void PlatformXY()
    {
        for (int i = 0;i < value;i++)
        {
            platform Plat = new platform(getResources());
            plat1[i] = Plat;
            Plat.y=x;
            Plat.x=(int) (Math.random() * screenWidth);
            x+=ResizePlatform;
        }
        x=ResizePlatform;
    }

    /**
     * Metoda zapisująca punkty końcowe.
     */
    private void setScore()
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("score",score);
        editor.apply();
    }
}
