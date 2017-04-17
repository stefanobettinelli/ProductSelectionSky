package com.stefanobettinelli.productselectionsky.services;

import com.stefanobettinelli.productselectionsky.exceptions.LocationNotFoundException;
import com.stefanobettinelli.productselectionsky.model.Location;
import com.stefanobettinelli.productselectionsky.model.SkyId;

public interface LocationService {
    public Location getLocation(SkyId customerID) throws LocationNotFoundException;
}
