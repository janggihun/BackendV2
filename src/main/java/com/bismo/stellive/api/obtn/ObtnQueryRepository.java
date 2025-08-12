package com.bismo.stellive.api.obtn;

import com.bismo.stellive.api.obtn.dto.ObtnResponse;
import com.bismo.stellive.api.obtn.dto.ObtnRequset;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import static com.bismo.stellive.api.obtn.QObtn.obtn;
import static com.bismo.stellive.api.obtnDtl.QObtnDtl.obtnDtl;
import static com.bismo.stellive.api.comp.QCompany.company;
@Repository
@RequiredArgsConstructor
public class ObtnQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<ObtnResponse> read(ObtnRequset obtnRequset) {

        //랜덤으로 가지고옴
        return queryFactory
                .select(Projections.fields(ObtnResponse.class,
                        obtn.id,
                        obtn.obtnNm,
                        obtn.obtnMk,
                        obtn.inputId,
                        obtn.inputDate,
                        obtn.updateId,
                        obtn.updateDate,
                        obtn.mony,
                        company.compNm,
                        company.compAdr
                        ))
                .from(obtn)
                .leftJoin(obtn.obtnDtl, obtnDtl)
                .leftJoin(obtn.company)
                .orderBy(obtn.id.desc())
                .where(
                        obtnNmContains(obtnRequset.getObtnNm()),
                        obtnDtCompare(obtnRequset.getStartDt(), obtnRequset.getEndDt())
                )
//                .limit(10)
                .fetch();
    }

    public BooleanExpression obtnNmContains(String obtnNm) {
        if (!StringUtils.hasText(obtnNm)) {
            return null; // 조건 없음
        }
        return obtn.obtnNm.contains(obtnNm);
    }
    public BooleanExpression obtnDtCompare(String startDt, String endDt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime startDateTime = null;
        LocalDateTime endDateTime = null;

        try {
            if (startDt != null) {
                if(!startDt.equals("")){
                    LocalDate startDate = LocalDate.parse(startDt, formatter);
                    startDateTime = startDate.atStartOfDay();  // 00:00:00
                }

            }
            if (endDt != null) {
                if(!endDt.equals("")){
                    LocalDate endDate = LocalDate.parse(endDt, formatter);
                    endDateTime = endDate.atTime(LocalTime.MAX); // 23:59:59.999999999
                }
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }

        if (startDateTime != null && endDateTime != null) {
            return obtn.inputDate.between(startDateTime, endDateTime);
        } else if (startDateTime != null) {
            return obtn.inputDate.goe(startDateTime);
        } else if (endDateTime != null) {
            return obtn.inputDate.loe(endDateTime);
        } else {
            return null;
        }
    }
}
