package com.bismo.stellive.api.obtnDtl;


import com.bismo.stellive.api.common.CommonResponse;
import com.bismo.stellive.api.obtnDtl.dto.ObtnDtlRequest;
import com.bismo.stellive.api.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ObtnDtlService {

    private final ObtnDtlJpaRepository obtnDtlJpaRepository;

    /**
     * 수주상세 저장
     * @param obtnDtlRequests
     * @param userDto
     */
    public void save(List<ObtnDtlRequest> obtnDtlRequests, UserDto userDto) {
        //유효성검사
        if(obtnDtlRequests.size()==0){
            CommonResponse.error("수주 상세의 데이터가 존재하지 않습니다.");
            return ;
        }

        
        List<ObtnDtl> obtnDtls = new ArrayList<>();

        obtnDtlRequests.forEach(obtnDtlRequest -> {
            ObtnDtl obtnDtl = new ObtnDtl();
            obtnDtl.saveSetting(obtnDtlRequest,userDto);
            obtnDtls.add(obtnDtl);
        });
        obtnDtlJpaRepository.saveAll(obtnDtls);
    }


}
