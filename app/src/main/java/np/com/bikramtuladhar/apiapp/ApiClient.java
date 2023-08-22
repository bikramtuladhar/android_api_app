package np.com.bikramtuladhar.apiapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://animechan.xyz/api/";

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static AnimeApiService getApiService() {
        return retrofit.create(AnimeApiService.class);
    }
}