package ua.com.owu.relations.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.com.owu.relations.models.User;

@EnableJpaRepositories
public interface UserDAO extends JpaRepository<User,Integer> {
}
