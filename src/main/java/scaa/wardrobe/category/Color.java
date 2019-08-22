package scaa.wardrobe.category;

public enum Color {
    BLUE("BLUE"),
    BLACK("BLACK"),
    BROWN("BROWN"),
    RED("RED"),
    SCOTCH("SCOTCH");

    private String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
