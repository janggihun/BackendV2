package com.bismo.stellive.api.obtnDtl;


import com.bismo.stellive.api.common.CommonResponse;
import com.bismo.stellive.api.obtn.dto.ObtnRequset;
import com.bismo.stellive.api.obtnDtl.dto.ObtnDtlResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/obtnDtl")
public class ObtnDtlApiController {

    private final ObtnDtlService obtnDtlService;

    @GetMapping("/read")
    public CommonResponse read(@ModelAttribute ObtnRequset obtnRequset) {


        List<ObtnDtlResponse> tempList = obtnDtlService.read(obtnRequset);
        log.info("tempList : {}", tempList);
        return CommonResponse.success(obtnDtlService.read(obtnRequset));
    }


}
