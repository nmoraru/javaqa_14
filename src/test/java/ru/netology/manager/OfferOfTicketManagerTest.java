package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.OfferOfTicket;
import ru.netology.repository.OfferOfTicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class OfferOfTicketManagerTest {
    OfferOfTicketRepository repository = new OfferOfTicketRepository();
    OfferOfTicketManager manager = new OfferOfTicketManager(repository);
    private OfferOfTicket offer1 = new OfferOfTicket(1, 8810, "ZIA", "PRG", 1080);
    private OfferOfTicket offer2 = new OfferOfTicket(2, 10207, "DME", "PRG", 310);
    private OfferOfTicket offer3 = new OfferOfTicket(3, 8720, "DME", "PRG", 975);
    private OfferOfTicket offer4 = new OfferOfTicket(4, 9300, "SVO", "PRG", 1065);

    @BeforeEach
    void setUp() {
        manager.add(offer1);
        manager.add(offer2);
        manager.add(offer3);
        manager.add(offer4);
    }

    @Test
    void shouldSearchOneOffer() {
        assertArrayEquals(new OfferOfTicket[]{offer1}, manager.searchBy("ZIA", "PRG"));
    }

    @Test
    void shouldSearchMoreOffers() {
        assertArrayEquals(new OfferOfTicket[]{offer3, offer2}, manager.searchBy("DME", "PRG"));
    }

    @Test
    void shouldSearchNotExist() {
        assertArrayEquals(new OfferOfTicket[]{}, manager.searchBy("SVO", "ZIA"));
    }

}
