package com.launchcode.AroundTownServer.controllers;

import com.launchcode.AroundTownServer.data.EventRepository;
import com.launchcode.AroundTownServer.data.FavoritesRepository;
import com.launchcode.AroundTownServer.models.Favorites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/favorites")
@ResponseBody
public class FavoritesController {

    @Autowired
    private final FavoritesRepository favoritesRepository;

    public FavoritesController(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    @GetMapping("saveFavoriteEvent/{userId}/{eventId}")
    public void saveFavoriteEvent(@PathVariable("eventId") int eventId, @PathVariable("userId") int userId) {
        Favorites favoriteEvent = new Favorites(eventId, userId);

        this.favoritesRepository.save(favoriteEvent);
    }

    @GetMapping("deleteFavoriteEvent/{userId}/{eventId}")
    public void deleteFavoriteEvent(@PathVariable("eventId") int eventId, @PathVariable("userId") int userId) {
        Favorites favoriteEvent = favoritesRepository.findFavoriteByUserIdAndEventId(userId, eventId);

        this.favoritesRepository.delete(favoriteEvent);
    }




}
