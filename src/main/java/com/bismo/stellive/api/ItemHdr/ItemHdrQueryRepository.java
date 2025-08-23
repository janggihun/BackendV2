package com.bismo.stellive.api.ItemHdr;

import com.bismo.stellive.api.ItemHdr.dto.ItemResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bismo.stellive.api.ItemHdr.QItemHdr.itemHdr;

@Repository
@RequiredArgsConstructor
public class ItemHdrQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<ItemResponse> read() {

        return queryFactory
                .select(Projections.fields(ItemResponse.class,
                        itemHdr.itemId,
                        itemHdr.itemCd,
                        itemHdr.itemNm,
                        itemHdr.itemMony
                ))
                .from(itemHdr)
                .where(

                )
//                .limit(10)
                .fetch();
    }
}
