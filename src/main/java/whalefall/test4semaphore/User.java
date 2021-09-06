package whalefall.test4semaphore;

/**
 * @author: WhaleFall541
 * @date: 2021/10/6 16:49
 */
public class User {
    private String uuid;

    public User(String uuid, int bound) {
        this.uuid = uuid;
        this.bound = bound;
    }


    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private int bound;

    public int getBound() {
        return bound;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }
}
