package com.bismo.stellive.api.orderMgnt;

import com.bismo.stellive.api.compMgnt.CompMgnt;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class OrderMgnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //pk

    //오더 헤드에 필요한 내용 추가
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comp_mgnt")
    private CompMgnt compMgnt;

    private String orderNm;                                      //수주번호
    private String orderMk;                                      //비고

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
}
