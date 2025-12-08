package com.MasthanSharif.DonorAndCharityManagementSystem.repository;

import com.MasthanSharif.DonorAndCharityManagementSystem.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor,Long> {
}
