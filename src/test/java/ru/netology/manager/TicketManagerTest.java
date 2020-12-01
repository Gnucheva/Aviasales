package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket first = new Ticket(1, 1000, "AAA", "AAB", 100);
    private Ticket second = new Ticket(2, 2000, "AAC", "AAE", 200);
    private Ticket third = new Ticket(3, 3000, "AAF", "AAG", 300);
    private Ticket five = new Ticket(5, 1500, "AAH", "AAI", 150);
    private Ticket ten = new Ticket(10, 4000, "AAJ", "AAK", 250);
    private Ticket seven = new Ticket(7, 2500, "AAL", "AAM", 350);

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(five);
        repository.save(ten);
        repository.save(seven);
    }

    @Test
    void mustFindAll



}