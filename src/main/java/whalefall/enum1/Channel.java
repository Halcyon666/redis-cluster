package whalefall.enum1;


public enum Channel {

    DSK("1"), ICO("2");
    private String flag;

    Channel(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }
}
