package com.bismo.stellive.api.obtnDtl;


import ch.qos.logback.core.util.StringUtil;
import com.bismo.stellive.api.obtn.dto.ObtnRequset;
import com.bismo.stellive.api.obtnDtl.dto.ObtnDtlResponse;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bismo.stellive.api.obtnDtl.QObtnDtl.obtnDtl;
import static com.bismo.stellive.api.obtnHdr.QObtnHdr.obtnHdr;
import static com.bismo.stellive.api.user.QUser.user;

@RequiredArgsConstructor
@Repository
public class ObtnDtlQueryRepository {
    private final JPAQueryFactory queryFactory;


    public List<ObtnDtlResponse> read(ObtnRequset obtnRequset) {
//
//
        return queryFactory
                .select(Projections.fields(ObtnDtlResponse.class,
                        obtnDtl.id,
                        obtnDtl.sortIndex,
                        obtnDtl.itemHdr,
                        obtnDtl.obtnAmt,
                        obtnDtl.obtnMony,
                        obtnDtl.status,
                        ExpressionUtils.as(
                                JPAExpressions.select(user.userName)
                                        .from(user)
                                        .where(user.id.eq(obtnDtl.rgstId.longValue())), "rgstNm"
                        ),
                        obtnDtl.rgstDt,
                        ExpressionUtils.as(
                                JPAExpressions.select(user.userName)
                                        .from(user)
                                        .where(user.id.eq(obtnDtl.updtId.longValue())), "updtNm"
                        ),
                        obtnDtl.updtDt
                ))
                .from(obtnDtl)
                .orderBy(obtnDtl.sortIndex.asc())
                .where(
                       obtnIdEq(obtnRequset.getId())

                )

                .fetch();
    }

    private BooleanExpression obtnIdEq(Long obtnId) {
        return obtnId == null ? null :   obtnHdr.id.eq(obtnId);
    }
}
