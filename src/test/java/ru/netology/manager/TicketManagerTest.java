package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByTimeAscComparator;
import ru.netology.repository.TicketRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {

    private TicketManager manager;
    private Ticket first = new Ticket(1, 1000, "AAA", "AAB", 100);
    private Ticket second = new Ticket(2, 2000, "AAC", "AAE", 200);
    private Ticket third = new Ticket(3, 3000, "AAA", "AAB", 300);
    private Ticket five = new Ticket(5, 1500, "AAH", "AAI", 150);
    private Ticket ten = new Ticket(10, 4000, "AAJ", "AAK", 250);
    private Ticket seven = new Ticket(7, 2500, "AAA", "AAB", 350);

    @BeforeEach
    public void setUp() {
        manager = new TicketManager(new TicketRepository());
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(five);
        manager.add(ten);
        manager.add(seven);
    }

    @Test
    void mustShowTicketByPrice() {
        Ticket[] expected = new Ticket[]{first, seven, third};
        assertArrayEquals(expected, manager.findAllByPrice("AAA", "AAB"));
    }

    @Test
    void mustShowIfNoTicket() {
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAllByPrice("AAA", "AAJ"));
    }

    @Test
    void mustShowTicketByTime() {
        Comparator<Ticket> comparator = new TicketByTimeAscComparator();
        Ticket[] expected = new Ticket[]{first, third, seven};
        assertArrayEquals(expected, manager.findAllByTime("AAA", "AAB", comparator));
    }

    @Test
    void mustShowIfNoTicketByTime() {
        Comparator<Ticket> comparator = new TicketByTimeAscComparator();
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAllByTime("AAA", "AAJ", comparator));

    }

}