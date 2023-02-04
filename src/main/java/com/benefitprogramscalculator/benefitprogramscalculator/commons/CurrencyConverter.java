package com.benefitprogramscalculator.benefitprogramscalculator.commons;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class CurrencyConverter {
    public  Float convertToEuros(Float valueInReais) throws Exception {
        URL url = new URL("https://api.exchangerate-api.com/v4/latest/BRL");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        Float exchangeRate = (new JSONObject(content.toString()))
                .getJSONObject("rates")
                .getFloat("EUR");

        Float euroValue = valueInReais * exchangeRate;
        System.out.println("Euro value today: " + euroValue.shortValue());
        return valueInReais * exchangeRate;
    }
}
