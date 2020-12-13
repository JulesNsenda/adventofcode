package tech.myic.day.two;

public class PasswordDetails {

    private final String policy;
    private final String character;
    private final String password;

    public PasswordDetails(String policy, String character, String password) {
        this.policy = policy;
        this.character = character;
        this.password = password;
    }

    public String getPolicy() {
        return policy;
    }

    public String getCharacter() {
        return character;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Password{" + "policy=" + policy + ", character=" + character + ", password=" + password + '}';
    }

}
