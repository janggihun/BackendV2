package com.bismo.stellive.api.obtnHdr.dto;


import com.bismo.stellive.api.compHdr.CompHdr;
import com.bismo.stellive.api.obtnDtl.dto.ObtnDtlRequest;
import com.bismo.stellive.api.obtnHdr.ObtnHdr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObtnHdrRequest {
    //pk
    private Long id;
    //obtndtl
    private List<ObtnDtlRequest> obtnDtls;
    //회사 pk
    private CompHdr compHdr;
    //부가세 Y.N
    private ObtnHdr.Stx stx;
    //수주번호
    private String obtnNm;
    //비고
    private String obtnMk;
    //납기일
    private LocalDateTime obtnDt;
    //저장
    private Integer rgstId;
    private LocalDateTime rgstDt;
    //업데이트
    private Integer updtId;
    private LocalDateTime updtDt;
    //상태
    private ObtnHdr.Status status;

}
