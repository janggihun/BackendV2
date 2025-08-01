package com.bismo.stellive.api.obtn;

import com.bismo.stellive.api.obtn.dto.OptnRequset;
import com.bismo.stellive.api.obtnDtl.ObtnDtl;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Obtn { //수주테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                                            //pk
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "obtn")
    private List<ObtnDtl> obtnDtl;                              // 수주디테일리스트
    private String obtnNm;                                      //수주번호
    private Integer obtnMony;                                   //수주금액
    private String obtnMk;                                      //비고

    private String inputId;                                     //작성자
    private LocalDateTime inputDate;                            //작정날짜
    private String updateId;                                    //변경한사람
    private LocalDateTime updateDate;                           //변경날짜




    public void SettingFirstSave(OptnRequset optnRequset) {

        this.obtnDtl = new ArrayList<>();
        this.obtnNm = optnRequset.getObtnNm();
        this.obtnMk = optnRequset.getObtnMk();

        this.inputId = optnRequset.getUserId();
        this.updateId = optnRequset.getUserId();
        this.inputDate =LocalDateTime.now();
        this.updateDate =LocalDateTime.now();

    }

    public void createObtnNm() {
        int year = Year.now().getValue();                 // 예: 2025
        String prefix = String.format("%02dA", year % 100); // "25A"
        String formattedId = String.format("%06d", id);     // "000001"
        this.obtnNm = prefix + "-" + formattedId;           // "25A-000001"

    }
}
