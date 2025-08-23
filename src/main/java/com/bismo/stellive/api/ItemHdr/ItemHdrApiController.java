package com.bismo.stellive.api.ItemHdr;


import com.bismo.stellive.api.ItemHdr.dto.ItemHdrDto;
import com.bismo.stellive.api.ItemHdr.dto.ItemRequest;
import com.bismo.stellive.api.ItemHdr.dto.ItemResponse;
import com.bismo.stellive.api.common.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/itemHdr")
public class ItemHdrApiController {


    private final ItemHdrService itemHdrService;


    @GetMapping("/read")
    public CommonResponse read() {

        return CommonResponse.success(itemHdrService.read());
    }

    /**
     * 품목 저장
     * @param itemHdrDto
     * @return
     */
    @PostMapping("/save")
    public CommonResponse save(@Validated  @RequestBody ItemHdrDto itemHdrDto) {

         itemHdrService.save(itemHdrDto);

        return CommonResponse.success("성공");
    }
}
