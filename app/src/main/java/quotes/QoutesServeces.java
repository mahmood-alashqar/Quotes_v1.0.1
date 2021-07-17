package quotes;

import com.google.common.reflect.TypeToken;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;

public class QoutesServeces {
    String apiData;
    HttpURLConnection connection;
    public int setConnectionAPI(String url) throws IOException {
        //Set up new connection to read fro API link
        connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.setRequestMethod("GET");
return connection.getResponseCode();
    }


    // create a reader to read from file
    public boolean setApiGson(String Path) throws IOException {
        //To read data from API we use stream reader then add it to buffered reader
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        apiData = bufferedReader.readLine();
        System.out.println(apiData);
        bufferedReader.close();
        Gson gson2 = new Gson();
        QuotesApi qoute = gson2.fromJson(apiData, QuotesApi.class);
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(
                new FileReader(Path));
        ArrayList<Quotes> testCase = gson.fromJson(br, new TypeToken<ArrayList<Quotes>>() {
        }.getType());
        int radnomQuote = (int) (Math.random() * (testCase.size() - 1));
        System.out.println("Name Of Author: " + qoute.getQuoteAuthor());
        System.out.println("The Quote : " + qoute.getQuotesText());
        System.out.println("Quote number : " + radnomQuote);
        // To save coming data from API in our file
        Quotes NewQuote = new Quotes(qoute.getQuoteAuthor(), qoute.getQuotesText());
        testCase.add(NewQuote);
        String json = gson.toJson(testCase);
        BufferedWriter bw = new BufferedWriter(new FileWriter(Path));
        bw.write(json);
        bw.close();
        System.out.println("kkkkkk"+json.isEmpty());
        System.out.println("the quote is >>> " + qoute.getQuoteAuthor());
        System.out.println("the text is >>> " + qoute.getQuotesText());
       return json.isEmpty();
    }

    public boolean ifConnectionWentWrong(String Path) throws IOException {
        boolean checking = false;
        Gson gson = new Gson();
        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get(Path));
        BufferedReader br = new BufferedReader(
                new FileReader(Path));
if(br.ready()){checking = true;}
        //convert the json string back to object
        Quotes[] testCase = gson.fromJson(br, Quotes[].class);
        int radnomQuote = (int) (Math.random() * (testCase.length - 1));
        System.out.println("Name Of Author: " + testCase[radnomQuote].getAuthor());
        System.out.println("The Quote : " + testCase[radnomQuote].getText());
        System.out.println("Quote number : " + radnomQuote);
return checking;
    }

}
