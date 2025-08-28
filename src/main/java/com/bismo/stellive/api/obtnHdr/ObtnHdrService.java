package com.bismo.stellive.api.obtnHdr;


import com.bismo.stellive.api.obtnDtl.ObtnDtlService;
import com.bismo.stellive.api.obtnDtl.dto.ObtnDtlRequest;
import com.bismo.stellive.api.obtnHdr.dto.ObtnHdrRequest;
import com.bismo.stellive.api.obtnHdr.dto.ObtnHdrResponse;
import com.bismo.stellive.api.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ObtnHdrService {

    private final ModelMapper modelMapper;
    private final ObtnHdrJpaRepository obtnHdrJpaRepository;
    private final ObtnHdrQueryRepository obtnHdrQueryRepository;
    private final ObtnDtlService obtnDtlService;

    /**
     * 수주 데이터 취득
     *
     * @return
     */
    public List<ObtnHdrResponse> read() {

        return obtnHdrQueryRepository.read();
    }

    /**
     * 수주 저장
     *
     * @param obtnHdrRequest
     * @param userDto
     */
    public void save(ObtnHdrRequest obtnHdrRequest, UserDto userDto) {
        //수주저장
        ObtnHdr obtnHdr = new ObtnHdr();
        obtnHdr.saveSetting(obtnHdrRequest, userDto);
        ObtnHdr savedObtnHdr = obtnHdrJpaRepository.save(obtnHdr);
        savedObtnHdr.updateObtnNm();

        //수주상세 저장
        List<ObtnDtlRequest> obtnDtlRequests = obtnHdrRequest.getObtnDtls();
        obtnDtlRequests.forEach(obtnDtlRequest -> {
            obtnDtlRequest.setObtnHdr(savedObtnHdr);
        });
        obtnDtlService.save(obtnDtlRequests, userDto);


    }
}
