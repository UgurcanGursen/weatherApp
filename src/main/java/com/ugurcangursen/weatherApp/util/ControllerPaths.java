package com.ugurcangursen.weatherApp.util;

public final class ControllerPaths {

    private static final String BASE_PATH = "/u";

    public static final class UserCtrl {
        public static final String CTRL = BASE_PATH + "/users";
    }

    public static final class WeatherCtrl {
        public static final String CTRL = BASE_PATH + "/weather";
    }

    public static final class CityCtrl {
        public static final String CTRL = BASE_PATH + "/city";
    }
}
