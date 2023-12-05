// MemberController.java
@RestController
@RequestMapping("/members")
public class MemberController {
	// MemberController.java
	@RestController
	@RequestMapping("/members")
	public class MemberController {
	    
	    @Autowired
	    private MemberRepository memberRepository;

	    @GetMapping
	    public List<Member> getAllMembers() {
	        return memberRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
	        Optional<Member> member = memberRepository.findById(id);
	        return member.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PostMapping
	    public ResponseEntity<Member> createMember(@RequestBody Member member) {
	        Member savedMember = memberRepository.save(member);
	        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member updatedMember) {
	        Optional<Member> existingMember = memberRepository.findById(id);

	        return existingMember.map(member -> {
	            member.setName(updatedMember.getName());
	            Member savedMember = memberRepository.save(member);
	            return new ResponseEntity<>(savedMember, HttpStatus.OK);
	        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
	        Optional<Member> member = memberRepository.findById(id);
	        if (member.isPresent()) {
	            memberRepository.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}

}

// GroupController.java
@RestController
@RequestMapping("/groups")
public class GroupController {
	// GroupController.java
	@RestController
	@RequestMapping("/groups")
	public class GroupController {
	    
	    @Autowired
	    private GroupRepository groupRepository;

	    @GetMapping
	    public List<Group> getAllGroups() {
	        return groupRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
	        Optional<Group> group = groupRepository.findById(id);
	        return group.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PostMapping
	    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
	        Group savedGroup = groupRepository.save(group);
	        return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Group> updateGroup(@PathVariable Long id, @RequestBody Group updatedGroup) {
	        Optional<Group> existingGroup = groupRepository.findById(id);

	        return existingGroup.map(group -> {
	            group.setGroupName(updatedGroup.getGroupName());
	            Group savedGroup = groupRepository.save(group);
	            return new ResponseEntity<>(savedGroup, HttpStatus.OK);
	        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
	        Optional<Group> group = groupRepository.findById(id);
	        if (group.isPresent()) {
	            groupRepository.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}

}

// RelationshipController.java
@RestController
@RequestMapping("/relationships")
public class RelationshipController {
	// RelationshipController.java
	@RestController
	@RequestMapping("/relationships")
	public class RelationshipController {
	    
	    @Autowired
	    private RelationshipRepository relationshipRepository;

	    @GetMapping
	    public List<Relationship> getAllRelationships() {
	        return relationshipRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Relationship> getRelationshipById(@PathVariable Long id) {
	        Optional<Relationship> relationship = relationshipRepository.findById(id);
	        return relationship.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PostMapping
	    public ResponseEntity<Relationship> createRelationship(@RequestBody Relationship relationship) {
	        Relationship savedRelationship = relationshipRepository.save(relationship);
	        return new ResponseEntity<>(savedRelationship, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Relationship> updateRelationship(@PathVariable Long id, @RequestBody Relationship updatedRelationship) {
	        Optional<Relationship> existingRelationship = relationshipRepository.findById(id);

	        return existingRelationship.map(relationship -> {
	            relationship.setMember(updatedRelationship.getMember());
	            relationship.setGroup(updatedRelationship.getGroup());
	            Relationship savedRelationship = relationshipRepository.save(relationship);
	            return new ResponseEntity<>(savedRelationship, HttpStatus.OK);
	        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteRelationship(@PathVariable Long id) {
	        Optional<Relationship> relationship = relationshipRepository.findById(id);
	        if (relationship.isPresent()) {
	            relationshipRepository.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}

}
