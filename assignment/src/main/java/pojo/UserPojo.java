package pojo;

/**
 * Created by rjoshi on Jan, 2022
 */
public class UserPojo {
    private String username,password,email;

    public UserPojo(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserPojo(){

}


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
