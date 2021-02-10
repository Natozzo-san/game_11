package com.example.myapplication002;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this,null));
        MyView mv = new MyView(this, null);

        mv.setOnTouchListener((view, event) -> {
            MyView mv1 = (MyView) view;
            mv1.xvv = event.getX();
            mv1.yvv = event.getY();
            mv1.xdel = mv1.xvv - mv1.x;
            mv1.ydel = mv1.yvv - mv1.y;
            mv1.absxdel = Math.abs(mv1.xdel);
            mv1.absydel = Math.abs(mv1.ydel);
            if (mv1.absxdel>mv1.absydel){
                double otnXtoY=mv1.absydel / mv1.absxdel;
                float flootnXtoY = (float)otnXtoY;
                double two = 2;
                double spdoubley = (1/ (Math.pow(otnXtoY, two) + 1));
                mv1.absxdel = (float)spdoubley;
                mv1.absydel = flootnXtoY*mv1.absxdel;
            }
            if (mv1.absxdel<=mv1.absydel){
                double otnXtoY=mv1.absxdel / mv1.absydel;
                float flootnXtoY = (float)otnXtoY;
                double two = 2;
                double spdoubley = (1/ (Math.pow(otnXtoY, two) + 1));
                mv1.absydel = (float)spdoubley;
                mv1.absxdel = flootnXtoY*mv1.absydel;
            }
            if (mv1.xdel>=0 && mv1.ydel>=0){
                mv1.xspeed = mv1.absxdel*4;
                mv1.yspeed = mv1.absydel*4;
            }
            if (mv1.xdel>=0 && mv1.ydel<0){
                mv1.xspeed = mv1.absxdel*4;
                mv1.yspeed = -mv1.absydel*4;
            }
            if (mv1.xdel<0 && mv1.ydel>=0){
                mv1.xspeed = -mv1.absxdel*4;
                mv1.yspeed = mv1.absydel*4;
            }
            if (mv1.xdel<0 && mv1.ydel<0){
                mv1.xspeed = -mv1.absxdel*4;
                mv1.yspeed = -mv1.absydel*4;
            }
            return false;
        });
        setContentView(mv);

        float mX, mY;
        final float TOUCH_TOLERANCE = 4;

    }
}
