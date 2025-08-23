package com.bismo.stellive.api.obtnHdr.dto;
import com.bismo.stellive.api.obtnHdr.ObtnHdr.Status;
import com.bismo.stellive.api.obtnHdr.ObtnHdr.Stx;
import com.bismo.stellive.api.compHdr.CompHdr;
import com.bismo.stellive.api.obtnDtl.ObtnDtl;
import com.bismo.stellive.api.obtnHdr.ObtnHdr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObtnHdrResponse {
    //pk
    private Long id;
    //obtndtl
    private List<ObtnDtl> obtnDtls;
    //회사 pk
    private CompHdr compHdr;
    //부가세 Y.N
    private Stx stx;
    //수주번호
    private String obtnNm;
    //비고
    private String obtnMk;
    //납기일
    private LocalDateTime obtnDt;
    //저장
    private String rgstNm;
    private LocalDateTime rgstDt;
    //업데이트
    private String updtNm;
    private LocalDateTime updtDt;
    //상태
    private Status status;


}
