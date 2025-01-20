package ru.gb.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import ru.gb.springdemo.model.Issue;

import java.util.ArrayList;
import java.util.List;


public interface IssueRepository extends JpaRepository<Issue, Long> {

    @Query("SELECT a FROM Issue a WHERE a.readerId = :reader_id")
    List<Issue> getByReaderId(Long reader_id);

//    private final List<Issue> issues;
//
//    public IssueRepository() {
//        this.issues = new ArrayList<>();
//    }
//
//    public void save(Issue issue) {
//        // insert into ....
//        issues.add( issue );
//    }
//
//    public Issue getIssueByID(long id) {
//        return issues.stream()
//                .filter( is -> Objects.equals( is.getId(), id ) )
//                .findFirst()
//                .orElse( null );
//    }
//
//    public Issue[] getIssuesByReaderId(long readerId) {
//        return issues.stream()
//                .filter( is -> Objects.equals( is.getReaderId(), readerId ) && is.getReturnedAt() == null )
//                .toArray( Issue[]::new );
//    }
//
//
//    public Issue[] getAllIssue() {
//        return (Issue[]) issues.stream()
//                .toArray(Issue[]::new);
//    }


}
