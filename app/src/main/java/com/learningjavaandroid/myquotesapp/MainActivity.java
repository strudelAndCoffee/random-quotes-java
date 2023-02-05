package com.learningjavaandroid.myquotesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private Button showQuoteButton;
    private TextView quotesTextView;
    private TextView authorTextView;

    private String[] quotesList = QuotesList.text;
    private String[] authorsList = QuotesList.authors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quotesTextView = findViewById(R.id.quotesTextView);
        authorTextView = findViewById(R.id.authorTextView);

        showQuoteButton = findViewById(R.id.randomQuoteButton);
        showQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] quote = getRandomQuote();

                quotesTextView.setText(quote[0]);
                authorTextView.setText(quote[1]);
            }
        });
    }

    String[] getRandomQuote() {
        String text;
        String author;
        int arrLength = quotesList.length;
        int randomNum = ThreadLocalRandom.current().nextInt(arrLength);

        text = quotesList[randomNum];
        author = authorsList[randomNum];

        String[] quote = new String[] { text, author };

        return quote;
    }
}