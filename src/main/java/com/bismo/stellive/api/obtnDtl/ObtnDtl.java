package com.bismo.stellive.api.obtnDtl;

import com.bismo.stellive.api.ItemHdr.ItemHdr;
import com.bismo.stellive.api.obtnDtl.dto.ObtnDtlRequest;
import com.bismo.stellive.api.obtnHdr.ObtnHdr;
import com.bismo.stellive.api.user.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class ObtnDtl {
    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //수주번호
    @ManyToOne(fetch = FetchType.LAZY)
    private ObtnHdr obtnHdr;

    //정렬순서
    private String sortIndex;

    //아이템코드
    @ManyToOne(fetch = FetchType.LAZY)
    private ItemHdr itemHdr;

    //수주금액
    private Integer obtnMony;
    //수주량
    private Integer obtnAmt;

    // 현재 위치 상태
    @Enumerated(EnumType.STRING)
    private Status status;

    //저장
    private Integer rgstId;
    private LocalDateTime rgstDt;

    //업데이트
    private Integer updtId;
    private LocalDateTime updtDt;


    /**
     * 저장세팅
     */
    public void saveSetting(ObtnDtlRequest obtnDtlDto, UserDto userDto) {
        this.obtnHdr = obtnDtlDto.getObtnHdr();
        this.sortIndex = obtnDtlDto.getSortIndex();
        this.itemHdr = obtnDtlDto.getItemHdr();
        this.obtnMony = obtnDtlDto.getObtnMony();
        this.obtnAmt = obtnDtlDto.getObtnAmt();

        this.status = Status.FORM_COMPLETED;
        this.rgstId = userDto.getId();
        this.rgstDt = LocalDateTime.now();
        this.updtId = userDto.getId();
        this.updtDt = LocalDateTime.now();
    }

    public enum Status {
        //1. 자체제작 , 2.발주 // 둘중에 하나로 시작

        //수주서 작성 완료
        FORM_COMPLETED,
        //***************************
        //발주요청 *
        ORDER_NEED,
        //발주완료
        ORDER_DONE,
        //입고요청
        INHOUSE_NEED,
        //입고완료
        INHOUSE_DONE,
        //***************************
        //생산지시요청 *
        WORK_NEED,
        //생산완료
        WORK_DONE,
        //***************************

        //생산완료거나 입고완료인경우에는 포장이 가능
        //포장진행
        PKG_NEED,
        //포장완료
        PKG_DONE,
        //출고진행
        WRHS_NEED,
        //출고완료
        WRHS_DONE,
        //출하진행
        SHMT_NEED,
        //출하완료
        SHMT_DONE,
        //***************************
        //매출 매입 둘중하나로 귀결

        //매출
        // 세금계산서 진행
        SALES_TAX_INVOICE_NEED,
        // 세금계산서 완료
        SALES_TAX_INVOICE_DONE,
        //매입
        // 세금계산서 진행
        PRCH_TAX_INVOICE_NEED,
        // 세금계산서 완료
        PRCH_TAX_INVOICE_DONE,

    }
}
