package com.vertex.io;

import com.vertex.io.vo.IoUser;
import com.vertex.io.vo.Users;

import java.io.File;
import java.util.List;

/**
 * Created by sweet_home on 23.10.16.
 */
public interface UserReader {

    List<IoUser> readUsers(File file);

    void writeUsers(File file, Users users);
}
