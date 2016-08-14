package com.example.bonz.exampleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Example2Activity extends AppCompatActivity {

    private TextView textEvt1;
    private TextView textEvt2;

    public static final String TAG ="MyMessage";

    // Bộ dò cử chỉ của người dùng.
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        //
        this.textEvt1 = (TextView)this.findViewById(R.id.my_text_evt1);
        this.textEvt2 = (TextView)this.findViewById(R.id.my_text_evt2);

        GestureDetector.OnGestureListener gestureListener = new MyOnGestureListener();
        GestureDetector.OnDoubleTapListener doubleTapListener = new MyOnDoubleTapListener();

        // GestureDetectorCompat(Context context, OnGestureListener listener)
        this.gestureDetector = new GestureDetector(this, gestureListener);
        this.gestureDetector.setOnDoubleTapListener(doubleTapListener);

        // Lấy ra đối tượng View gốc (Toàn bộ màn hình điện thoại).
        View rootView = this.findViewById(android.R.id.content).getRootView();

        // Sét bộ lắng nghe cho các sự kiện chạm vào bề mặt điện thoại.
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });

    }

    class MyOnGestureListener implements GestureDetector.OnGestureListener{

        @Override
        public boolean onDown(MotionEvent e) {
            textEvt1.setText("onDown");
            textEvt2.setText(e.getX()+":"+ e.getY());
            Log.e(TAG, "onDown");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            textEvt1.setText("onShowPress");
            textEvt2.setText(e.getX()+":"+ e.getY());
            Log.e(TAG, "onShowPress");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            textEvt1.setText("onSingleTapUp");
            textEvt2.setText(e.getX()+":"+ e.getY());
            Log.e(TAG, "onSingleTapUp");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float v, float v1) {
            textEvt1.setText("Scroll");
            textEvt2.setText(e1.getX()+":"+ e1.getY() +" "+ e2.getX()+":"+ e2.getY());
            Log.e(TAG, "onScroll");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            textEvt1.setText("onLongPress");
            textEvt2.setText(e.getX()+":"+ e.getY());
            Log.e(TAG, "onLongPress");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
            textEvt1.setText("onFling");
            textEvt2.setText(e1.getX() + ":" + e1.getY() + "  " + e2.getX() + ":" + e2.getY());
            Log.e(TAG, "onFling");
            return true;
        }
    }

    class MyOnDoubleTapListener implements GestureDetector.OnDoubleTapListener{

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            textEvt1.setText("onSingleTapConfirmed");
            textEvt2.setText(e.getX()+":"+ e.getY());
            Log.e(TAG, "onSingleTapConfirmed");
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            textEvt1.setText("onDoubleTap");
            textEvt2.setText(e.getX()+":"+ e.getY());
            Log.e(TAG, "onDoubleTap");
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            textEvt1.setText("onDoubleTapEvent");
            textEvt2.setText(e.getX() + ":" + e.getY());
            Log.e(TAG, "onDoubleTapEvent");
            return true;
        }
    }
}
