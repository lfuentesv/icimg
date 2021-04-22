package cl.lfuentes.icimg.resposeTO;

public class LoginResponseTO {
    private String token;

    public LoginResponseTO(String token) {
        this.token = token;
    }

    public LoginResponseTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
