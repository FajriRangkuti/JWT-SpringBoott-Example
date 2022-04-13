package com.mandiri.repository;

import com.mandiri.entity.UserApps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserApps,String> {

    public Optional<UserApps> findUserAppsByUserName(String userName);

}
