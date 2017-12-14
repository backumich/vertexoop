package com.vertex.io.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "vertex-users")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @XmlElement(name = "user")
    private List<IoUser> users = new ArrayList<>();

    public void addUser(IoUser ioUser) {
        users.add(ioUser);
    }

    public void addAllUsers(List<IoUser> ioUsers) {
        this.users.addAll(ioUsers);
    }

    public List<IoUser> getUsers() {
        return users;
    }

    public void setUsers(List<IoUser> ioUsers) {
        this.users = ioUsers;
    }

}
