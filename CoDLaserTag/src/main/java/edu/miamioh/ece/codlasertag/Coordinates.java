/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miamioh.ece.codlasertag;

import java.io.StringWriter;
import javax.json.*;

/**
 *
 * @author Kyle
 */
public class Coordinates {
    private double latitude, longitude;
    private int accuracy;
    private JsonObject json;

    public JsonObject getJson() {
        return json;
    }
    
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getAccuracy() {
        return accuracy;
    }
    
    @Override
    public String toString()    {
        StringWriter writer = new StringWriter();
        Json.createWriter(writer).write(json);
        return writer.toString();
    }
    
    public Coordinates(double latitude, double longitude, int accuracy) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;
        json = Json.createObjectBuilder()
                .add("latitude", latitude)
                .add("longitude", longitude)
                .add("accuracy", accuracy)
                .build();
    }
    
    public Coordinates(JsonObject json) {
        this.json = json;
        this.longitude = json.getInt("longitude");
        this.latitude = json.getInt("latitude");
        this.accuracy = json.getInt("accuracy");
    }
    
    
}
