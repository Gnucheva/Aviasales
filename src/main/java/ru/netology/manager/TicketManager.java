package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        return ticket.getDeparture().equalsIgnoreCase(from)
                && ticket.getArrival().equalsIgnoreCase(to);
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            int length = result.length;
            if (ticket.getDeparture().equals(from) && ticket.getArrival().equals(to)) {
                Ticket[] tmp = new Ticket[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
