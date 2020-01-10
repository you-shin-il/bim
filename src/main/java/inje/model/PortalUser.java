package inje.model;

public class PortalUser {
    private String username;
    private String name;
    private String password;
    private String tel;
    private String company;

    public PortalUser(String username, String name, String password, String tel, String company) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.company = company;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getTel() {
        return tel;
    }

    public String getCompany() {
        return company;
    }
}