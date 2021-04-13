package de.dennissuffel.pairProgrammingFinderBackend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
