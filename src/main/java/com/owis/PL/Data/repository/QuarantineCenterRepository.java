package com.owis.PL.Data.repository;

import com.owis.PL.Data.entity.QuarantineCenter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuarantineCenterRepository extends CrudRepository<QuarantineCenter, Long> {
}
