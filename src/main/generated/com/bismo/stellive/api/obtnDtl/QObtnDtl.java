package com.bismo.stellive.api.obtnDtl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QObtnDtl is a Querydsl query type for ObtnDtl
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QObtnDtl extends EntityPathBase<ObtnDtl> {

    private static final long serialVersionUID = -1068907569L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QObtnDtl obtnDtl = new QObtnDtl("obtnDtl");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.bismo.stellive.api.ItemHdr.QItemHdr itemHdr;

    public final NumberPath<Integer> obtnAmt = createNumber("obtnAmt", Integer.class);

    public final com.bismo.stellive.api.obtnHdr.QObtnHdr obtnHdr;

    public final NumberPath<Integer> obtnMony = createNumber("obtnMony", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> rgstDt = createDateTime("rgstDt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> rgstId = createNumber("rgstId", Integer.class);

    public final StringPath sortIndex = createString("sortIndex");

    public final EnumPath<ObtnDtl.Status> status = createEnum("status", ObtnDtl.Status.class);

    public final DateTimePath<java.time.LocalDateTime> updtDt = createDateTime("updtDt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> updtId = createNumber("updtId", Integer.class);

    public QObtnDtl(String variable) {
        this(ObtnDtl.class, forVariable(variable), INITS);
    }

    public QObtnDtl(Path<? extends ObtnDtl> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QObtnDtl(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QObtnDtl(PathMetadata metadata, PathInits inits) {
        this(ObtnDtl.class, metadata, inits);
    }

    public QObtnDtl(Class<? extends ObtnDtl> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.itemHdr = inits.isInitialized("itemHdr") ? new com.bismo.stellive.api.ItemHdr.QItemHdr(forProperty("itemHdr")) : null;
        this.obtnHdr = inits.isInitialized("obtnHdr") ? new com.bismo.stellive.api.obtnHdr.QObtnHdr(forProperty("obtnHdr"), inits.get("obtnHdr")) : null;
    }

}

