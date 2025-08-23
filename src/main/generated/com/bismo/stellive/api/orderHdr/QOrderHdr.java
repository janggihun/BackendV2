package com.bismo.stellive.api.orderHdr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderHdr is a Querydsl query type for OrderHdr
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderHdr extends EntityPathBase<OrderHdr> {

    private static final long serialVersionUID = -649299891L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderHdr orderHdr = new QOrderHdr("orderHdr");

    public final com.bismo.stellive.api.compHdr.QCompHdr compHdr;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath orderMk = createString("orderMk");

    public final StringPath orderNm = createString("orderNm");

    public final DateTimePath<java.time.LocalDateTime> rgstDt = createDateTime("rgstDt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> rgstId = createNumber("rgstId", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updtDt = createDateTime("updtDt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> updtId = createNumber("updtId", Integer.class);

    public QOrderHdr(String variable) {
        this(OrderHdr.class, forVariable(variable), INITS);
    }

    public QOrderHdr(Path<? extends OrderHdr> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderHdr(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderHdr(PathMetadata metadata, PathInits inits) {
        this(OrderHdr.class, metadata, inits);
    }

    public QOrderHdr(Class<? extends OrderHdr> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.compHdr = inits.isInitialized("compHdr") ? new com.bismo.stellive.api.compHdr.QCompHdr(forProperty("compHdr")) : null;
    }

}

