package com.bismo.stellive.api.prodDtl;

import com.bismo.stellive.api.ItemMgnt.ItemMgnt;
import com.bismo.stellive.api.prodMgnt.ProdMgnt;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class ProdDtl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //pk

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_mgnt")
    private ProdMgnt prodMgnt;

    //생산물 순서
    private String index;
    //    private Integer stx_Yn;         //세금 포함 불포함 ->헤더에서확인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_mgnt")
    private ItemMgnt itemMgnt;       //아이템코드

    //수주금액
    private Integer mony;
    //수주량
    private Integer amt;

    //저장
    @Column(name = "rgst_id")
    private Integer rgstId;
    @Column(name = "rgst_dt")
    private LocalDateTime rgstDt;

    //업데이트
    @Column(name = "updt_id")
    private Integer updtId;
    @Column(name = "updt_dt")
    private LocalDateTime updtDt;
    // 현재 위치 상태
    @Enumerated(EnumType.STRING)
    private Status status;

    // status 정의
    public enum Status {
        //1. 자체제작 , 2.발주 // 둘중에 하나로 시작


        //발주건인경우
        ORDER_NEED,         //발주요청 *
        ORDER_DONE,         //발주완료

        INHOUSE_NEED,       //입고요청
        INHOUSE_DONE,       //입고완료

        //자체 제작인경우
        WORK_NEED,           //생산지시요청 *
        WORK_DONE,           //생산완료


        //생산완료거나 입고완료인경우에는 포장이 가능

        PKG_NEED,        //포장진행
        PKG_DONE,       //포장완료

        WRHS_NEED,         //출고진행
        WRHS_DONE,         //출고완료

        SHMT_NEED,      //출하진행
        SHMT_DONE,      //출하완료

        //매출 매입 둘중하나로 귀결

        //매출
        SALES_TAX_INVOICE_NEED,        // 세금계산서 진행
        SALES_TAX_INVOICE_DONE,        // 세금계산서 완료
        //매입
        PRCH_TAX_INVOICE_NEED,        // 세금계산서 진행
        PRCH_TAX_INVOICE_DONE,        // 세금계산서 완료

    }
}
