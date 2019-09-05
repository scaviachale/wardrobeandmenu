package scaa.wardrobe.category;

public enum ClothSize {
    XTRASMALL("EXTRA SMALL"),
    SMALL("SMALL"),
    MEDIUM("MEDIUM"),
    LARGE("LARGE"),
    XTRALARGE("EXTRA LARGE");

    private String value;

    ClothSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
