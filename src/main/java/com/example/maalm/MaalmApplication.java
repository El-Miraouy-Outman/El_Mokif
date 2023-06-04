package com.example.maalm;

import com.example.maalm.entities.*;
import com.example.maalm.repository.MaalmRepository;
import com.example.maalm.service.MaalmService;
import com.example.maalm.service.PublicationService;
import com.example.maalm.service.ReviewService;
import com.example.maalm.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class MaalmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaalmApplication.class, args);
    }


    @Configuration
    public class CorsConfiguration implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOriginPatterns("http://localhost:61444") // Replace with your Flutter application's origin
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*")
                    .allowCredentials(false);
        }

    }

/*
    @Component

    public class DataLoader implements CommandLineRunner {
        private final MaalmRepository maalmRepository;
        @Autowired
        public DataLoader(MaalmRepository maalmRepository) {
            this.maalmRepository = maalmRepository;
        }
        @Override
        public void run(String... args) throws Exception {
            Maalm maalm1 = Maalm.builder()
                    .cin("CIN1")
                    .nom("John")
                    .prenom("Doe")
                    .email("john.doe@example.com")
                    .telephone("123456789")
                    .password("CODE1")
                    .adresse("Address 1")
                    .reviewTotal(10)
                    .role(false)
                    .build();
            maalmRepository.save(maalm1);


            // Maalm 2
            Maalm maalm2 = Maalm.builder()
                    .cin("CIN2")
                    .nom("Alice")
                    .prenom("Smith")
                    .email("alice.smith@example.com")
                    .telephone("987654321")
                    .password("CODE2")
                    .adresse("Address 2")
                    .reviewTotal(5)
                    .role(false)
                    .build();

            maalmRepository.save(maalm2);

// Maalm 3
            Maalm maalm3 = Maalm.builder()
                    .cin("CIN3")
                    .nom("Bob")
                    .prenom("Johnson")
                    .email("bob.johnson@example.com")
                    .telephone("456789123")
                    .password("CODE3")
                    .adresse("Address 3")
                    .reviewTotal(12)
                    .role(false)
                    .build();

            maalmRepository.save(maalm3);

// Maalm 4
            Maalm maalm4 = Maalm.builder()
                    .cin("CIN4")
                    .nom("Emma")
                    .prenom("Davis")
                    .email("emma.davis@example.com")
                    .telephone("789123456")
                    .password("CODE4")
                    .adresse("Address 4")
                    .reviewTotal(8)
                    .role(false)
                    .build();

            maalmRepository.save(maalm4);

// Maalm 5
            Maalm maalm5 = Maalm.builder()
                    .cin("CIN5")
                    .nom("Michael")
                    .prenom("Wilson")
                    .email("michael.wilson@example.com")
                    .telephone("321654987")
                    .password("CODE5")
                    .adresse("Address 5")
                    .reviewTotal(15)
                    .role(false)
                    .build();
            maalmRepository.save(maalm5);
        }
    }

    @Bean
    CommandLineRunner review(ReviewService reviewService, MaalmService maalmService){
        return args -> {
            Review review=Review.builder().
                    review(3).idClient(1L).idReviewrs(2L).build();
            reviewService.saveReview(review);

            Review review3=Review.builder().
                    review(3).idClient(1L).idReviewrs(3L).build();
            reviewService.saveReview(review3);

            Review review4=Review.builder().
                    review(3).idClient(1L).idReviewrs(4L).build();
            reviewService.saveReview(review4);

            Review review5=Review.builder().
                    review(3).idClient(1L).idReviewrs(5L).build();
            reviewService.saveReview(review5);

            Review review6=Review.builder().
                    review(3).idClient(2L).idReviewrs(3L).build();
            reviewService.saveReview(review6);

            Review review7=Review.builder().
                    review(3).idClient(2L).idReviewrs(4L).build();
            reviewService.saveReview(review7);

            Review review2=Review.builder().
                    review(3).idClient(2L).idReviewrs(5L).build();
            reviewService.saveReview(review2);

            Review review8=Review.builder().
                    review(3).idClient(2L).idReviewrs(3L).build();
            reviewService.saveReview(review8);

        };

    }

@Bean
    CommandLineRunner InsertService(ServiceService service){
        return args -> {
            List.of("agricu","fermier","menouisier","charpentier","couisinier")
                    .forEach(ser->{
                        Service service1=Service.builder().name(ser).build();
                        service.insert(service1);

                    });
        };
    }


    @Bean
    CommandLineRunner insertPublication(PublicationService service){
        return args -> {
            Publication publication1=Publication.builder()
                    .type(TypeService.OFFRE).etat(Etat.REJETE)
                    .description("je suis un Charpentier disponible pour n'import travail")
                    .build();
            service.insert(publication1,2L,"charpentier");

            Publication publication2=Publication.builder()
                    .type(TypeService.OFFRE).etat(Etat.REJETE)
                    .description("je suis un Charpentier disponible pour n'import travail")
                    .build();
            service.insert(publication1,3L,"charpentier");

            Publication publication3=Publication.builder()
                    .type(TypeService.OFFRE).etat(Etat.ACCEPTE)
                    .description("je suis un Charpentier disponible pour n'import travail")
                    .build();
            service.insert(publication3,4L,"fermier");

            Publication publication4=Publication.builder()
                    .type(TypeService.OFFRE).etat(Etat.ACCEPTE)
                    .description("je suis un Charpentier disponible pour n'import travail")
                    .build();
            service.insert(publication4,4L,"charpentier");

            Publication publication5=Publication.builder()
                    .type(TypeService.OFFRE).etat(Etat.REJETE)
                    .description("je suis un Charpentier disponible pour n'import travail")
                    .build();
            service.insert(publication5,1L,"couisinier");

            Publication publication6=Publication.builder()
                    .type(TypeService.DEMMANDE).etat(Etat.REJETE)
                    .description("je suis un Charpentier disponible pour n'import travail")
                    .build();
            service.insert(publication6,1L,"couisinier");

            Publication publication7=Publication.builder()
                    .type(TypeService.DEMMANDE).etat(Etat.ACCEPTE)
                    .description("je suis un Charpentier disponible pour n'import travail")
                    .build();
            service.insert(publication7,1L,"couisinier");

        };
    }

 */

    }

