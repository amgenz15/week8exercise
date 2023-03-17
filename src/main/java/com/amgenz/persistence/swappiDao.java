package com.amgenz.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swappi.Planet;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class swappiDao {

    public Planet getPlanet() {
        Client client = ClientBuilder.newClient();
        //TODO read in the uri from a properties file
        WebTarget target =
                client.target("https://swapi.dev/api/planets/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Planet planet = null;
        try {
            planet = mapper.readValue(response, Planet.class);
        } catch (JsonProcessingException e) {
            //TODO add logging and write this to the log
            throw new RuntimeException(e);
        }

        return planet;
    }
}
