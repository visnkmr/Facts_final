package com.sortedcode.apps.Facts;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.text.method.ScrollingMovementMethod;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class intro4 extends Activity {
   ImageView introslide;
    TextView desc;
    TextView first;
    String[] introdesc = {"Swipe from left to right to view the previous fact.",
            "Swipe from right to left to view the next fact.",
            "You can anytime browse settings menu or share the fact or fact number from within options menu.",
            "From settings menu you can change background or enter fact number or view these slides again within help."
    };
    Integer[] imageId = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
    };
    String  begin = "Welcome to Facts!\n\nIn the following few slides you will be introduced on how to use and navigate within Facts!";
    private GestureDetectorCompat mGestureDetector;
    public String fcheck = "WFirstTime";
    SharedPreferences aboutact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro4);
        aboutact = getSharedPreferences(fcheck,0);
        SharedPreferences.Editor fceditor = aboutact.edit();
        fceditor.putBoolean("fvalue", true);
        fceditor.apply();
        introslide = (ImageView) findViewById(R.id.imageView2);
        desc = (TextView) findViewById(R.id.textView2);
        first = (TextView) findViewById(R.id.textView3);
        desc.setMovementMethod(new ScrollingMovementMethod());
        first.setText(begin);
        first.setVisibility(View.VISIBLE);
        desc.setMovementMethod(new ScrollingMovementMethod());
        desc.setVisibility(View.GONE);
        introslide.setVisibility(View.GONE);

        mGestureDetector = new GestureDetectorCompat(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }


            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                //left to right
                String  last = "You're all done with the intro.\nSwipe from right to left to proceed to the app!\n\nHave Fun..!\n- Facts! Team";
                if (e1.getX() < e2.getX()) {
                    if(first.getText().toString().equalsIgnoreCase( begin))
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),"Swipe from right to left to proceed",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 10, 0);
                        toast.show();
                    }
                    else if(desc.getText().toString().equalsIgnoreCase(introdesc[0])){
                        desc.setVisibility(View.GONE);
                        introslide.setVisibility(View.GONE);
                        first.setText( begin);
                        first.setVisibility(View.VISIBLE);
                    }
                    else if(desc.getText().toString().equalsIgnoreCase(introdesc[1])){
                        first.setText("");
                        first.setVisibility(View.GONE);
                        desc.setText(introdesc[0]);
                        desc.setVisibility(View.VISIBLE);
                        introslide.setImageResource(imageId[0]);
                        introslide.setVisibility(View.VISIBLE);
                    }
                    else if(desc.getText().toString().equalsIgnoreCase(introdesc[2])){
                        first.setText("");
                        first.setVisibility(View.GONE);
                        desc.setText(introdesc[1]);
                        desc.setVisibility(View.VISIBLE);
                        introslide.setImageResource(imageId[1]);
                        introslide.setVisibility(View.VISIBLE);
                    }
                    else if(desc.getText().toString().equalsIgnoreCase(introdesc[3])){
                        first.setText("");
                        first.setVisibility(View.GONE);
                        desc.setText(introdesc[2]);
                        desc.setVisibility(View.VISIBLE);
                        introslide.setImageResource(imageId[2]);
                        introslide.setVisibility(View.VISIBLE);
                    }
                    else if(first.getText().toString().equalsIgnoreCase( last))
                    {
                        first.setText("");
                        first.setVisibility(View.GONE);
                        desc.setText(introdesc[3]);
                        desc.setVisibility(View.VISIBLE);
                        introslide.setImageResource(imageId[3]);
                        introslide.setVisibility(View.VISIBLE);
                    }
                }

                if (e1.getX() > e2.getX()) {
                    //right to left swipe
                    if(first.getText().toString().equalsIgnoreCase( begin))
                    {
                        first.setText("");
                        first.setVisibility(View.GONE);
                        desc.setText(introdesc[0]);
                        desc.setVisibility(View.VISIBLE);
                        introslide.setImageResource(imageId[0]);
                        introslide.setVisibility(View.VISIBLE);
                    }
                    else if(desc.getText().toString().equalsIgnoreCase(introdesc[0])){

                        first.setText("");
                        first.setVisibility(View.GONE);
                        desc.setText(introdesc[1]);
                        desc.setVisibility(View.VISIBLE);
                        introslide.setImageResource(imageId[1]);
                        introslide.setVisibility(View.VISIBLE);
                    }
                    else if(desc.getText().toString().equalsIgnoreCase(introdesc[1])){
                        first.setText("");
                        first.setVisibility(View.GONE);
                        desc.setText(introdesc[2]);
                        desc.setVisibility(View.VISIBLE);
                        introslide.setImageResource(imageId[2]);
                        introslide.setVisibility(View.VISIBLE);
                    }
                    else if(desc.getText().toString().equalsIgnoreCase(introdesc[2])){
                        first.setText("");
                        first.setVisibility(View.GONE);
                        desc.setText(introdesc[3]);
                        desc.setVisibility(View.VISIBLE);
                        introslide.setImageResource(imageId[3]);
                        introslide.setVisibility(View.VISIBLE);
                    }
                    else if(desc.getText().toString().equalsIgnoreCase(introdesc[3]))
                    {

                        introslide.setVisibility(View.GONE);
                        first.setText( last);
                        first.setVisibility(View.VISIBLE);
                        desc.setText("");
                        desc.setVisibility(View.GONE);
                    }
                    else if(first.getText().toString().equalsIgnoreCase( last))
                    {
                        finish();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                    }
                return true;
            }
        });
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
    protected void onDestroy() {
        finish();
        super.onDestroy();
    }
    public void onBackPressed() {
    }
}
