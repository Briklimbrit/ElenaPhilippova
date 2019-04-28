package test.hw5.voidpo.User;

public final class FullUser {

    private final User user;
    private final String password;

    public FullUser(
            final User user,
            final String passsword
    ){
        this.user = user;
        this.password = passsword;
    }


    public User getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}