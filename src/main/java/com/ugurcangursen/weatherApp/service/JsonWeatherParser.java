package com.ugurcangursen.weatherApp.service;

import com.ugurcangursen.weatherApp.entity.Weather;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Iterator;

public class JsonWeatherParser {

    private final JSONParser parser = new JSONParser();
    private String jsonToParsing;

    public void setJsonToParsing(String jsonToParsing) {
        this.jsonToParsing = jsonToParsing;
    }

    public Weather getWeather() throws ParseException, JSONException, java.text.ParseException {
        Weather weather = new Weather();
        Object obj = parser.parse(jsonToParsing);

        JSONObject mainJsonObj = (JSONObject) obj;
        JSONObject mainConditionsArray = (JSONObject) mainJsonObj.get("main");
        JSONObject sysArray = (JSONObject) mainJsonObj.get("sys");

        /* Parsing JSONArray */
        JSONArray weatherArray = (JSONArray) mainJsonObj.get("weather");
        Iterator<JSONObject> i = weatherArray.iterator();

        while (i.hasNext()) {
            JSONObject arrayValue = (JSONObject) i.next();
            String description = (String) arrayValue.get("description");
            String weatherID = String.valueOf(arrayValue.get("id"));
            String icon = String.valueOf(arrayValue.get("icon"));
            weather.setIcon(icon);
            weather.setDescription(description);
            weather.setWeatherID(weatherID);
        }


        weather.setTemperature(getTemperatureDescription(mainConditionsArray));
        weather.setHumidity(getJsonIntegerObjectDescription(mainConditionsArray, "humidity"));
        weather.setPressure(getJsonIntegerObjectDescription(mainConditionsArray, "pressure"));
        weather.setCity(String.valueOf(mainJsonObj.get("name")));


        try {
            /* Get date, sunrise and sunset times from unix epoch values */
            Long sunrise = Long.parseLong(getJsonLongObjectDescription(sysArray, "sunrise"));
            String sunriseTime = new java.text.SimpleDateFormat("HH:mm")
                    .format(new java.util.Date(sunrise * 1000));

            String queryTime = new java.text.SimpleDateFormat("dd-MM-yyyy' 'HH:mm:ss")
                    .format(new java.util.Date());

            Long sunset = Long.parseLong(getJsonLongObjectDescription(sysArray, "sunset"));
            String sunsetTime = new java.text.SimpleDateFormat("HH:mm")
                    .format(new java.util.Date(sunset * 1000));

            weather.setCountry(String.valueOf(sysArray.get("country")));
            weather.setSunriseTime(sunriseTime);
            weather.setSunsetTime(sunsetTime);
            weather.setDate(queryTime);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        return weather;

    }

    private String getTemperatureDescription(JSONObject jsonObject) throws NumberFormatException, JSONException {
        Double temp = new Double((jsonObject.get("temp")).toString());
        return (temp > 0 ? "+" : "") + String.valueOf(Math.round(temp - 273.15));
    }

    private String getJsonIntegerObjectDescription(JSONObject jsonObject, String valueName) {
        int jsonValue = new Integer(jsonObject.get(valueName).toString());
        return String.valueOf(jsonValue);
    }

    private String getJsonLongObjectDescription(JSONObject jsonObject, String valueName) {
        Long jsonValue = new Long(jsonObject.get(valueName).toString());
        return String.valueOf(jsonValue);
    }

}
