package se.nilden.service;


import se.nilden.domain.SalonServiceDetails;

import java.util.List;
public interface SalonRepository {

    List<SalonServiceDetails> getSalonServiceDetails();
}
