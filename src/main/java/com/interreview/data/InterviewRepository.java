package com.interreview.data;

import com.interreview.models.Interview;
import com.interreview.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InterviewRepository extends CrudRepository<Interview, Long> {
    public List<Interview> findInterviewByUser(User user);
}
