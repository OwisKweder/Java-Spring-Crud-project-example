package com.owis.PL.web;

import com.owis.PL.Data.entity.Hospital;
import com.owis.PL.Data.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/hospitals")
public class HospitalController {
    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }
//name details lng lat address
    @PostMapping
    public Hospital addHospital(@RequestParam(name="name", required = true)String hospitalName,
                                @RequestParam(name="details", required = true)String hospitalDetails,
                                @RequestParam(name="address", required = true)String hospitalAddress,
                                @RequestParam(name="lng", required = true)BigDecimal hospitalLng,
                                @RequestParam(name="lat", required = true)BigDecimal hospitalLat,
                                @RequestParam(name="phoneNumber", required = true)String phoneNumber){

        Hospital hospital = new Hospital();

        hospital.setAddress(hospitalAddress);
        hospital.setDetails(hospitalDetails);
        hospital.setName(hospitalName);
        hospital.setLat(hospitalLat);
        hospital.setLng(hospitalLng);
        hospital.setPhoneNumber(phoneNumber);
       return hospitalRepository.save(hospital);
    }

    @GetMapping
    public List<Hospital> getHospitals(){
        List<Hospital>hospitals = new ArrayList<>();
        this.hospitalRepository.findAll().forEach(hospitals::add);
        return hospitals;
    }

}
