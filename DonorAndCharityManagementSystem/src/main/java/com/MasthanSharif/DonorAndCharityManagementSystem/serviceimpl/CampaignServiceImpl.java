package com.MasthanSharif.DonorAndCharityManagementSystem.serviceimpl;

import com.MasthanSharif.DonorAndCharityManagementSystem.mapper.CampaignMapper;
import com.MasthanSharif.DonorAndCharityManagementSystem.model.Campaign;
import com.MasthanSharif.DonorAndCharityManagementSystem.model.Organization;
import com.MasthanSharif.DonorAndCharityManagementSystem.repository.CampaignRepository;
import com.MasthanSharif.DonorAndCharityManagementSystem.repository.DonationRepository;
import com.MasthanSharif.DonorAndCharityManagementSystem.repository.FundAllocationRepository;
import com.MasthanSharif.DonorAndCharityManagementSystem.repository.OrganizationRepository;
import com.MasthanSharif.DonorAndCharityManagementSystem.requestdto.CampaignRequestDto;
import com.MasthanSharif.DonorAndCharityManagementSystem.responsedto.CampaignResponseDto;
import com.MasthanSharif.DonorAndCharityManagementSystem.serviceinter.CampaignService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CampaignServiceImpl implements CampaignService {

    public final CampaignRepository campaignRepository;
    public final CampaignMapper campaignMapper;
    public final OrganizationRepository organizationRepository;
    public final DonationRepository donationRepository;
    public final FundAllocationRepository fundAllocationRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository, CampaignMapper campaignMapper, OrganizationRepository organizationRepository, DonationRepository donationRepository, FundAllocationRepository fundAllocationRepository) {
        this.campaignRepository = campaignRepository;
        this.campaignMapper = campaignMapper;
        this.organizationRepository = organizationRepository;
        this.donationRepository = donationRepository;
        this.fundAllocationRepository = fundAllocationRepository;
    }


    @Override
    public CampaignResponseDto createCampaign(CampaignRequestDto dto) {
        Campaign campaign = campaignMapper.toEntity(dto);
        if(dto.getOrganizationId() != null){
            Organization organization = organizationRepository.findById(dto.getOrganizationId()).orElseThrow(()-> new RuntimeException("Organization not found with id: " + dto.getOrganizationId()));
            campaign.setOrganization(organization);
        }

        Campaign saved = campaignRepository.save(campaign);
        return campaignMapper.toDto(saved);
    }

    @Override
    public CampaignResponseDto getCampaignById(Long id) {
        Campaign campaign = campaignRepository.findById(id).orElseThrow(() -> new RuntimeException("Campaign not found with id: " + id));
        return campaignMapper.toDto(campaign);
    }

    @Override
    public List<CampaignResponseDto> getAllCampaigns() {
        return campaignRepository.findAll().stream().map(campaignMapper::toDto).toList();
    }

    @Override
    public CampaignResponseDto updateCampaign(Long id, CampaignRequestDto dto) {
        Campaign campaign = campaignRepository.findById(id).orElseThrow(() -> new RuntimeException("Campaign not found with id: " + id));
        campaignMapper.updateEntityFromDto(campaign, dto);
        if(dto.getOrganizationId() != null){
            Organization organization = organizationRepository.findById(dto.getOrganizationId()).orElseThrow(()-> new RuntimeException("Organization not found with id: " + dto.getOrganizationId()));
            campaign.setOrganization(organization);
        }
        Campaign saved = campaignRepository.save(campaign);
        return campaignMapper.toDto(saved);
    }

    @Override
    public void deleteCampaign(Long id) {
        Campaign campaign = campaignRepository.findById(id).orElseThrow(() -> new RuntimeException("Campaign not found with id: " + id));
        campaignRepository.delete(campaign);
    }
}
