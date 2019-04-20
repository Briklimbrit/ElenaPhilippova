package test.hw4.voidpo.enums;

public enum SeverityOption {
    ANY("1"),
    FEATURE("2"),
    TRIVIAL("3"),
    TEXT("4"),
    TWEAK("5"),
    MINOR("6"),
    MAJOR("7"),
    CRASH("8"),
    BLOCK("9");

    private String optionNumber;

    SeverityOption(String optionNumber) {
        this.optionNumber = optionNumber;
    }

    public String getOptionNumber() {
        return optionNumber;
    }
}
