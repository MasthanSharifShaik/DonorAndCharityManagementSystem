package com.MasthanSharif.DonorAndCharityManagementSystem.repository;

import com.MasthanSharif.DonorAndCharityManagementSystem.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
}
