package com.MasthanSharif.DonorAndCharityManagementSystem.serviceinter;

import com.MasthanSharif.DonorAndCharityManagementSystem.requestdto.OrganizationRequestDto;
import com.MasthanSharif.DonorAndCharityManagementSystem.responsedto.OrganizationResponseDto;

import java.util.List;

public interface OrganizationService {
    OrganizationResponseDto createOrganization(OrganizationRequestDto dto);
    OrganizationResponseDto getOrganizationById(Long organizationId);
    List<OrganizationResponseDto> getAllOrganizations();
    OrganizationResponseDto updateOrganization(Long organizationId, OrganizationRequestDto dto);
    void deleteOrganization(Long organizationId);
}
