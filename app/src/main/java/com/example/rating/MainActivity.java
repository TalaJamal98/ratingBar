package com.example.rating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private RatingBar bar;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar=findViewById(R.id.bar);
        final float[] curRate = {bar.getRating()};
        bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                count = count+1;
                DecimalFormat decimalFormat = new DecimalFormat("#.#");

                // Get Current rating
                curRate[0] = Float.valueOf((curRate[0]
                        * count + rating)
                        / ++count);

                // Showing a toast of current rating
                Toast.makeText(MainActivity.this,
                        "New Rating: " + curRate[0], Toast.LENGTH_SHORT)
                        .show();

                bar.setRating(curRate[0]);

            }
        });


    }


}