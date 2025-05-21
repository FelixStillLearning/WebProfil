package Praktikum.Webprofil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Praktikum.Webprofil.model.Buku;

import Praktikum.Webprofil.Repository.BukuRepository;

@Service
public class BukuService {
    @Autowired
    private BukuRepository bukuRepository;

    public List<Buku> findAll() {
        return bukuRepository.findAll();
    }
    public Buku save(Buku buku) {
        return bukuRepository.save(buku);
    }
    
}
