package scaa.wardrobe.category;

public enum Size {
    XTRASMALL("EXTRA SMALL"),
    SMALL("SMALL"),
    MEDIUM("MEDIUM"),
    LARGE("LARGE"),
    XTRALARGE("EXTRA LARGE");

    private String value;

    Size(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
