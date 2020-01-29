package inje.bim.dto;

import inje.validation.Enum;
import org.bimserver.interfaces.objects.SUserType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SUserDTO {
    @NotEmpty @NotNull
    private String username;
    @NotEmpty @NotNull
    private String name;
    @Enum(enumClass = SUserType.class, ignoreCase = true)
    private String sUserType;
    @NotEmpty @NotNull
    private String password;
    private SUserType userType;
    private Long oid = -1L;

    public SUserDTO() {}

    public SUserDTO(String username, String name, String sUserType, String password) {
        this.username = username;
        this.name = name;
        this.sUserType = sUserType;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getsUserType() {
        return sUserType;
    }

    public void setsUserType(String sUserType) {
        this.sUserType = sUserType;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public SUserType getUserType() {
        return userType;
    }

    public void setUserType(SUserType userType) {
        this.userType = userType;
    }
}