package com.bismo.stellive.api.obtn;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QObtn is a Querydsl query type for Obtn
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QObtn extends EntityPathBase<Obtn> {

    private static final long serialVersionUID = -1552806547L;

    public static final QObtn obtn = new QObtn("obtn");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> inputDate = createDateTime("inputDate", java.time.LocalDateTime.class);

    public final StringPath inputId = createString("inputId");

    public final ListPath<com.bismo.stellive.api.obtnDtl.ObtnDtl, com.bismo.stellive.api.obtnDtl.QObtnDtl> obtnDtl = this.<com.bismo.stellive.api.obtnDtl.ObtnDtl, com.bismo.stellive.api.obtnDtl.QObtnDtl>createList("obtnDtl", com.bismo.stellive.api.obtnDtl.ObtnDtl.class, com.bismo.stellive.api.obtnDtl.QObtnDtl.class, PathInits.DIRECT2);

    public final StringPath obtnMk = createString("obtnMk");

    public final NumberPath<Integer> obtnMony = createNumber("obtnMony", Integer.class);

    public final StringPath obtnNm = createString("obtnNm");

    public final DateTimePath<java.time.LocalDateTime> updateDate = createDateTime("updateDate", java.time.LocalDateTime.class);

    public final StringPath updateId = createString("updateId");

    public QObtn(String variable) {
        super(Obtn.class, forVariable(variable));
    }

    public QObtn(Path<? extends Obtn> path) {
        super(path.getType(), path.getMetadata());
    }

    public QObtn(PathMetadata metadata) {
        super(Obtn.class, metadata);
    }

}

