package ru.netology.repository;

import ru.netology.domain.OfferOfTicket;

public class OfferOfTicketRepository {
    private OfferOfTicket[] offers = new OfferOfTicket[0];

    public void save(OfferOfTicket offer) {
        OfferOfTicket[] tmp = new OfferOfTicket[offers.length + 1];

        System.arraycopy(offers, 0, tmp, 0, offers.length);

        tmp[tmp.length - 1] = offer;
        offers = tmp;
    }

    public OfferOfTicket[] findAll() {
        return offers;
    }

    public OfferOfTicket findById(int id) {
        for (OfferOfTicket offer : offers) {
            if (offer.getId() == id) {
                return offer;
            }
        }
        return null;
    }

    public void removeById(int id) {
        OfferOfTicket[] tmp = new OfferOfTicket[offers.length - 1];

        int index = 0;
        for (OfferOfTicket offer : offers) {
            if (offer.getId() != id) {
                tmp[index] = offer;
                index++;
            }
        }

        offers = tmp;
    }
}
