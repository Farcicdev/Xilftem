package com.xilften.repository;

import com.xilften.model.StreamingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<StreamingModel, Long> {
}
