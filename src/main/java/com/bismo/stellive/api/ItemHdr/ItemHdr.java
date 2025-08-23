package com.bismo.stellive.api.ItemHdr;


import com.bismo.stellive.api.ItemHdr.dto.ItemHdrDto;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ItemHdr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //pk
    private Long itemId;
    //품목코드
    @Column(nullable = false)
    private String itemCd;
    //품목이름
    @Column(nullable = false)
    private String itemNm;
    //    private 규격 추후에
    // 실행원가
    @Column(nullable = false)
    private Integer itemMony;


    public void save(ItemHdrDto itemHdrDto) {
        this.itemCd = itemHdrDto.getItemCd();
        this.itemNm = itemHdrDto.getItemNm();
        this.itemMony = itemHdrDto.getItemMony();
    }
}
