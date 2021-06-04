package com.xeant.httpasynctask;

public class Weather {
    private String country;
    private String weather;
    private String temperature;

    @Override
    public String toString() {
        return "Weather{" +
                "country='" + country + '\'' +
                ", weather='" + weather + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Weather(String country, String weather, String temperature) {
        this.country = country;
        this.weather = weather;
        this.temperature = temperature;
    }
}
