package app.entities;

public class User {

    private int userId;
    private String userName;
    private String password;
    private String eMail;
    private String role;

    public User(int userId, String userName, String password, String eMail,String role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String geteMail(){
        return eMail;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + eMail + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public int getId(int Id) {
        return Id;
    }
}
