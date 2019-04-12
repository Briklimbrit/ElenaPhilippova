package test.hw4.voidpo.enums;

public enum LeftMenuItem {

    MY_VIEW(" My View "),
    VIEW_ISSUES(" View Issues "),
    REPORT_ISSUE(" Report Issue "),
    CHANGE_LOG(" Change Log "),
    ROADMAP(" Roadmap "),
    SUMMARY(" Summary "),
    MANAGE(" Manage ");

    private String itemName;

    LeftMenuItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
