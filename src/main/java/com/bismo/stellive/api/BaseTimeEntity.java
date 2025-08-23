//package com.bismo.stellive.api;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.MappedSuperclass;
//import jakarta.persistence.PrePersist;
//import jakarta.persistence.PreUpdate;
//import lombok.Getter;
//
//import java.time.LocalDateTime;
//
//@Getter
//@MappedSuperclass
//public abstract class BaseTimeEntity {
//    //저장
//    @Column(name = "rgst_id")
//    private Integer rgstId;
//    @Column(name = "rgst_dt")
//    private LocalDateTime rgstDt;
//
//    //업데이트
//    @Column(name = "updt_id")
//    private Integer updtId;
//    @Column(name = "updt_dt")
//    private LocalDateTime updtDt;
//
//    @PrePersist
//    public void prePersist() {
//        this.rgstDt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        this.updtDt = LocalDateTime.now();
//    }
//}
