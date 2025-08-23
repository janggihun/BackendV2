package com.bismo.stellive.api.compHdr;


import com.bismo.stellive.api.ItemHdr.ItemHdr;
import com.bismo.stellive.api.common.CommonResponse;
import com.bismo.stellive.api.compHdr.dto.CompRequest;
import com.bismo.stellive.api.compHdr.dto.CompResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/comp")
@RequiredArgsConstructor
@Slf4j
public class CompanyApiController {


    private final CompJpaRepository compJpaRepository;
    private final ModelMapper modelMapper;

    @GetMapping("/read")
    public CommonResponse getComp(){

        List<CompHdr> tempList = compJpaRepository.findAll();

        List<CompResponse> responseList = new ArrayList<>();

        for (CompHdr comp : tempList) {
            CompResponse resp = modelMapper.map(comp, CompResponse.class);
            responseList.add(resp);
        }

        return CommonResponse.success(responseList);
    }

    @PostMapping("/save")
    public CommonResponse saveComp(@Validated  @RequestBody CompRequest compRequest){

        CompHdr compHdr = new CompHdr();
        compHdr.save(compRequest);
        compJpaRepository.save(compHdr);

        return CommonResponse.success("저장성공");
    }

}
