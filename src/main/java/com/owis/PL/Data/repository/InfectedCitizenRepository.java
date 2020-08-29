package com.owis.PL.Data.repository;

import com.owis.PL.Data.entity.InfectedCitizen;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

@Repository
public interface InfectedCitizenRepository extends CrudRepository<InfectedCitizen, Long> {


    InfectedCitizen findByNationalNumber(Long nationalNumber);
    @Modifying
    @Transactional
    @Query("UPDATE InfectedCitizen inf set  inf.status = :status where inf.nationalNumber = :nationalNumber")
    void setStatusForInfectedCitizen (@Param("nationalNumber")Long nationalNumber, @Param("status") Integer status);

    @Modifying
    @Transactional
    @Query("UPDATE InfectedCitizen inf set inf.centerId = :centerId where inf.nationalNumber = :nationalNumber")
    void setCenterIdForInfectedCitizen(@Param("nationalNumber")Long nationalNumber, @Param("centerId") Long centerId );

    @Modifying
    @Transactional
    @Query("UPDATE InfectedCitizen inf set inf.hospitalId = :hospitalId where inf.nationalNumber = :nationalNumber")
    void setHospitalIdForInfectedCitizen(@Param("nationalNumber")Long nationalNumber, @Param("hospitalId") Long hospitalId);


}
//TODO
// CREATE SEQUENCE hibernate_sequence START 1;
// CREATE SEQUENCE my_seq_gen START 1;
