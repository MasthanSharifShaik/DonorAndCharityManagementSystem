package com.MasthanSharif.DonorAndCharityManagementSystem.serviceinter;

import com.MasthanSharif.DonorAndCharityManagementSystem.requestdto.DonationRequestDto;
import com.MasthanSharif.DonorAndCharityManagementSystem.responsedto.DonationResponseDto;

import java.util.List;

public interface DonationService {
    DonationResponseDto createDonation(DonationRequestDto dto);
    DonationResponseDto getDonationById(Long id);
    List<DonationResponseDto> getAllDonations();
    DonationResponseDto updateDonation(Long id, DonationRequestDto dto);
    void deleteDonation(Long id);
}
