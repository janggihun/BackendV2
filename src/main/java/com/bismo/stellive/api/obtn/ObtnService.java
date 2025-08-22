//package com.bismo.stellive.api.obtn;
//
//
//import com.bismo.stellive.api.obtn.dto.ObtnRequset;
//import jakarta.persistence.EntityNotFoundException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@RequiredArgsConstructor
//@Service
//public class ObtnService {
//
//    private final ObtnJpaRepository obtnJpaRepository;
//    private final ObtnQueryRepository obtnQueryRepository;
//
//
//    @Transactional
//    public void update(ObtnRequset obtnRequset) {
//
//        Obtn obtn = obtnJpaRepository.findById(obtnRequset.getId()).orElseThrow(() -> new EntityNotFoundException("수주건을 찾을수 없습니다."));
//
//        obtn.update(obtnRequset);
//    }
//
//
//}
