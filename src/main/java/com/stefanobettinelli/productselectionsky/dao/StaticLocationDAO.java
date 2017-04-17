package com.stefanobettinelli.productselectionsky.dao;

import com.stefanobettinelli.productselectionsky.exceptions.InvalidSkyIdException;
import com.stefanobettinelli.productselectionsky.model.IntegerSkyId;
import com.stefanobettinelli.productselectionsky.model.Location;
import com.stefanobettinelli.productselectionsky.model.SimpleLocation;
import com.stefanobettinelli.productselectionsky.model.SkyId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticLocationDAO implements entityDAO{

    public final static SkyId LONDON_LOCATION_ID = IntegerSkyId.getNewId(1);
    public final static SkyId LIVERPOOL_LOCATION_ID = IntegerSkyId.getNewId(2);

    private final static Map<SkyId, Location> LOCATION_MAP = new HashMap<>();

    static {
        Location londonLocation = new SimpleLocation(LONDON_LOCATION_ID, "London");
        Location liverpoolLocation = new SimpleLocation(LIVERPOOL_LOCATION_ID, "Liverpool");
        LOCATION_MAP.putIfAbsent(londonLocation.getId(), londonLocation);
        LOCATION_MAP.putIfAbsent(liverpoolLocation.getId(), liverpoolLocation);
    }

    public static List<Location> getLocations() {
        return new ArrayList<>(LOCATION_MAP.values());
    }

    public static Location getLocationById(SkyId locationId){
        return LOCATION_MAP.get(locationId);
    }

    @Override
    public List loadAll() {
        return null;
    }

    @Override
    public Object loadById(SkyId id) {
        return null;
    }
}
