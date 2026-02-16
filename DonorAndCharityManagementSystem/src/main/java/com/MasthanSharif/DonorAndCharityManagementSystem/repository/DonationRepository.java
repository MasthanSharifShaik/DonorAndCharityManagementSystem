package com.MasthanSharif.DonorAndCharityManagementSystem.repository;

import com.MasthanSharif.DonorAndCharityManagementSystem.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation,Long> {
}
