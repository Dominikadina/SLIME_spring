package pl.sda.arppl4.slim_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arppl4.slim_spring.model.AUser;
import pl.sda.arppl4.slim_spring.model.Customer;

public interface AUserRepository extends JpaRepository<AUser, Long> {
}
