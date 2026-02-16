package com.MasthanSharif.DonorAndCharityManagementSystem.serviceinter;

import com.MasthanSharif.DonorAndCharityManagementSystem.requestdto.CampaignRequestDto;
import com.MasthanSharif.DonorAndCharityManagementSystem.responsedto.CampaignResponseDto;

import java.util.List;

public interface CampaignService {
    CampaignResponseDto createCampaign(CampaignRequestDto dto);
    CampaignResponseDto getCampaignById(Long id);
    List<CampaignResponseDto> getAllCampaigns();
    CampaignResponseDto updateCampaign(Long id, CampaignRequestDto dto);
    void deleteCampaign(Long id);
}
