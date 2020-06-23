package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OfferOfTicket implements Comparable<OfferOfTicket> {
    private int id;
    private int price;
    private String fromAirport;
    private String toAirport;
    private int flightTime;


    @Override
    public int compareTo(OfferOfTicket offer) {
        return price - offer.price;
    }

}
