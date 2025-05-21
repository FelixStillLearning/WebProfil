package Praktikum.Webprofil.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    
    public Buku findById(Long id) {
        Optional<Buku> result = bukuRepository.findById(id);
        return result.orElse(null);
    }
    
    public void deleteById(Long id) {
        bukuRepository.deleteById(id);
    }
    
    public List<Buku> search(String keyword) {
        // Cari buku berdasarkan judul, penulis, atau penerbit
        keyword = keyword.toLowerCase();
        final String finalKeyword = keyword;
        
        return bukuRepository.findAll().stream()
                .filter(buku -> 
                    buku.getJudul().toLowerCase().contains(finalKeyword) || 
                    buku.getPenulis().toLowerCase().contains(finalKeyword) || 
                    buku.getPenerbit().toLowerCase().contains(finalKeyword))
                .collect(Collectors.toList());
    }
}
