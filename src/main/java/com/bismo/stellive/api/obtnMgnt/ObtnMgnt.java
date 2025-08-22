package com.bismo.stellive.api.obtnMgnt;

import com.bismo.stellive.api.compMgnt.CompMgnt;
import com.bismo.stellive.api.obtn.dto.ObtnRequset;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.Year;

@Entity
@Getter
public class ObtnMgnt { //수주테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                                            //pk

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comp_mgnt")
    private CompMgnt compMgnt;                                    //회사 pk

    private String obtnNm;                                      //수주번호
    private String obtnMk;                                      //비고
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

    @Enumerated(EnumType.STRING)
    private Status status;

    // 수주의 상태
    public enum Status {
        TEMP_SAVE,       //임시저장
        DONE,           //수주 정보 완료
        CANCEL,          //  수주취소
    }


    public void SettingFirstSave(ObtnRequset obtnRequset) {

        this.obtnNm = obtnRequset.getObtnNm();
        this.obtnMk = obtnRequset.getObtnMk();
//        this.rsgtDt = obtnRequset.getUserId();
//        this.updateId = obtnRequset.getUserId();
//        this.inputDate =LocalDateTime.now();
//        this.updateDate =LocalDateTime.now();

//        Company company1 = new Company();
//        company1.inputId(obtnRequset.getCompId());
//        company = company1;
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

//        this.updateDate = LocalDateTime.now();
//        this.updateId =obtnRequset.getUserId();

//        Company company1 = new Company();
//        company1.inputId(obtnRequset.getCompId());
//        this.company = company1;

    }
}
