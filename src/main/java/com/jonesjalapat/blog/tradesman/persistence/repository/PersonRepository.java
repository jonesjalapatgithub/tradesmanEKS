package com.jonesjalapat.blog.tradesman.persistence.repository;

import com.jonesjalapat.blog.tradesman.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {}
