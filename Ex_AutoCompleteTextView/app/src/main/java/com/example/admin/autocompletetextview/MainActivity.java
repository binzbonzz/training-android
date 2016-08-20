package com.example.admin.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textFullname;
    private AutoCompleteTextView textCountry;
    private MultiAutoCompleteTextView textProgrammingLanguage;
    private Button buttonSubmit;

    private String[] countries = {"Vietnam","England","Canada", "France","Australia", "AAAAA"};

    private String[] languages={"Java ","CSharp","Visual Basic","Swift","C/C++"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        textFullname = (EditText) findViewById(R.id.editText);
        textCountry = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        textProgrammingLanguage = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        buttonSubmit = (Button) findViewById(R.id.button);

        ArrayAdapter adapterCountries = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);

        textCountry.setAdapter(adapterCountries);

        // Sét đặt số ký tự nhỏ nhất, để cửa sổ gợi ý hiển thị
        textCountry.setThreshold(1);

        ArrayAdapter adapterLanguages = new ArrayAdapter(this, android.R.layout.simple_list_item_1, languages);

        textProgrammingLanguage.setAdapter(adapterLanguages);
        textProgrammingLanguage.setThreshold(1);

        // Các đoạn text ngăn cách nhau bởi dấu phẩy.
        textProgrammingLanguage.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String text="Fullname: "+ this.textFullname.getText().toString()
                +"\nCountry: "+ this.textCountry.getText().toString()
                +"\nLanguages: "+ this.textProgrammingLanguage.getText().toString();

        Toast.makeText(this, text, Toast.LENGTH_LONG).show();

    }


}
