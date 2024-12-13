package spring_ssl.Pharmacy.loadDB;

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
