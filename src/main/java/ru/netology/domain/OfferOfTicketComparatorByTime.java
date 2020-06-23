package ru.netology.domain;

import java.util.Comparator;

public class OfferOfTicketComparatorByTime implements Comparator<OfferOfTicket> {

    @Override
    public int compare(OfferOfTicket t1, OfferOfTicket t2) {
        return t1.getFlightTime() - t2.getFlightTime();
    }
}
