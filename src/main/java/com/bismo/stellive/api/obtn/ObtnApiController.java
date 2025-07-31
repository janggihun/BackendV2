package com.bismo.stellive.api.obtn;


import com.bismo.stellive.api.common.CommonResponse;
import com.bismo.stellive.api.obtn.dto.OptnRequset;
import com.bismo.stellive.api.user.dto.UserRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/obtn")
public class ObtnApiController {

    private final ObtnJpaRepository obtnJpaRepository;

    @PostMapping("/save")
    @Transactional
    public CommonResponse save(@Validated @RequestBody OptnRequset optnRequset, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
//            log.info("me 세션 ID: {}, user: {}", session.getId(), session.getAttribute("user"));
            if (session.getAttribute("user") != null) {
                String userId = session.getAttribute("user").toString();
                optnRequset.setUserId(userId);
                //기본 세팅
                Obtn obtn = new Obtn();
                obtn.SettingFirstSave(optnRequset);
                try {
                    obtnJpaRepository.save(obtn);
                    return CommonResponse.success("수주내용이 저장 되었습니다.");
                }catch (Exception e){
                     CommonResponse.error("수주저장 실패");
                }

            }
        }

        return CommonResponse.error("로그인 필요");


    }

    ;


}
