package com.example.exer14sb.Controller;

import com.example.exer14sb.Model.Event;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/eventat")
public class EventController {
    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/get")
    public ResponseEntity getEvents() {
        return ResponseEntity.ok(events);
    }

    @PostMapping("/add")
    public ResponseEntity addEvent(@RequestBody @Valid Event event, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
        events.add(event);
        return ResponseEntity.status(200).body("event added successfully");
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateEvent(@PathVariable int index,@RequestBody @Valid Event event, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        events.set(index,event);
        return ResponseEntity.status(200).body("event updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEvent(@PathVariable int index) {
        events.remove(index);
        return ResponseEntity.status(200).body("Event deleted successfully");
    }

}
