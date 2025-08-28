package com.bismo.stellive.api.obtnDtl.dto;
import com.bismo.stellive.api.obtnDtl.ObtnDtl.Status;
import com.bismo.stellive.api.ItemHdr.ItemHdr;
import com.bismo.stellive.api.obtnHdr.ObtnHdr;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObtnDtlResponse {
    //PK
    private Long id;
    //수주번호
    private ObtnHdr obtnHdr;
    //정렬순서
    private String sortIndex;

    //아이템코드
    private ItemHdr itemHdr;

    //수주금액
    private Integer obtnMony;
    //수주량
    private Integer obtnAmt;
    // 현재 위치 상태
    private Status status;
    //저장
    private String rgstNm;
    private LocalDateTime rgstDt;

    //업데이트
    private String updtNm;
    private LocalDateTime updtDt;

    private Long obtnId;

}
