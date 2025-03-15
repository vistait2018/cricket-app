package com.pks.cricket_app.repository;

import com.pks.cricket_app.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
      List<Player> findAllByRole(String role);
}
