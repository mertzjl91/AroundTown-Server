package com.launchcode.AroundTownServer.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Favorites {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private int favoriteId;

    private int userId;

    private int eventId;

    public Favorites(int userId, int eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Favorites favorite = (Favorites) o;
        return favoriteId == favorite.favoriteId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(favoriteId);
    }

}
