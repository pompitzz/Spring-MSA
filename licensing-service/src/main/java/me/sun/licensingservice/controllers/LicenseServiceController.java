package me.sun.licensingservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sun.licensingservice.controllers.dto.LicenseOrgDto;
import me.sun.licensingservice.model.License;
import me.sun.licensingservice.service.LicenseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    private final LicenseService licenseService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<License> getLicenses(@PathVariable("organizationId") String organizationId) {
        return licenseService.getLicensesByOrg(organizationId);
    }

    @GetMapping("/{licenseId}/{clientType}")
    public LicenseOrgDto getLicensesWithClientType(@PathVariable("organizationId") Long organizationId,
                                                   @PathVariable("licenseId") String licenseId,
                                                   @PathVariable("clientType") String clinetType) {
        return licenseService.getLicense(organizationId, licenseId, clinetType);
    }

    @RequestMapping(value = "{licenseId}", method = RequestMethod.PUT)
    public String updateLicenses(@PathVariable("licenseId") String licenseId) {
        return String.format("This is the put");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public License saveLicenses(@RequestBody License license) {
        return licenseService.saveLicense(license);
    }

    @RequestMapping(value = "{licenseId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteLicenses(@PathVariable("licenseId") String licenseId) {
        return String.format("This is the Delete");
    }
}
