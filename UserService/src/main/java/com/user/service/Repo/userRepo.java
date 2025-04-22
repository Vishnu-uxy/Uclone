package com.user.service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.model.userModel;

@Repository
public interface userRepo extends JpaRepository<userModel, Long>  {

}
