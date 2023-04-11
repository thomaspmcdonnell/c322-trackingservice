package edu.iu.c322.trackingservice.model;

public record Item(int id,
                        String name,
                        int quantity,
                        float price) {
}
