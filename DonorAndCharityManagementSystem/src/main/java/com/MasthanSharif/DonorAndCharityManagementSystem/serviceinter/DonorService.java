package com.MasthanSharif.DonorAndCharityManagementSystem.serviceinter;

import com.MasthanSharif.DonorAndCharityManagementSystem.requestdto.DonorRequestDto;
import com.MasthanSharif.DonorAndCharityManagementSystem.responsedto.DonorResponseDto;

import java.util.List;

public interface DonorService {
    DonorResponseDto createDonor(DonorRequestDto dto);
    DonorResponseDto getDonorById(Long id);
    List<DonorResponseDto> getAllDonors();
    DonorResponseDto updateDonor(Long id, DonorRequestDto dto);
    void deleteDonor(Long id);

}
