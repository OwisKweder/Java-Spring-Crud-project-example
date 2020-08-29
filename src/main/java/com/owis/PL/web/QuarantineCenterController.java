package com.owis.PL.web;

import com.owis.PL.Data.entity.QuarantineCenter;
import com.owis.PL.Data.repository.QuarantineCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/quarantine")
public class QuarantineCenterController {
    private final QuarantineCenterRepository quarantineCenterRepository;

    @Autowired
    public QuarantineCenterController(QuarantineCenterRepository quarantineCenterRepository) {
        this.quarantineCenterRepository = quarantineCenterRepository;
    }

    @PostMapping
    public QuarantineCenter addQuarantineCenter(@RequestParam(name="name", required = true)String quarantineCenterName,
                                                @RequestParam(name="details", required = true)String quarantineCenterDetails,
                                                @RequestParam(name="address", required = true)String quarantineCenterAddress,
                                                @RequestParam(name="lng", required = true) BigDecimal quarantineCenterLng,
                                                @RequestParam(name="lat", required = true)BigDecimal quarantineCenterLat,
                                                @RequestParam(name="phoneNumber", required = true)String phoneNumber){

        QuarantineCenter quarantineCenter = new QuarantineCenter();
        quarantineCenter.setAddress(quarantineCenterAddress);
        quarantineCenter.setDetails(quarantineCenterDetails);
        quarantineCenter.setAddress(quarantineCenterAddress);
        quarantineCenter.setLat(quarantineCenterLat);
        quarantineCenter.setLng(quarantineCenterLng);
        quarantineCenter.setName(quarantineCenterName);
        quarantineCenter.setPhoneNumber(phoneNumber);

        return this.quarantineCenterRepository.save(quarantineCenter);
    }

    @GetMapping
    public List<QuarantineCenter> getQuarantineCenter(){
        List<QuarantineCenter> quarantineCenters= new ArrayList<>();
        this.quarantineCenterRepository.findAll().forEach(quarantineCenters::add);
        return quarantineCenters;
    }
}
