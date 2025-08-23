//package com.bismo.stellive.api.obtn;
//
//
//import com.bismo.stellive.api.common.CommonResponse;
//import com.bismo.stellive.api.obtn.dto.ObtnResponse;
//import com.bismo.stellive.api.obtn.dto.ObtnRequset;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/obtn")
//public class ObtnApiController {
//
//    private final ObtnService obtnService;
//
//
//    private final ObtnJpaRepository obtnJpaRepository;
//    private final ObtnQueryRepository obtnQueryRepository;
//
//    @PostMapping("/save")
//    @Transactional
//    public CommonResponse save(@Validated @RequestBody ObtnRequset obtnRequset, HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
////            log.info("me 세션 ID: {}, user: {}", session.getId(), session.getAttribute("user"));
//            if (session.getAttribute("user") != null) {
//                String userId = session.getAttribute("user").toString();
//                obtnRequset.setUserId(userId);
//                //기본 세팅
//                Obtn obtn = new Obtn();
//                obtn.SettingFirstSave(obtnRequset);
//                try {
//                   Obtn returnObtn =  obtnJpaRepository.save(obtn);
//                   //수주이름 생성하기
//                    returnObtn.createObtnNm(); //entity 변경이므로 업데이트 됨
//
//                    return CommonResponse.success("수주내용이 저장 되었습니다.");
//                } catch (Exception e) {
//                    CommonResponse.error("수주저장 실패");
//                }
//            }
//        }
//        return CommonResponse.error("로그인 필요");
//    };
//
//    @GetMapping("/read")
//    public CommonResponse read(@ModelAttribute ObtnRequset obtnRequset) {
////        log.info("optnRequset : {}", optnRequset);
//        List<ObtnResponse> returnList = obtnQueryRepository.read(obtnRequset);
//
//        return CommonResponse.success(returnList);
//    };
//    @GetMapping("/obtn-info")
//    public CommonResponse obtnInfo(@ModelAttribute ObtnRequset obtnRequset) {
//        log.info("/obtn-info : {}", obtnRequset);
//        ObtnResponse obtnResponse = obtnQueryRepository.obtnInfo(obtnRequset);
//
//        return CommonResponse.success(obtnResponse);
//    };
//
//    @PatchMapping("/update")
//    public CommonResponse update(@Validated @RequestBody ObtnRequset obtnRequset) {
//        log.info("/update : {}", obtnRequset);
//        obtnService.update(obtnRequset);
//
//        return CommonResponse.success(obtnRequset);
//    }
//
//}
