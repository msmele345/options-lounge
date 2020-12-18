package com.mitchmele.optionslounge.option.user;

import com.mitchmele.optionslounge.option.user.model.OLoungeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<OLoungeUser, Long> { }
