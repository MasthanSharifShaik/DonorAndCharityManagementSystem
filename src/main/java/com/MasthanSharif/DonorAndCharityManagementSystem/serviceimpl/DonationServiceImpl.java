package com.MasthanSharif.DonorAndCharityManagementSystem.serviceimpl;

import com.MasthanSharif.DonorAndCharityManagementSystem.exception.ResourceNotFoundException;
import com.MasthanSharif.DonorAndCharityManagementSystem.mapper.DonationMapper;
import com.MasthanSharif.DonorAndCharityManagementSystem.model.Campaign;
import com.MasthanSharif.DonorAndCharityManagementSystem.model.Donation;
import com.MasthanSharif.DonorAndCharityManagementSystem.model.Donor;
import com.MasthanSharif.DonorAndCharityManagementSystem.repository.CampaignRepository;
import com.MasthanSharif.DonorAndCharityManagementSystem.repository.DonationRepository;
import com.MasthanSharif.DonorAndCharityManagementSystem.repository.DonorRepository;
import com.MasthanSharif.DonorAndCharityManagementSystem.requestdto.DonationRequestDto;
import com.MasthanSharif.DonorAndCharityManagementSystem.responsedto.DonationResponseDto;
import com.MasthanSharif.DonorAndCharityManagementSystem.serviceinter.DonationService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DonationServiceImpl implements DonationService {

    public final DonationRepository donationRepository;
    public final DonationMapper donationMapper;
    public final DonorRepository donorRepository;
    public final CampaignRepository campaignRepository;

    public DonationServiceImpl(DonationRepository donationRepository, DonationMapper donationMapper, DonorRepository donorRepository, CampaignRepository campaignRepository) {
        this.donationRepository = donationRepository;
        this.donationMapper = donationMapper;
        this.donorRepository = donorRepository;
        this.campaignRepository = campaignRepository;
    }


    @Override
    public DonationResponseDto createDonation(DonationRequestDto dto) {
        Donation donation = donationMapper.toEntity(dto);
        if(dto.getDonorId() != null){
            Donor donor = donorRepository.findById(dto.getDonorId()).orElseThrow(()-> new ResourceNotFoundException("Donor", dto.getDonorId()));
            donation.setDonor(donor);
        }

        if(dto.getCampaignId() != null){
            Campaign campaign = campaignRepository.findById(dto.getCampaignId()).orElseThrow(()-> new ResourceNotFoundException("Campaign", dto.getCampaignId()));
            donation.setCampaign(campaign);
        }
        Donation saved = donationRepository.save(donation);
        return donationMapper.toDto(saved);
    }

    @Override
    public DonationResponseDto getDonationById(Long id) {
        Donation donation = donationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Donation", id));
        return donationMapper.toDto(donation);
    }

    @Override
    public List<DonationResponseDto> getAllDonations() {
        return donationRepository.findAll().stream().map(donationMapper::toDto).toList();
    }

    @Override
    public DonationResponseDto updateDonation(Long id, DonationRequestDto dto) {
        Donation donation = donationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Donation", id));
        donationMapper.updateEntityFromDto(dto, donation);
        if(dto.getDonorId() != null){
            Donor donor = donorRepository.findById(dto.getDonorId()).orElseThrow(()-> new ResourceNotFoundException("Donor", dto.getDonorId()));
            donation.setDonor(donor);
        }
        if(dto.getCampaignId() != null){
            Campaign campaign = campaignRepository.findById(dto.getCampaignId()).orElseThrow(()-> new ResourceNotFoundException("Campaign", dto.getCampaignId()));
            donation.setCampaign(campaign);
        }
        Donation updated = donationRepository.save(donation);
        return donationMapper.toDto(updated);
    }

    @Override
    public void deleteDonation(Long id) {
        Donation donation = donationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Donation", id));
        donationRepository.delete(donation);
    }
}
