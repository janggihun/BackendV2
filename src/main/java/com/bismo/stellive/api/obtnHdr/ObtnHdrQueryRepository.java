package com.bismo.stellive.api.obtnHdr;


import com.bismo.stellive.api.obtnHdr.dto.ObtnHdrResponse;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bismo.stellive.api.compHdr.QCompHdr.compHdr;
import static com.bismo.stellive.api.obtnHdr.QObtnHdr.obtnHdr;
import static com.bismo.stellive.api.user.QUser.user;
@RequiredArgsConstructor
@Repository
public class ObtnHdrQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<ObtnHdrResponse> read() {
//
        //랜덤으로 가지고옴
        return queryFactory
                .select(Projections.fields(ObtnHdrResponse.class,
                        obtnHdr.id,
                        obtnHdr.obtnNm,
                        obtnHdr.obtnMk,
                        obtnHdr.status,
                        obtnHdr.obtnDt,
                        obtnHdr.stx,
                        ExpressionUtils.as(
                                JPAExpressions.select(user.userName)
                                        .from(user)
                                        .where(user.id.eq(obtnHdr.rgstId.longValue())), "rgstNm"
                        ),
                        obtnHdr.rgstDt,
                        ExpressionUtils.as(
                                JPAExpressions.select(user.userName)
                                        .from(user)
                                        .where(user.id.eq(obtnHdr.updtId.longValue())), "updtNm"
                        ),
                        obtnHdr.updtDt,
                        compHdr
                ))
                .from(obtnHdr)

                .orderBy(obtnHdr.id.desc())
                .where(
//                        obtnNmContains(obtnRequset.getObtnNm()),
//                        obtnDtCompare(obtnRequset.getStartDt(), obtnRequset.getEndDt())
                )
//                .limit(10)
                .fetch();
    }

}
