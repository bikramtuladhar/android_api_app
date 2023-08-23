package np.com.bikramtuladhar.apiapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeApiService {
    @GET("v1/breweries/random")
    Call<List<Quote>> getRandomQuote();
}