package com.bismo.stellive.api.ItemHdr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemHdr is a Querydsl query type for ItemHdr
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItemHdr extends EntityPathBase<ItemHdr> {

    private static final long serialVersionUID = -1291483305L;

    public static final QItemHdr itemHdr = new QItemHdr("itemHdr");

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    public final NumberPath<Integer> itemMony = createNumber("itemMony", Integer.class);

    public final StringPath itemNm = createString("itemNm");

    public QItemHdr(String variable) {
        super(ItemHdr.class, forVariable(variable));
    }

    public QItemHdr(Path<? extends ItemHdr> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemHdr(PathMetadata metadata) {
        super(ItemHdr.class, metadata);
    }

}

