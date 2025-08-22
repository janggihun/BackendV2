package com.bismo.stellive.api.prodMgnt;

import com.bismo.stellive.api.obtnMgnt.ObtnMgnt;
import com.bismo.stellive.api.orderMgnt.OrderMgnt;
import com.bismo.stellive.api.prodDtl.ProdDtl;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class ProdMgnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //pk

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obtn_mgnt", nullable = true)
    private ObtnMgnt obtnMgnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_mgnt",nullable = true)
    private OrderMgnt orderMgnt;

    @OneToMany(mappedBy = "prod")
    private List<ProdDtl> prodDtlList;

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
