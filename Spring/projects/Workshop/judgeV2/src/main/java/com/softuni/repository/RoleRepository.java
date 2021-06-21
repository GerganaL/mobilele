package com.softuni.repository;

import com.softuni.models.entity.RoleEntity;
import com.softuni.models.entity.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByName(RoleNameEnum roleNameEnum);
}
