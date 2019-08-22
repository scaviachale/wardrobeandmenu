package scaa.wardrobe.category;

public enum Status {
    NEW("NEW"),
    OLD("OLD"),
    ;

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
