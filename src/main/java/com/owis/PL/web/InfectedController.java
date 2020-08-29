package com.owis.PL.web;

import com.owis.PL.Data.entity.InfectedCitizen;
import com.owis.PL.Data.repository.InfectedCitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/infected")
public class InfectedController {
    private final InfectedCitizenRepository infectedCitizenRepository;

    @Autowired
    public InfectedController(InfectedCitizenRepository infectedCitizenRepository) {
        this.infectedCitizenRepository = infectedCitizenRepository;
    }

    @PostMapping
    public InfectedCitizen addInfectedCitizen(@RequestParam(name = "nationalNumber", required = true) Long nationalNumber,
                                              @RequestParam(name = "email", required = true) String email,
                                              @RequestParam(name = "firstName", required = true) String firstName,
                                              @RequestParam(name = "lastName", required = true) String lastName,
                                              @RequestParam(name = "lat", required = true) BigDecimal lat,
                                              @RequestParam(name = "lng", required = true) BigDecimal lng,
                                              @RequestParam(name = "phoneNumber", required = true) String phoneNumber
    ) {

        InfectedCitizen infectedCitizen = new InfectedCitizen();
        infectedCitizen.setEmail(email);
        infectedCitizen.setFirstName(firstName);
        infectedCitizen.setLastName(lastName);
        infectedCitizen.setLat(lat);
        infectedCitizen.setLng(lng);
        infectedCitizen.setNationalNumber(nationalNumber);
        infectedCitizen.setPhoneNumber(phoneNumber);

        return this.infectedCitizenRepository.save(infectedCitizen);
    }

    @GetMapping
    public List<InfectedCitizen>getInfectedCitizen(){
        List<InfectedCitizen>infectedCitizens = new ArrayList<>();
        this.infectedCitizenRepository.findAll().forEach(infectedCitizens::add);
        return infectedCitizens;
    }
    @PutMapping
    public void updateInfectedCitizen(@RequestParam(name = "status", required = false)Integer status, @RequestParam(name = "hospitalId", required = false)Long hospitalId, @RequestParam(name = "centerId", required = false)Long centerId, @RequestParam(name = "nationalNumber", required = true) Long nationalNumber){
        if(status != null){
            this.infectedCitizenRepository.setStatusForInfectedCitizen(nationalNumber, status);
        }
        if(centerId != null){
            this.infectedCitizenRepository.setCenterIdForInfectedCitizen(nationalNumber, centerId );
        }
        if(hospitalId != null){
            this.infectedCitizenRepository.setHospitalIdForInfectedCitizen(nationalNumber ,hospitalId );
        }

    }
}
