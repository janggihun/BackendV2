package com.bismo.stellive.api.compHdr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCompHdr is a Querydsl query type for CompHdr
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCompHdr extends EntityPathBase<CompHdr> {

    private static final long serialVersionUID = -1347747713L;

    public static final QCompHdr compHdr = new QCompHdr("compHdr");

    public final StringPath compAdr = createString("compAdr");

    public final StringPath compCd = createString("compCd");

    public final StringPath compNm = createString("compNm");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QCompHdr(String variable) {
        super(CompHdr.class, forVariable(variable));
    }

    public QCompHdr(Path<? extends CompHdr> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompHdr(PathMetadata metadata) {
        super(CompHdr.class, metadata);
    }

}

