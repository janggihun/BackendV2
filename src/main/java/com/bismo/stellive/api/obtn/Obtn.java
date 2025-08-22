package com.bismo.stellive.api.obtn;

import com.bismo.stellive.api.comp.Company;
import com.bismo.stellive.api.obtn.dto.ObtnRequset;
import com.bismo.stellive.api.obtnDtl.ObtnDtl;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Company company;                                    //회사 pk

    private String obtnNm;                                      //수주번호
    private String obtnMk;                                      //비고

    private String inputId;                                     //작성자
    private LocalDateTime inputDate;                            //작정날짜
    private String updateId;                                    //변경한사람
    private LocalDateTime updateDate;                           //변경날짜

    @Enumerated(EnumType.STRING)
    private Status status;

    // 수주의 상태
    public enum Status {
        TEMP_SAVE,       //임시저장
        DONE,           //수주 정보 완료
        CANCEL,          //  수주취소
    }


    public void SettingFirstSave(ObtnRequset obtnRequset) {

        this.obtnDtl = new ArrayList<>();
        this.obtnNm = obtnRequset.getObtnNm();
        this.obtnMk = obtnRequset.getObtnMk();
        this.inputId = obtnRequset.getUserId();
        this.updateId = obtnRequset.getUserId();
        this.inputDate =LocalDateTime.now();
        this.updateDate =LocalDateTime.now();

        Company company1 = new Company();
        company1.inputId(obtnRequset.getCompId());
        company = company1;
    }

    public void createObtnNm() {
        int year = Year.now().getValue();                 // 예: 2025
        String prefix = String.format("%02dA", year % 100); // "25A"
        String formattedId = String.format("%06d", id);     // "000001"
        this.obtnNm = prefix + "-" + formattedId;           // "25A-000001"

    }

    public void update(ObtnRequset obtnRequset) {
        this.obtnNm = StringUtils.defaultString(obtnRequset.getObtnNm());
        this.obtnMk = StringUtils.defaultString(obtnRequset.getObtnMk()) ;

        this.updateDate = LocalDateTime.now();
        this.updateId =obtnRequset.getUserId();

        Company company1 = new Company();
        company1.inputId(obtnRequset.getCompId());
        this.company = company1;

    }
}
