package com.bismo.stellive.api.compHdr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompJpaRepository extends JpaRepository<CompHdr, Long> {
}
