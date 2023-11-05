package org.jaanDeveloper.loading.repository;

import org.jaanDeveloper.loading.model.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs,Integer> {

}
