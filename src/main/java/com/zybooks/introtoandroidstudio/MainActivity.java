package com.zybooks.introtoandroidstudio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText nameText;
    private TextView textGreeting;
    private Button SayHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get instance of nameText
        nameText = (EditText) findViewById(R.id.nameText);
        // get instance of textGreeting
        textGreeting = (TextView) findViewById(R.id.textGreeting);
        // get Instance of SayHello
        SayHello = (Button) findViewById(R.id.buttonSayHello);
        // initially disabled say hello button
        SayHello.setEnabled(false);

        // attach text change listener for nameText
        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                // check nameText contains a string or not
                if (s.toString().equals("")){ // if not contain
                    SayHello.setEnabled(false); // disable sayHello button
                } else {
                    SayHello.setEnabled(true); // enable sayHello button
                }
            }
        });
    }

    /**
     * onclick listener for button SayHello
     * @param v of {@link View]}
     */
    public void SayHello(View v){
        String name = nameText.getText().toString();
        if (name.equals("")){
            textGreeting.setText("You must enter a name"); // update text greeting
        }else {
            textGreeting.setText("Hello, "+name+"!"); // update text greeting
        }
    }
}