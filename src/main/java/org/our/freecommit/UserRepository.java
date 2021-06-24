package org.our.freecommit;

import org.springframework.security.core.userdetails.User;

public interface UserRepository {
    User find(User user);
    User findByName(@Parm("userName") String userName);
    User findByAdd(String address);
}
