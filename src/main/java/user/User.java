package user;

import java.util.List;

public abstract class User {
    private Status status;
    private int id;
    private static int idCounter = 1;

    public User() {
        id = idCounter++;
    }

    public Status getStatus() {
        return status;
    }

    public void update(Status status) {
        this.status = status;
    }
}
