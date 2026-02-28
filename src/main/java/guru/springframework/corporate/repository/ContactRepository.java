package guru.springframework.corporate.repository;

import guru.springframework.corporate.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contacts, Long> {
}