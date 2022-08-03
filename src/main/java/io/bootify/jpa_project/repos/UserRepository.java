package io.bootify.jpa_project.repos;

import io.bootify.jpa_project.domain.Usr;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Usr, Long> {
}
