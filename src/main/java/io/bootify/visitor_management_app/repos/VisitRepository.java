package io.bootify.visitor_management_app.repos;

import io.bootify.visitor_management_app.domain.Visit;
import io.bootify.visitor_management_app.model.VisitStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findByStatus(VisitStatus status);
}
