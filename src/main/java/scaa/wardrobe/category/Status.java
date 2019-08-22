package scaa.wardrobe.category;

public enum Status {
    NEW("new"),
    OLD("old"),
    ;

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
