package test.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserPointStatus is a Querydsl query type for UserPointStatus
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserPointStatus extends EntityPathBase<UserPointStatus> {

    private static final long serialVersionUID = -535353603L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserPointStatus userPointStatus = new QUserPointStatus("userPointStatus");

    public final StringPath status = createString("status");

    public final QUserPoint userPoint;

    public final NumberPath<Long> userPointStateId = createNumber("userPointStateId", Long.class);

    public final QUsers users;

    public QUserPointStatus(String variable) {
        this(UserPointStatus.class, forVariable(variable), INITS);
    }

    public QUserPointStatus(Path<? extends UserPointStatus> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserPointStatus(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserPointStatus(PathMetadata metadata, PathInits inits) {
        this(UserPointStatus.class, metadata, inits);
    }

    public QUserPointStatus(Class<? extends UserPointStatus> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userPoint = inits.isInitialized("userPoint") ? new QUserPoint(forProperty("userPoint"), inits.get("userPoint")) : null;
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

