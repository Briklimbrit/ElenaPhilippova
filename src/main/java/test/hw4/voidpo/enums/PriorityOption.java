package test.hw4.voidpo.enums;

public enum PriorityOption {

    ANY("1"),
    NONE("2"),
    LOW("3"),
    NORMAL("4"),
    HIGH("5"),
    URGENT("6"),
    IMMEDIATE("7");

    private String optionNumber;

    PriorityOption(String optionNumber) {
        this.optionNumber = optionNumber;
    }

    public String getOptionNumber() {
        return optionNumber;
    }
}
