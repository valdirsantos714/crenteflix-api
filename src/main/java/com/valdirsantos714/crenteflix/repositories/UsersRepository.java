package com.valdirsantos714.crenteflix.repositories;

import com.valdirsantos714.crenteflix.model.security.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    UserDetails findByLogin(String username);
}
