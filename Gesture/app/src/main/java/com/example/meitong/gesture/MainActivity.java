package com.example.meitong.gesture;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener{
    private GestureLibrary library;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        library= GestureLibraries.fromRawResource(this,R.raw.gestures);
        if(!library.load()){
            finish();
        }
        GestureOverlayView gesture = findViewById(R.id.gestures);
        gesture.addOnGesturePerformedListener(this);
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> gestures = library.recognize(gesture);
        int index = 0;
        double score = 0.0;
        for(int i = 0; i < gestures.size(); i++){
            Prediction result = gestures.get(i);
            if(result.score > score){
                index = i;
                score = result.score;
            }
        }
        Toast toast = Toast.makeText(this, gestures.get(index).name,Toast.LENGTH_LONG);
        LinearLayout linearLayout = (LinearLayout) toast.getView();

        TextView messageTextView = (TextView) linearLayout.getChildAt(0);

        messageTextView.setTextSize(40);
        toast.show();
    }
}
