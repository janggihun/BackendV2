package com.bismo.stellive.api.obtnHdr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QObtnHdr is a Querydsl query type for ObtnHdr
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QObtnHdr extends EntityPathBase<ObtnHdr> {

    private static final long serialVersionUID = 1222648835L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QObtnHdr obtnHdr = new QObtnHdr("obtnHdr");

    public final com.bismo.stellive.api.compHdr.QCompHdr compHdr;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> obtnDt = createDateTime("obtnDt", java.time.LocalDateTime.class);

    public final ListPath<com.bismo.stellive.api.obtnDtl.ObtnDtl, com.bismo.stellive.api.obtnDtl.QObtnDtl> obtnDtls = this.<com.bismo.stellive.api.obtnDtl.ObtnDtl, com.bismo.stellive.api.obtnDtl.QObtnDtl>createList("obtnDtls", com.bismo.stellive.api.obtnDtl.ObtnDtl.class, com.bismo.stellive.api.obtnDtl.QObtnDtl.class, PathInits.DIRECT2);

    public final StringPath obtnMk = createString("obtnMk");

    public final StringPath obtnNm = createString("obtnNm");

    public final DateTimePath<java.time.LocalDateTime> rgstDt = createDateTime("rgstDt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> rgstId = createNumber("rgstId", Integer.class);

    public final EnumPath<ObtnHdr.Status> status = createEnum("status", ObtnHdr.Status.class);

    public final EnumPath<ObtnHdr.Stx> stx = createEnum("stx", ObtnHdr.Stx.class);

    public final DateTimePath<java.time.LocalDateTime> updtDt = createDateTime("updtDt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> updtId = createNumber("updtId", Integer.class);

    public QObtnHdr(String variable) {
        this(ObtnHdr.class, forVariable(variable), INITS);
    }

    public QObtnHdr(Path<? extends ObtnHdr> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QObtnHdr(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QObtnHdr(PathMetadata metadata, PathInits inits) {
        this(ObtnHdr.class, metadata, inits);
    }

    public QObtnHdr(Class<? extends ObtnHdr> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.compHdr = inits.isInitialized("compHdr") ? new com.bismo.stellive.api.compHdr.QCompHdr(forProperty("compHdr")) : null;
    }

}

