package com.example.bonz.exampleactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Bonz on 8/14/2016.
 */
public class Example3TopFragment extends Fragment {
    private EditText inputTopImageText;
    private EditText inputBottomImageText;

    private Example3Activity example3Activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Đọc file xml tạo ra đối tượng View.

        // inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)
        View view = inflater.inflate(R.layout.activity_example3_top, container, false);
        inputTopImageText = (EditText)view.findViewById(R.id.input_top_image_text);
        inputBottomImageText = (EditText)view.findViewById(R.id.input_bottom_image_text);

        Button applyButton = (Button) view.findViewById(R.id.button_apply);

        applyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                applyText();
            }
        });

        return view;
    }

    // Phương thức này được gọi sau khi Fragment được
    // ghép vào Activity.

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Example3Activity)  {
            this.example3Activity= (Example3Activity) context;
        }
    }

    private void applyText()  {
        String topText = this.inputTopImageText.getText().toString();
        String bottomText = this.inputBottomImageText.getText().toString();

        this.example3Activity.showText(topText, bottomText);
    }
}
