package com.andre.ec4.interfaz;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AmiiboApiService {
    @GET("amiibo")
    Call<AmiiboResponse> getAmiibos();
}
