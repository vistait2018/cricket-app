package com.pks.cricket_app.services;

import com.pks.cricket_app.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl {

    @Autowired
    private PlayerRepository playerRepository;
}
