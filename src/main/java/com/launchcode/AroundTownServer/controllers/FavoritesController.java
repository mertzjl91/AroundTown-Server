package com.launchcode.AroundTownServer.controllers;

import com.launchcode.AroundTownServer.data.EventRepository;
import com.launchcode.AroundTownServer.data.FavoritesRepository;
import com.launchcode.AroundTownServer.data.UserRepository;
import com.launchcode.AroundTownServer.models.Favorites;
import com.launchcode.AroundTownServer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/favorites")
@ResponseBody
public class FavoritesController {

    @Autowired
    private final FavoritesRepository favoritesRepository;
    //Not sure if I need to add a favorites array to user or not. If I choose that method, I would need the many to many
        //relationship and would need to add events to the array and take them away. If not, I could just access them on load through here.
        //Unsure what's the best way rn. I'm setting it up like I'll be adding the array, but idk.
    @Autowired
    private final UserRepository userRepository;

    public FavoritesController(FavoritesRepository favoritesRepository, UserRepository userRepository) {
        this.favoritesRepository = favoritesRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/saveFavoriteEvent")
    public Favorites saveFavoriteEvent(@RequestBody Favorites favoriteEvent) {
        User currentUser = this.userRepository.findById(favoriteEvent.getUserId()).get();
        System.out.println("made it to save");
        return this.favoritesRepository.save(favoriteEvent);
    }

    @DeleteMapping("/deleteFavoriteEvent/{userId}/{eventId}")
    public void deleteFavoriteEvent(@PathVariable("eventId") int eventId, @PathVariable("userId") int userId) {
        Favorites favoriteEvent = favoritesRepository.findFavoriteByUserIdAndEventId(userId, eventId);
        System.out.println("made it to delete");
        this.favoritesRepository.delete(favoriteEvent);
    }




}
