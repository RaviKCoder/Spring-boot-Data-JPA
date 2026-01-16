package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.FileRecord;

public interface IFileRecordRepository extends JpaRepository<FileRecord ,Long> {

}
