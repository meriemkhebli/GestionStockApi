package com.khebli.gestiondestockproject.services.auth;

import com.khebli.gestiondestockproject.dto.UtilisateurDto;
import com.khebli.gestiondestockproject.model.auth.ExtendedUser;
import com.khebli.gestiondestockproject.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {


//    @Autowired
//    private UtilisateurRepository utilisateurRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Utilisateur utilisateur = utilisateurRepository.findByEmail(email).orElseThrow(()->
//                new EntityNotFoundException("Aucun utilisateur avec l'email fourni", ErrorCodes.UTILISATEUR_NOT_FOUND));
//
//
//        return new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), Collections.emptyList());
//    }

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateurDto utilisateur = utilisateurService.findByEmail(email);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        utilisateur.getRoles().forEach(role->authorities.add(new SimpleGrantedAuthority(role.getRoleName())));


        return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMotDePasse(), utilisateur.getEntreprise().getId(),authorities);
    }
}
