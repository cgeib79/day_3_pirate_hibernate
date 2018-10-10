package com.example.codeclan.pirateservice.repository;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Ship;

import java.util.List;

public interface ShipRepositoryCustom {

    public List<Pirate> getPiratesForShip(Ship ship);

    Ship findShipByName(String name);
}
