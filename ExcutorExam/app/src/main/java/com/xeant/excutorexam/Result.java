package com.xeant.excutorexam;

import java.net.HttpURLConnection;
import java.net.URL;

// Result.java

public abstract class Result<T> {
    private Result() {}

    // Success data를 담을 수 있도록
    // 생성자에 데이터를 담을 수 있게
    public static final class Success<T> extends Result<T> {
        public T data;

        public Success(T data) {
            this.data = data;
        }
    }


    // Error Exception 을 담을 수 있도록록
    public satic final class Error<T> extends Result<T> {
        public Exception exception;

        public Error(Exception exception) {
            this.exception = exception;
        }
    }
}

// LoginRepository.java
public class LoginRepository {

    private final String loginUrl = "https://example.com/login";
    private final LoginResponseParser responseParser;

    public LoginRepository(LoginResponseParser responseParser) {
        this.responseParser = responseParser;
    }

    public Result<LoginResponse> makeLoginRequest(String jsonBody) {
        try {
            URL url = new URL(loginUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpConnection.setRequestProperty("Accept", "application/json");
            httpConnection.setDoOutput(true);
            httpConnection.getOutputStream().write(jsonBody.getBytes("utf-8"));

            LoginResponse loginResponse = responseParser.parse(httpConnection.getInputStream());
            return new Result.Success<LoginResponse>(loginResponse);
        } catch (Exception e) {
            return new Result.Error<LoginResponse>(e);
        }
    }
}