package se.nilden.domain;

public record SalonDetails(
        String name,
        String address,
        String zipcode,
        String state,
        String city,
        String phone
) {
}
