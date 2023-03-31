package edu.iu.c322.trackingservice.controller;

import edu.iu.c322.trackingservice.model.Item;
import edu.iu.c322.trackingservice.model.Order;
import edu.iu.c322.trackingservice.repository.TrackingRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracking")
public class TrackingController {
    private TrackingRepository repository;
    public TrackingController(TrackingRepository repository) {
        this.repository = repository;
    }
    @PostMapping
    public int create(@RequestBody Order order) {
        return repository.create(order);
    }
    @GetMapping("/{orderId}/{itemId}")
    public Item getItem(@PathVariable int orderId, @PathVariable int itemId) {
        return repository.getItem(orderId, itemId);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Item item, @PathVariable int id) {
        repository.update(item, id);
    }
}
