package test.hw4.voidpo.enums;

public enum ManageMenuItem {
    USERS("Manage Users"),
    PROJECTS("Manage Projects"),
    TAGS("Manage Tags"),
    CUSTOM_FIELDS("Manage Custom Fields"),
    GLOBAL_PROFILES("Manage Global Profiles"),
    PLUGINS("Manage Plagins"),
    CONFIGURATION("Manage Configuration");

    private String itemName;

    ManageMenuItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
