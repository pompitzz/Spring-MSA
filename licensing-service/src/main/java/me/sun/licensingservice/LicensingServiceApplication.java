package me.sun.licensingservice;

import lombok.RequiredArgsConstructor;
import me.sun.licensingservice.model.License;
import me.sun.licensingservice.service.LicenseService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class LicensingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicensingServiceApplication.class, args);
    }

    @Component
    @RequiredArgsConstructor
    static class AppRunner implements ApplicationRunner {

        private final LicenseService licenseService;

        @Override
        public void run(ApplicationArguments args) {

            License license1 = License.builder()
                    .organizationId("1")
                    .licenseType("user")
                    .productName("CustomerPro")
                    .licenseMax(100)
                    .licenseAllocated(5)
                    .build();

            System.out.println(license1);
            licenseService.saveLicense(license1);

            licenseService.findAll().forEach(System.out::println);
        }
    }

}
