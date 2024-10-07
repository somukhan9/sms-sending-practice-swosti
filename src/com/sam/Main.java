package com.sam;

import com.util.ISmsApiService;
import com.util.RetrofitClientForSms;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Main {
    private boolean sentSms = false;


    public boolean isSmsSent(String mobileNo, String msg) throws InterruptedException {
        String userId = "01833168230";
        String passKey = "NXhQSW45ZGw=";

        System.err.println("USER ID = " + userId + "\n" + "PASS = " + passKey);

        String senderId = "180";

        String maskingTitle = "SBK_F";

        String type = "T";

        if (mobileNo.startsWith("880"))
            mobileNo = mobileNo.replaceFirst("^88", "");

        if (mobileNo.startsWith("018") || mobileNo.startsWith("016"))
            maskingTitle = "SBKF";

        // Construct the JSON string
        String jsonString = String.format(
                "{\n" + "  \"recipients\": {\n" + "    \"phone\": \"%s\"\n" + "  },\n" + "  \"sms\": {\n"
                        + "    \"userid\": \"%s\",\n" + "    \"senderid\": \"%s\",\n" + "    \"passkey\": \"%s\",\n"
                        + "    \"maskingtitle\": \"%s\",\n" + "    \"content\": {\n" + "      \"type\": \"%s\",\n"
                        + "      \"text\": \"%s\"\n" + "    }\n" + "  }\n" + "}",
                mobileNo, userId, senderId, passKey, maskingTitle, type, msg);

        ISmsApiService apiService = RetrofitClientForSms.getInstance().create(ISmsApiService.class);

        Call<String> call = apiService.sendMessage(jsonString);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                // TODO Auto-generated method stub
                sentSms = response.isSuccessful();
                if (response.isSuccessful()) {
                    System.out.println("Request was successful. " + sentSms);
                } else {
                    System.out.println("Request failed with status code: " + response.code());
                }


            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                // TODO Auto-generated method stub
                sentSms = false;
                t.printStackTrace();

            }
        });


        try {
            // Delay for 3 seconds (3000 milliseconds)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sentSms;
    }


    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();

        boolean isSent = main.isSmsSent("8801303456640", "Your Balance is $10");

        System.out.println(isSent);

        if (isSent) {
            System.out.println("================SENT================");
        }
    }
}