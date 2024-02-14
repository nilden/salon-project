package se.nilden.domain;


import lombok.Builder;

@Builder
public record SalonServiceDetails(
        Long id,
        String description,
        String name,
        Double price,
        Integer timeInMinutes
) {}