package test.hw4.voidpo.enums;

public enum UserInfoMenuItem {

    MY_ACCOUNT(" My Account"),
    RSS(" RSS"),
    LOGOUT(" Logout");

    private String itemName;

    UserInfoMenuItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
