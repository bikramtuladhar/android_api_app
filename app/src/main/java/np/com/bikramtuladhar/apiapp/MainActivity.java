package np.com.bikramtuladhar.apiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import java.util.Random;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

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

        Call<List<Quote>> call = apiService.getRandomQuote();

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Quote> quoteList = response.body();
                    Random random = new Random();
                    int randomIndex = random.nextInt(quoteList.size());
                    Quote quote = quoteList.get(randomIndex);

                    String quoteText = "\"" + quote.getQuote() + "\"\n- " + quote.getWebsiteUrl() +
                            " from " + quote.getCountry();
                    quoteTextView.setText(quoteText);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Quote>> call, @NonNull Throwable t) {
                Log.e(MainActivity.class.getName(), Objects.requireNonNull(t.getMessage()));

                quoteTextView.setText("Failed to fetch quote");
            }
        });
    }
}