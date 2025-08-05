package com.bismo.stellive.api.comp;


import com.bismo.stellive.api.common.CommonResponse;
import com.bismo.stellive.api.comp.dto.CompResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comp")
@RequiredArgsConstructor
@Slf4j
public class CompanyApiController {


    private final CompJpaRepository compJpaRepository;


    @GetMapping("/read")
    public CommonResponse getComp(){

        List<CompResponse> tempList = compJpaRepository.findAll().stream()
                .map(CompResponse::new) // 생성자에서 Company → CompResponse 변환
                .toList();;


        return CommonResponse.success(tempList);
    }



}
