import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldColculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.colculate(amount, registered);
        assertEquals(expected, actual);

    }

    @Test
    void shouldColculateNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.colculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldColculateForRegisteredAndLimitExceeded() {
        BonusService service = new BonusService();

        long amount = 100000060;
        boolean registered = true;
        long expected = 500;

        long actual = service.colculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldColculateForNotRegisteredAndLimitExceeded() {
        BonusService service = new BonusService();

        long amount = 100000060;
        boolean registered = false;
        long expected = 500;

        long actual = service.colculate(amount, registered);

        assertEquals(expected, actual);
    }
}