package test.hw4.voidpo.enums;

public enum PageTitle {
    MANTIS_BT("MantisBT"),
    MY_ACCOUNT("My Account - MantisBT"),
    MANAGE("Manage - MantisBT"),
    MANAGE_PROJECTS("Manage Projects - MantisBT"),
    MANAGE_USERS("Manage Users - MantisBT"),
    VIEW_ISSUES("View Issues - MantisBT");

    private String name;

    PageTitle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
