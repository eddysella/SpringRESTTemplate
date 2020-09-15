package Resources.HTTPClient;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

class RequestClient {

    RequestClient() {}

    public String makeRequest(String url) throws MalformedURLException {
        return executeRequest( buildRequest( buildHttpUrl(url)));
    }

    private HttpUrl buildHttpUrl(String url) {
        return HttpUrl.parse(url).newBuilder().build();
    }

    public String makeRequest(String url, Map<String, String> queryParameters) throws MalformedURLException {
        return executeRequest( buildRequest( buildHttpUrl(url, queryParameters)));
    }

    private HttpUrl buildHttpUrl(String url, Map<String, String> queryParameters) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        setQueryParameters(queryParameters, urlBuilder);
        return urlBuilder.build();
    }

    public String makeRequest(String host, List<String> segments, Map<String, String> queryParameters) throws MalformedURLException {
        return executeRequest( buildRequest( buildHttpUrl(host, segments, queryParameters)));
    }

    private HttpUrl buildHttpUrl(String host, List<String> segments, Map<String, String> queryParameters) {
        HttpUrl.Builder urlBuilder = new HttpUrl.Builder();
        urlBuilder.scheme("http");
        urlBuilder.host(host);

        setPathSegments(segments, urlBuilder);
        setQueryParameters(queryParameters, urlBuilder);

        return urlBuilder.build();
    }

    private Request buildRequest(HttpUrl httpUrl) {
        return new Request.Builder()
                .url(httpUrl)
                .build();
    }

    private String executeRequest(Request request) throws MalformedURLException {
        int responseCode = -1;
        String responseBody = null;
        Response response;

        try {
            response = new OkHttpClient().newCall(request).execute();
            responseCode = response.code();
            responseBody = response.body().string();
        } catch (IOException e) {}

        if (responseCode == 200) {
            return responseBody;
        } else {
            throw new MalformedURLException("HTTP call response code: " + responseCode);
        }
    }

    public HttpUrl.Builder setPathSegments(List<String> segments, HttpUrl.Builder urlBuilder){
        for(String segment : segments){
            urlBuilder.addPathSegment(segment);
        }
        return urlBuilder;
    }

    public HttpUrl.Builder setQueryParameters(Map<String, String> queryParameters, HttpUrl.Builder urlBuilder){
        for (Map.Entry<String,String> entry : queryParameters.entrySet()) {
            urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
        }
        return urlBuilder;
    }
}
