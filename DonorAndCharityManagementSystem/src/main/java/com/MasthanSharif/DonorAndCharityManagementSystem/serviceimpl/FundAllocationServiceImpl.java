package com.MasthanSharif.DonorAndCharityManagementSystem.serviceimpl;

import com.MasthanSharif.DonorAndCharityManagementSystem.exception.ResourceNotFoundException;
import com.MasthanSharif.DonorAndCharityManagementSystem.mapper.FundAllocationMapper;
import com.MasthanSharif.DonorAndCharityManagementSystem.model.Campaign;
import com.MasthanSharif.DonorAndCharityManagementSystem.model.FundAllocation;
import com.MasthanSharif.DonorAndCharityManagementSystem.model.Organization;
import com.MasthanSharif.DonorAndCharityManagementSystem.repository.CampaignRepository;
import com.MasthanSharif.DonorAndCharityManagementSystem.repository.FundAllocationRepository;
import com.MasthanSharif.DonorAndCharityManagementSystem.repository.OrganizationRepository;
import com.MasthanSharif.DonorAndCharityManagementSystem.requestdto.FundAllocationRequestDto;
import com.MasthanSharif.DonorAndCharityManagementSystem.responsedto.FundAllocationResponseDto;
import com.MasthanSharif.DonorAndCharityManagementSystem.serviceinter.FundAllocationService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class FundAllocationServiceImpl implements FundAllocationService {

    public final FundAllocationRepository fundAllocationRepository;
    public final FundAllocationMapper fundAllocationMapper;
    public final CampaignRepository campaignRepository;
    public final OrganizationRepository organizationRepository;

    public FundAllocationServiceImpl(FundAllocationRepository fundAllocationRepository, FundAllocationMapper fundAllocationMapper, CampaignRepository campaignRepository, OrganizationRepository organizationRepository) {
        this.fundAllocationRepository = fundAllocationRepository;
        this.fundAllocationMapper = fundAllocationMapper;
        this.campaignRepository = campaignRepository;
        this.organizationRepository = organizationRepository;
    }


    @Override
    public FundAllocationResponseDto createFundAllocation(FundAllocationRequestDto dto) {
        FundAllocation fundAllocation = fundAllocationMapper.toEntity(dto);
        if (dto.getCampaignId() != null) {
            Campaign c = campaignRepository.findById(dto.getCampaignId())
                    .orElseThrow(() -> new ResourceNotFoundException("Campaign", dto.getCampaignId()));
            fundAllocation.setCampaign(c);
        }
        if (dto.getOrganizationId() != null) {
            Organization organization = organizationRepository.findById(dto.getOrganizationId())
                    .orElseThrow(() -> new ResourceNotFoundException("Organization", dto.getOrganizationId()));
            fundAllocation.setOrganization(organization);
        }
        if (fundAllocation.getUsedDate() == null) fundAllocation.setUsedDate(LocalDateTime.now());
        FundAllocation saved = fundAllocationRepository.save(fundAllocation);
        return fundAllocationMapper.toDto(saved);
    }

    @Override
    public FundAllocationResponseDto getFundAllocationById(Long fundAllocationId) {
        FundAllocation fundAllocation = fundAllocationRepository.findById(fundAllocationId).orElseThrow(() -> new ResourceNotFoundException("FundAllocation", fundAllocationId));
        return fundAllocationMapper.toDto(fundAllocation);
    }

    @Override
    public List<FundAllocationResponseDto> getAllFundAllocations() {
        return fundAllocationRepository.findAll().stream().map(fundAllocationMapper::toDto).toList();
    }

    @Override
    public FundAllocationResponseDto updateFundAllocation(Long id, FundAllocationRequestDto dto) {
        FundAllocation fundAllocation = fundAllocationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FundAllocation", id));
        fundAllocationMapper.updateEntityFromDto(dto, fundAllocation);
        if (dto.getCampaignId() != null) {
            Campaign campaign = campaignRepository.findById(dto.getCampaignId()).orElseThrow(() -> new ResourceNotFoundException("Campaign", dto.getCampaignId()));
            fundAllocation.setCampaign(campaign);
        }
        if (dto.getOrganizationId() != null) {
            Organization organization = organizationRepository.findById(dto.getOrganizationId()).orElseThrow(() -> new ResourceNotFoundException("Organization", dto.getOrganizationId()));
            fundAllocation.setOrganization(organization);
        }
        FundAllocation saved = fundAllocationRepository.save(fundAllocation);
        return fundAllocationMapper.toDto(saved);
    }

    @Override
    public void deleteFundAllocation(Long id) {
        FundAllocation fundAllocation = fundAllocationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FundAllocation", id));
        fundAllocationRepository.delete(fundAllocation);
    }
}
