package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args); 
		
	// Member.java
	@Entity
	public class Member {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    // getters and setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	}

	// Group.java
	@Entity
	public class Group {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String groupName;

	    @OneToMany(mappedBy = "group")
	    private List<Relationship> relationships;

	    // getters and setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getGroupName() {
	        return groupName;
	    }

	    public void setGroupName(String groupName) {
	        this.groupName = groupName;
	    }

	    public List<Relationship> getRelationships() {
	        return relationships;
	    }

	    public void setRelationships(List<Relationship> relationships) {
	        this.relationships = relationships;
	    }
	}

	// Relationship.java
	@Entity
	public class Relationship {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "member_id")
	    private Member member;

	    @ManyToOne
	    @JoinColumn(name = "group_id")
	    private Group group;

	    // getters and setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Member getMember() {
	        return member;
	    }

	    public void setMember(Member member) {
	        this.member = member;
	    }

	    public Group getGroup() {
	        return group;
	    }

	    public void setGroup(Group group) {
	        this.group = group;
	    }
	}

}
}