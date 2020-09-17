package me.sun.licensingservice.service;

import lombok.RequiredArgsConstructor;
import me.sun.licensingservice.controllers.dto.LicenseOrgDto;
import me.sun.licensingservice.controllers.dto.OrganizationDto;
import me.sun.licensingservice.model.License;
import me.sun.licensingservice.repository.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicenseService {
    private final LicenseRepository licenseRepository;
    private final OrganizationAdapter organizationAdapter;

    public LicenseOrgDto getLicense(Long organizationId, String licenseId, String clientType) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId.toString(), licenseId);

        OrganizationDto organization = organizationAdapter.getOrganizationDto(organizationId, clientType);

        return new LicenseOrgDto(license, organization);
    }

    public List<License> getLicensesByOrg(String organizationId) {
        return licenseRepository.findByOrganizationId(organizationId);
    }

    public License saveLicense(License license) {
        license.setLicenseId(UUID.randomUUID().toString());
        return licenseRepository.save(license);
    }

    public void updateLicense(License license) {
        licenseRepository.save(license);
    }

    public void deleteLicense(License license) {
        licenseRepository.delete(license);
    }

    public List<License> findAll() {
        return licenseRepository.findAll();
    }
}
