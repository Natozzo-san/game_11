package com.example.myapplication002;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    float yspeed = -4;
    float xspeed = 0;
    float x = 750,y=2000;
    float r = 40;
    float xvv = 0;
    float yvv = 0;
    float xdel = 0, absxdel=0;
    float ydel = 0, absydel=0;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(getResources().getColor(R.color.bluee));
        p.setStyle(Paint.Style.FILL);
        y= y + yspeed;
        x = x + xspeed;
        canvas.drawCircle(x,y,r,p);
        this.invalidate();
    }
}