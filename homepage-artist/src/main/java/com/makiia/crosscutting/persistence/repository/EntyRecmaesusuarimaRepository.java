package com.makiia.crosscutting.persistence.repository;

import com.makiia.crosscutting.persistence.entity.EntyRecmaesusuarima;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntyRecmaesusuarimaRepository extends CrudRepository<EntyRecmaesusuarima,String>{

    Optional<EntyRecmaesusuarima> findById(String id);
}
