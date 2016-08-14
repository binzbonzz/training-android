package com.example.bonz.exampleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Example3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example3);

    }


    public void showText(String topImageText, String bottomImageText)  {
        Example3BottomFragment bottomFragment;
        bottomFragment = (Example3BottomFragment)this.getSupportFragmentManager().findFragmentById(R.id.example3_bottom_fragment);
        bottomFragment.showText(topImageText, bottomImageText);
    }
}