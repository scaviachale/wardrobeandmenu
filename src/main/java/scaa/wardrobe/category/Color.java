package scaa.wardrobe.category;

public enum Color {
    BLUE("blue"),
    BLACK("black"),
    BROWN("brown"),
    RED("red"),
    SCOTCH("scotch");

    private String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
