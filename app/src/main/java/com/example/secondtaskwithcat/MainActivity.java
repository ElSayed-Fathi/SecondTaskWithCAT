package com.example.secondtaskwithcat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextOfnNmberET;
    TextView textViewOfDisplayTV;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextOfnNmberET = findViewById(R.id.numberET);
        textViewOfDisplayTV = findViewById(R.id.displayTV);
        btn1 = findViewById(R.id.showTheTextBTN);
        btn2 = findViewById(R.id.searchTheWebBTN);


    }// end of onCreat()

    //==============================================================================================
    public void showTheText(View view) {
        String getTextString = editTextOfnNmberET.getText().toString();
        if (getTextString.isEmpty()) {

            editTextOfnNmberET.setError("Please enter a number");
        } else {
            textViewOfDisplayTV.setText(getTextString);
        }

    }// end of showTheText()

    //==================================================================================================
    public void searchTheWeb(View view) {

        String url = editTextOfnNmberET.getText().toString();


        if (url.isEmpty()) {
            editTextOfnNmberET.setError("Please enter a valid number");
        } else {
            if (isNumeric(url)) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, url);
                startActivity(intent);

            } else {
                editTextOfnNmberET.setError("Please enter a valid number");
            }

        }

    }// end of searchTheWeb()

    //==================================================================================================
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }// end of isNumeric()

}//end of activity
