package regan.hackru.tagger;

import android.location.Location;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMarshaller;

/**
 * Created by Regan on 4/16/2016.
 */
public class LocationMarshaller implements DynamoDBMarshaller<Location> {

    @Override
    public String marshall(Location loc) {
        return "(" + Double.toString(loc.getLatitude()) + ", " + Double.toString(loc.getLongitude()) + ")";
    }

    @Override
    public Location unmarshall(Class<Location> clazz, String s) {
        String[] loc = s.split(",");
        Location l = new Location("");

        String lat = loc[0].substring(1, loc[0].length()-1);
        String lng = loc[1].substring(1, loc[1].length()-2);

        l.setLatitude(Double.parseDouble(lat));
        l.setLongitude(Double.parseDouble(lng));

        return l;
    }
}
