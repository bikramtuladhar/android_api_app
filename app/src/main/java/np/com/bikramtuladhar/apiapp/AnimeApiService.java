package np.com.bikramtuladhar.apiapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeApiService {
    @GET("random")
    Call<Quote> getRandomQuote();
}