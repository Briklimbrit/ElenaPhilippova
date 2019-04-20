package test.hw4.voidpo.enums;

public enum StatusOption {
    ANY("1"),
    NEW("2"),
    FEEDBACK("3"),
    ACKNOWLEDGED("4"),
    CONFIRMED("5"),
    ASSIGNED("6"),
    RESOLVED("7"),
    CLOSED("8");

    private String optionNumber;

    StatusOption(String optionNumber) {
        this.optionNumber = optionNumber;
    }

    public String getOptionNumber() {
        return optionNumber;
    }
}
