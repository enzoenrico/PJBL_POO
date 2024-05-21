public class User {
    private int id;
    private String name;
    private String email;
    private String telephone;
    private String passwd = null;

    public User(int id, String name, String email, String telephone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
