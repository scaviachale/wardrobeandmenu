package scaa.wardrobe.category;

public enum Type {
    HAT("HAT"),
    JEAN("JEAN"),
    JERSEY("JERSEY"),
    NIGHTWEAR("NIGHTWEAR"),
    SHIRT("SHIRT"),
    SHOES("SHOES"),
    SOCKS("SOCKS"),
    SUIT("SUIT"),
    TSHIRT("TSHIRT"),
    UNDERWEAR("UNDERWEAR"),
    JACKET("JACKET"),
    UTILITY("UTILITY"),
    ;

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
