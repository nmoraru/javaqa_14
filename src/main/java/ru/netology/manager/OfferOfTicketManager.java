package ru.netology.manager;

import ru.netology.domain.OfferOfTicket;
import ru.netology.domain.OfferOfTicketComparatorByTime;
import ru.netology.repository.OfferOfTicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class OfferOfTicketManager {
    private OfferOfTicketRepository repository = new OfferOfTicketRepository();

    public OfferOfTicketManager(OfferOfTicketRepository repository) {
        this.repository = repository;
    }

    public void add(OfferOfTicket offer) {
        repository.save(offer);
    }

    public OfferOfTicket[] getFilms() {
        return repository.findAll();
    }

    public OfferOfTicket[] searchBy(String from, String to, Comparator<OfferOfTicket> comparatorByTime) {
        OfferOfTicket[] result = new OfferOfTicket[0];

        for (OfferOfTicket offer : repository.findAll()) {
            if (offer.getFromAirport().equalsIgnoreCase(from) && offer.getToAirport().equalsIgnoreCase(to)) {
                OfferOfTicket[] tmp = new OfferOfTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = offer;
                result = tmp;
            }
        }

        Arrays.sort(result, comparatorByTime);
        return result;
    }

}
