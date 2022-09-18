package com.khebli.gestiondestockproject.controller;

import com.khebli.gestiondestockproject.controller.api.UtilisateurApi;
import com.khebli.gestiondestockproject.dto.UtilisateurDto;
import com.khebli.gestiondestockproject.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {
    UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurService.findByEmail(email);
    }

    @Override
    public List<UtilisateurDto> findAll() {

        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);

    }

//    @GetMapping("/")
//    public String home(Model model) {
//        Iterable<UtilisateurDto> listEmployee = utilisateurService.findAll();
//        model.addAttribute("employees", listEmployee);
//        return "home";
//    }
}
