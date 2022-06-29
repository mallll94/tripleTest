package test.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserPoint is a Querydsl query type for UserPoint
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserPoint extends EntityPathBase<UserPoint> {

    private static final long serialVersionUID = -23218389L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserPoint userPoint1 = new QUserPoint("userPoint1");

    public final NumberPath<Integer> userPoint = createNumber("userPoint", Integer.class);

    public final NumberPath<Long> userPointId = createNumber("userPointId", Long.class);

    public final ListPath<UserPointStatus, QUserPointStatus> userPointStatus = this.<UserPointStatus, QUserPointStatus>createList("userPointStatus", UserPointStatus.class, QUserPointStatus.class, PathInits.DIRECT2);

    public final QUsers users;

    public QUserPoint(String variable) {
        this(UserPoint.class, forVariable(variable), INITS);
    }

    public QUserPoint(Path<? extends UserPoint> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserPoint(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserPoint(PathMetadata metadata, PathInits inits) {
        this(UserPoint.class, metadata, inits);
    }

    public QUserPoint(Class<? extends UserPoint> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

