package com.bismo.stellive.api.obtnHdr;


import com.bismo.stellive.api.common.CommonResponse;
import com.bismo.stellive.api.obtnHdr.dto.ObtnHdrRequest;
import com.bismo.stellive.api.obtnHdr.dto.ObtnHdrResponse;
import com.bismo.stellive.api.user.User;
import com.bismo.stellive.api.user.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/obtnHdr")
public class ObtnHdrApiController {

    private final ObtnHdrService obtnHdrService;
    private final ModelMapper modelMapper;
    /**
     * 수주 데이터 취득
     * @return
     */
    @GetMapping("/read")
    public CommonResponse read() {

        return CommonResponse.success(obtnHdrService.read());
    }
    /**
     * 수주 데이터 저장
     */
    @PostMapping("/save")
    public CommonResponse save(@Validated @RequestBody ObtnHdrRequest obtnHdrRequest,HttpSession session) {


        User user = (User) session.getAttribute("user");

        UserDto userDto = modelMapper.map(user, UserDto.class);
        log.info("obtnHdrRequest={}", obtnHdrRequest.getObtnDt());
        obtnHdrService.save(obtnHdrRequest,userDto);

        return CommonResponse.success("저장성공");
    }
}
