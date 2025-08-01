package com.bismo.stellive.api.obtn;

import com.bismo.stellive.api.obtn.dto.ObtnResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bismo.stellive.api.obtn.QObtn.obtn;
import static com.bismo.stellive.api.obtnDtl.QObtnDtl.obtnDtl;

@Repository
@RequiredArgsConstructor
public class ObtnQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<ObtnResponse> read() {

        //랜덤으로 가지고옴
        return queryFactory
                .select(Projections.fields(ObtnResponse.class,
                        obtn.id,
                        obtn.obtnNm,
                        obtn.obtnMk,
                        obtn.inputId,
                        obtn.inputDate,
                        obtn.updateId,
                        obtn.updateDate
                        ))
                .from(obtn)
                .leftJoin(obtn.obtnDtl, obtnDtl)
                .orderBy(obtn.id.desc())
//                .where()
//                .limit(10)
                .fetch();
    }


}
