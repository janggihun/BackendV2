package com.bismo.stellive.api.ItemHdr;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemHdrJpaRepository extends JpaRepository<ItemHdr, Integer> {
}
