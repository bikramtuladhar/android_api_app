package np.com.bikramtuladhar.apiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.textView);
        Button fetchButton = findViewById(R.id.fetchNewQuoteButton);

        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchRandomQuote();
            }
        });

        fetchRandomQuote();
    }

    private void fetchRandomQuote() {
        AnimeApiService apiService = ApiClient.getApiService();

        Call<Quote> call = apiService.getRandomQuote();

        call.enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Quote quote = response.body();
                    String quoteText = "\"" + quote.getQuote() + "\"\n- " + quote.getCharacter() +
                            " from " + quote.getAnime();
                    quoteTextView.setText(quoteText);
                }
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                quoteTextView.setText("Failed to fetch quote");
            }
        });
    }
}