package com.bismo.stellive.api.obtn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObtnRequset {

    private Long id;                                        //pk
    private String obtnNm;                                  //수주번호
    private String obtnMk;                                  //비고
    private String userId;                                  //접속자
    private Integer mony;                                   //금액
    private Long  plceId;                                   //장소
    private Long  compId;                                   //회사명

    private String  startDt;            //시작날짜
    private String  endDt;              //끝날짜

    private String selectDt;            //선택날짜

    public void createStartDtEndDtBySelectDt (){
        if (selectDt == null || selectDt.isEmpty()) {
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 문자열을 LocalDate로 변환
        LocalDate date = LocalDate.parse(selectDt, formatter);

        // 해당 월 정보 추출
        YearMonth yearMonth = YearMonth.from(date);

        // 해당 월의 첫날과 마지막 날
        LocalDate firstDay = yearMonth.atDay(1);
        LocalDate lastDay = yearMonth.atEndOfMonth();

        // 다시 문자열로 변환해서 필드에 저장
        this.startDt = firstDay.format(formatter);
        this.endDt = lastDay.format(formatter);

    }

}
