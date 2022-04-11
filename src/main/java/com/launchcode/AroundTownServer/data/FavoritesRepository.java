package com.launchcode.AroundTownServer.data;

import com.launchcode.AroundTownServer.models.Favorites;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends CrudRepository<Favorites, Integer> {

        public Favorites findFavoriteByUserIdAndEventId(int userId, int eventId);
}
