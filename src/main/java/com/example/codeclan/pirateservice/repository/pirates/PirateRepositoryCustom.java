package com.example.codeclan.pirateservice.repository.pirates;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;

import java.util.List;

public interface PirateRepositoryCustom {
    List<Pirate> getPiratesForRaid(Raid raid);
}
