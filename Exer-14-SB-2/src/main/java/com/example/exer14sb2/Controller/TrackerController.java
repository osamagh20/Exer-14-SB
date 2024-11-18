package com.example.exer14sb2.Controller;

import com.example.exer14sb2.Model.Tracker;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/trackerat")
public class TrackerController {
    ArrayList<Tracker> trackers = new ArrayList<>();

    @PostMapping("/add")
    public ResponseEntity addTracker(@RequestBody @Valid Tracker tracker, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        trackers.add(tracker);
        return ResponseEntity.status(200).body("tracker added successfully");

    }

    @GetMapping("/get")
    public ResponseEntity getAllTrackers(){
        return ResponseEntity.status(200).body(trackers);
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateTracker(@PathVariable int index, @RequestBody @Valid Tracker tracker,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        trackers.set(index, tracker);
        return ResponseEntity.status(200).body("tracker updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteTracker(@RequestParam int index){
        trackers.remove(index);
        return ResponseEntity.status(200).body("tracker deleted successfully");
    }

    @GetMapping("/changeStatus/{index}")
    public ResponseEntity changeStatus(@PathVariable int index){

            if(trackers.get(index).getStatus().equalsIgnoreCase("not started")) {
                trackers.get(index).setStatus("in progress");
            }else if(trackers.get(index).getStatus().equalsIgnoreCase("in progress")) {
                trackers.get(index).setStatus("completed");
            }

        return ResponseEntity.status(200).body(trackers);
    }



}
