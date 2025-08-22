package com.bismo.stellive.api.Item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = -739643123L;

    public static final QItem item = new QItem("item");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<Integer> itemMony = createNumber("itemMony", Integer.class);

    public final StringPath itemNm = createString("itemNm");

    public QItem(String variable) {
        super(Item.class, forVariable(variable));
    }

    public QItem(Path<? extends Item> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItem(PathMetadata metadata) {
        super(Item.class, metadata);
    }

}

