package com.bismo.stellive.api.comp;

import com.bismo.stellive.api.obtn.Obtn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompJpaRepository extends JpaRepository<Company, Long> {
}
