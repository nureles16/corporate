package guru.springframework.corporate.repository;

import guru.springframework.corporate.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

    // Получить только активный баннер для USER
//    Optional<Banner> findByIsActiveTrue();
    List<Banner> findByIsActiveTrue();

}