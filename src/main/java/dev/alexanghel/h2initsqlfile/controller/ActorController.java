package dev.alexanghel.h2initsqlfile.controller;

import dev.alexanghel.h2initsqlfile.model.Actor;
import dev.alexanghel.h2initsqlfile.repository.ActorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping
    public ResponseEntity<List<Actor>> all() {
        List<Actor> all = actorRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public String addOne(@RequestBody Actor actor) {
        Random random = new Random();
        actor.setId(random.nextInt(10, 100));
        Actor savedActor = actorRepository.save(actor);
        return "Saved actor with id: " + savedActor.getId();
    }
}
