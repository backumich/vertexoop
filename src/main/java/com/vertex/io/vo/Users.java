package com.vertex.io.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "vertex-ioUsers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlElement(name = "vertex-user")
    private List<IoUser> ioUsers = new ArrayList<IoUser>();

    public void addUser(IoUser ioUser) {
        ioUsers.add(ioUser);
    }

    public void addAllUsers(List<IoUser> ioUsers) {
        this.ioUsers.addAll(ioUsers);
    }

    public List<IoUser> getUsers() {
        return ioUsers;
    }

    public void setUsers(List<IoUser> ioUsers) {
        this.ioUsers = ioUsers;
    }

}
