// MemberRepository.java
public interface MemberRepository extends JpaRepository<Member, Long> {
}

// GroupRepository.java
public interface GroupRepository extends JpaRepository<Group, Long> {
}

// RelationshipRepository.java
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
}
