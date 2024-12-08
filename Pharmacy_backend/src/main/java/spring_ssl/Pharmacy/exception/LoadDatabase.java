package spring_ssl.Pharmacy.exception;

import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.repository.DoctorRepository;

//Comment the following lines because they fill th DB every time.
//@Configuration
//public class LoadDatabase {
//
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    @Bean
//    CommandLineRunner initDatabase(DoctorRepository doctorRepository) {
//
//        return args -> {
//            log.info("Preloading " + doctorRepository.save(new Doctor("100001", "doc1@pharma.gr", "qwerty")));
//            log.info("Preloading " + doctorRepository.save(new Doctor("100002", "doc2@pharma.gr", "qwerty")));
//            log.info("Preloading " + doctorRepository.save(new Doctor("100003", "doc3@pharma.gr", "qwerty")));
//
//        };
//    }
//
//}
