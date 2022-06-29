package test.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = 575563694L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsers users = new QUsers("users");

    public final QReview review;

    public final StringPath userId = createString("userId");

    public final StringPath userName = createString("userName");

    public final QUserPoint userPoint;

    public final ListPath<UserPointStatus, QUserPointStatus> userPointStatus = this.<UserPointStatus, QUserPointStatus>createList("userPointStatus", UserPointStatus.class, QUserPointStatus.class, PathInits.DIRECT2);

    public QUsers(String variable) {
        this(Users.class, forVariable(variable), INITS);
    }

    public QUsers(Path<? extends Users> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsers(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsers(PathMetadata metadata, PathInits inits) {
        this(Users.class, metadata, inits);
    }

    public QUsers(Class<? extends Users> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
        this.userPoint = inits.isInitialized("userPoint") ? new QUserPoint(forProperty("userPoint"), inits.get("userPoint")) : null;
    }

}
