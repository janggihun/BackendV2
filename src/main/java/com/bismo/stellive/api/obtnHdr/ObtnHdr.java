package com.bismo.stellive.api.obtnHdr;

import com.bismo.stellive.api.compHdr.CompHdr;
import com.bismo.stellive.api.obtn.dto.ObtnRequset;
import com.bismo.stellive.api.obtnDtl.ObtnDtl;
import com.bismo.stellive.api.obtnHdr.dto.ObtnHdrRequest;
import com.bismo.stellive.api.user.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;


//수주 헤더
@Entity
@Getter
public class ObtnHdr {
    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //obtndtl
    @OneToMany(mappedBy = "obtnHdr")
    private List<ObtnDtl> obtnDtls;
    //회사 pk
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comp_hdr")
    private CompHdr compHdr;
    //부가세 Y.N
    @Enumerated(EnumType.STRING)
    private Stx stx;
    //수주번호
    private String obtnNm;
    //비고
    private String obtnMk;
    //납기일
    private LocalDateTime obtnDt;
    //저장
    private Integer rgstId;
    private LocalDateTime rgstDt;
    //업데이트
    private Integer updtId;
    private LocalDateTime updtDt;
    //상태
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * 저장세팅
     *
     * @param obtnHdrRequest
     * @param userDto
     */
    public void saveSetting(ObtnHdrRequest obtnHdrRequest, UserDto userDto, Integer count) {

        this.compHdr = obtnHdrRequest.getCompHdr();
        this.obtnNm = "25A-"+ (count+1);   //추후에 당일날짜의 년도를 계산해서 넣기
        this.stx =  obtnHdrRequest.getStx();
        this.obtnMk = obtnHdrRequest.getObtnMk();
        this.obtnDt = obtnHdrRequest.getObtnDt();
        this.rgstId = userDto.getId();
        this.rgstDt = LocalDateTime.now();
        
        this.updtId = userDto.getId();
        this.updtDt = LocalDateTime.now();

        this.status = Status.FORM_COMPLETED;

    }

    //*********** 수주의 상태
    public enum Status {
        //임시저장
        TEMP_SAVE,
        //수주 정보 완료
        FORM_COMPLETED,
        //  수주취소
        CANCEL,
    }
    //**********부가세
    public enum Stx{

        //부가세제외
        EXCLUDE,
        //부가세별도
        SEPARATE,
        //부가세포함
        INCLUDE
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
