package com.poe.javatos.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.Utilisateur;
import com.poe.javatos.repository.IUtilisateurRepository;

@Service

public class ServiceUtilisateurImpl implements UserDetailsService {

    private final IUtilisateurRepository utilisateurRepository;

    @Autowired
    public ServiceUtilisateurImpl(IUtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Objects.requireNonNull(username);
        Utilisateur utilisateur = utilisateurRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return utilisateur;
    }

}
