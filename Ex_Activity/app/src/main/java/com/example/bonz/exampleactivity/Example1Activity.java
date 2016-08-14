package com.example.bonz.exampleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Example1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        Intent intent = getIntent();

        // Tham số trong Intent truyền sang từ MainActivity
        String value1 = intent.getStringExtra("text1");

        // Tham số trong Intent truyền sang từ MainActivity
        String value2 = intent.getStringExtra("text2");

        // Lấy ra đối tượng trên giao diện bởi ID của nó.
        final TextView text1 = (TextView)this.findViewById(R.id.my_text1);
        final TextView text2 = (TextView)this.findViewById(R.id.my_text2);

        text1.setText(value1);
        text2.setText(value2);

        Button button  = (Button)this.findViewById(R.id.my_button1);

        // Sử lý sự kiện khi click vào Button.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText("You click button");
            }
        });

        // Sử lý sự kiện khi click vào Button và giữ lâu.
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                text2.setText("You long click button");
                return true;
            }
        });

    }
}