package com.util;

import com.sam.SmsBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface ISmsApiService {

    @Headers({
            "Content-Type: application/json",
    })
    @POST("smstraffic/getsmsapicntms.php")
    Call<String> sendMessage(@Body String jsonPayload);

}
