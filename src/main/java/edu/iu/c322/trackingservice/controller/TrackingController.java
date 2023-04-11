package edu.iu.c322.trackingservice.controller;
import edu.iu.c322.trackingservice.model.Item;
import edu.iu.c322.trackingservice.model.Order;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/trackings")
public class TrackingController {
    private final WebClient orderService;

    public TrackingController(WebClient.Builder webClientBuilder) {
        orderService = webClientBuilder.baseUrl("http://localhost:8083").build();
    }


    @GetMapping("/{orderId}/{itemId}")
    public Mono<Item> findByOrderId(@PathVariable int orderId, @PathVariable int itemId){
        return orderService.get().uri("/orders/order/{orderId}/{itemId}", orderId, itemId)
                .retrieve()
                .bodyToMono(Item.class);
    }
}


