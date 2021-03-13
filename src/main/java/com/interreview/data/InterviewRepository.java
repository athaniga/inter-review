package com.interreview.data;

import com.interreview.models.Interview;
import org.springframework.data.repository.CrudRepository;

public interface InterviewRepository extends CrudRepository<Interview, Long> {

}
