package com.bismo.stellive.api.compHdr;


import com.bismo.stellive.api.compHdr.dto.CompRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;


@Entity
@Getter
public class CompHdr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //pk

    private String compNm;            //회사 이름
    private String compAdr;         //주소
    private String compCd;          //사업자등록번호

    public void save(CompRequest compRequest) {
        this.compNm = compRequest.getCompNm();
        this.compAdr = compRequest.getCompAdr();
        this.compCd = compRequest.getCompCd();
    }
}
