package ru.gb.springdemo.repository;

import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.Issue;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class IssueRepository {

    private final List<Issue> issues;
    public IssueRepository() {
        this.issues = new ArrayList<>();
    }
    public void save(Issue issue) {
        // insert into ....
        issues.add( issue );
    }

    public Issue getIssueByID(long id) {
        return issues.stream()
                .filter( is -> Objects.equals( is.getId(), id ) )
                .findFirst()
                .orElse( null );
    }

    public Issue[] getIssuesByReaderId(long readerId) {
        return issues.stream()
                .filter( is -> Objects.equals( is.getReaderId(), readerId ) && is.getReturnedAt() == null )
                .toArray( Issue[]::new );
    }


    public Issue[] getAllIssue() {
        return (Issue[]) issues.stream()
                .toArray(Issue[]::new);
    }


}
