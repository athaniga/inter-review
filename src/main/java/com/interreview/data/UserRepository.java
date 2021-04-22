package com.interreview.data;

import com.interreview.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


    User findByUsername(String username);

    User findByEmail(String email);
}
