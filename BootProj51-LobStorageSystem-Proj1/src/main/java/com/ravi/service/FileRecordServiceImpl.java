package com.ravi.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.FileRecord;
import com.ravi.repository.IFileRecordRepository;

@Service
public class FileRecordServiceImpl implements IFileRecordService {

	@Autowired
	IFileRecordRepository repository;
	Scanner sc=new Scanner(System.in);
	
	@Override
	public String storeFileAndImage(String textFilePath, String imageFilePath) throws Exception {
		
		try {
			System.out.print("enter file name: ");
			String fileName=sc.nextLine();
			
			byte[] photo=null;
			char[] text=null;
			
			try(FileInputStream fis=new FileInputStream(imageFilePath);
					FileReader reader=new FileReader(textFilePath);){
				
				photo= fis.readAllBytes();
				
				File file=new File(textFilePath);
				
				text=new char[(int)file.length()];
				
				reader.read(text);	
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			FileRecord fileRecord=new FileRecord(fileName, photo, text);
			repository.save(fileRecord);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "File and text stored successfully with id: ";
	}
	
	
	@Override
	public FileRecord retrieveAndWriteToDisk(Long id) throws Exception {
		
		FileRecord fileRecord = repository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id"));
		return fileRecord;
	}

	

}
