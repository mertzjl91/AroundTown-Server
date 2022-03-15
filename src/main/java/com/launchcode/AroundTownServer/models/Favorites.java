package com.launchcode.AroundTownServer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Favorites {
    private int userId;

    private int eventId;

}
