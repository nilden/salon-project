package se.nilden.domain;


public record SalonServiceDetails(
        Long id,
        String description,
        String name,
        Double price,
        Integer timeInMinutes
) {}