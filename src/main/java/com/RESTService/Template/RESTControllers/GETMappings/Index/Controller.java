package com.RESTService.Template.RESTControllers.GETMappings.Index;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "IndexController")
class Controller {

    @GetMapping(value = "/")
    ResponseEntity<String> getIndex() {
        String output =
                "Welcome to a Weather REST API service. \n" +
                        "The following endpoints are available: \n" +
                        "1) GET: /weatherRoute - Returns a JSON response with the weather for each city in a specified route \n" +
                        "\tQuery Params: \n" +
                        "\ta) date: the date of travel (i.e. dd-MM-yyyy), must be within the next 5 days (including today) \n" +
                        "\tb) cities: one/multiple city key(s) separated by character encoding of '&' == '%26' i.e. cityKey%26cityKey\n" +
                        "\t\tcity keys found at: https://github.com/eddysella/WeatherAPI/blob/master/src/main/java/edoardosella/WeatherAPI/Resources/accuweather-city-keys.txt " +
                        "by searching for a country and looking for the 'Key' property above it \n " +
                        "\t\ti.e. if searching for 'Dhaka': \n" +
                        "\t\t'key' : '28143'  <--- KEY \n " +
                        "\t\t'Type' : 'City' \n" +
                        "\t\t'Rank' : 10 \n" +
                        "\t\t'LocalizedName' : 'Dhaka' \n" +
                        "\t\t'EnglishName' : 'Dhaka'  <---- Search Result \n" +
                        "\tc) apikey: an API key from :  https://developer.accuweather.com/packages (limited trial should suffice) \n" +
                        "2) GET: /lastFiveWeatherRoutes - Returns the JSON response for each of the last 5 routes which were queried \n" +
                        "3) DELETE: /lastFiveWeatherRoutes - Deletes all previously stored queries from the database";

        return ResponseEntity.ok(output);
    }
}
