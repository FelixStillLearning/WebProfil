package Praktikum.Webprofil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Praktikum.Webprofil.model.Buku;

public interface BukuRepository extends JpaRepository<Buku, Long> {
    // JpaRepository already provides methods for CRUD operations
    // You can add custom query methods if needed
}