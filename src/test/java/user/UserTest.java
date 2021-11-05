package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    Reciever reciever;
    Sender sender;

    @BeforeEach
    void setUp() {
        reciever = new Reciever();
        sender = new Sender();
        reciever.update(Status.NOTIFIED);
        sender.update(Status.ASLEEP);
    }

    @Test
    void getStatus() {
        assertEquals(Status.NOTIFIED, reciever.getStatus());
        assertEquals(Status.ASLEEP, sender.getStatus());
    }

    @Test
    void update() {
        reciever.update(Status.ASLEEP);
        assertEquals(Status.ASLEEP, reciever.getStatus());
        sender.update(Status.NOTIFIED);
        assertEquals(Status.NOTIFIED, sender.getStatus());
    }
}