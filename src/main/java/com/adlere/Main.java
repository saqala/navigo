package com.adlere;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static final String MISSING_ARGUMENTS = "missing arguments";

    public static void main(String[] args) throws IOException {

        if (args == null || args.length != 2) throw new RuntimeException(MISSING_ARGUMENTS);

        Journey journey = new Gson().fromJson(new BufferedReader(new FileReader(args[0])), Journey.class);

        JourneySummary journeySummary = new JourneySummary(journey.calculateCustomerTrips());

        new ObjectMapper().writeValue(new File(args[1]), journeySummary);

    }
}
