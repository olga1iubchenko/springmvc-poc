package com.poc.springproject.repository;

import com.poc.springproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long id);
    List<UserEntity> findAll();

    @Override
    void deleteById(Long id);
}
