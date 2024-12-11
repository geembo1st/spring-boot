package com.sptringtest.SpringBoot.repositories;

import com.sptringtest.SpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepositories extends JpaRepository<User,Long> {
}
