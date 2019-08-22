package scaa.wardrobe.category;

public enum Size {
    XTRASMALL("extra small"),
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    XTRALARGE("extra large");

    private String value;

    Size(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
