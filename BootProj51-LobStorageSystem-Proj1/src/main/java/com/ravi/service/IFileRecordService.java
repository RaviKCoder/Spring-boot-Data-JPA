package com.ravi.service;

import com.ravi.entity.FileRecord;

public interface IFileRecordService {

	public String storeFileAndImage(String textFilePath, String imageFilePath)throws Exception;

	public FileRecord retrieveAndWriteToDisk(Long id)throws Exception;
	
}
