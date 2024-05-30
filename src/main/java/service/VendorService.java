package service;

import models.Vendor;

import java.util.List;

public interface VendorService {
    List<Vendor> findAll();
    Vendor findById(Long id);
    Vendor save(Vendor vendor);
    void deleteById(Long id);
}
