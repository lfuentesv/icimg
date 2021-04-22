package cl.lfuentes.icimg.requestTO;

public class LoginRTO {

    private String userName;
    private String password;

    public LoginRTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LoginRTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
