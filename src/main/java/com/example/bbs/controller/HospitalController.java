package com.example.bbs.controller;

import com.example.bbs.Repository.HospitalRepository;
import com.example.bbs.domain.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("")
    public String list(Model model, Pageable pageable){
        Page<Hospital> hospitals = hospitalRepository.findAll(pageable);
        model.addAttribute("hospitals",hospitals);
        return "hospitals/list";

    }


}
