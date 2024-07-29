package ru.job4j.ood.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Disabled
class Cinema3dTest {
    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3d();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket3d());
    }

    @Test
    public void whenBuyThenDidNotGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3d();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, 1, 1, date))
                .isInstanceOf(TicketsSoldOutException.class)
                .hasMessageContaining("Tickets are sold out");
    }

    @Test
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3d();
        Session session = new Session3d();
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> true);
        assertThat(sessions).contains(session);
    }

    @Test
    public void whenAddSessionThenDidNotExistsBetweenSessions() {
        Cinema cinema = new Cinema3d();
        Session session = new Session3d();
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> true);
        assertThat(sessions).doesNotContain(session);
    }


    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3d();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyOnInvalidColumnThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3d();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, 1, -1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }
}