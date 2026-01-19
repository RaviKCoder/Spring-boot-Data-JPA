package com.ravi.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.FileRecord;
import com.ravi.service.IFileRecordService;

@Component
public class FileRecordRunner implements CommandLineRunner {

	@Autowired
	IFileRecordService service;
	
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void run(String... args) throws Exception {
		
		while(true) {
			
			try {
				
				System.out.println("1.Store file and image.");
				System.out.println("2.Retrieve file and image.");
				System.out.println("3.Exit");
				System.out.println("===========================");
				System.out.print("Select your choice: ");
				
				int choice=sc.nextInt();
				
				switch(choice) {
				
				case 1->{
					System.out.print("enter photo path: ");
					String imageFilePath=sc.next().trim();//D:\file\img4.jpg
					
					System.out.print("enter text path: ");
					String textFilePath=sc.next().trim();//D:\file\recoveryKey.txt
					
					String storeFileAndImage = service.storeFileAndImage(textFilePath, imageFilePath);
					System.out.println(storeFileAndImage);	
				}
				case 2->{
					
					System.out.print("enter id: ");
					Long id=sc.nextLong();
					
					System.out.print("Output text path: ");
					String outputTextPath=sc.next().trim();//retrive_text.txt
					
					System.out.print("Output photo path: ");
					String outputPhotoPath=sc.next().trim();//retrive_image.jpg
					
					try(FileOutputStream fos=new FileOutputStream(outputPhotoPath);
							FileWriter fw=new FileWriter(outputTextPath);){
						
						FileRecord filRrecord = service.retrieveAndWriteToDisk(id);
						
						System.out.println("File record details are: "+filRrecord.getId()+"...."+filRrecord.getFileName());
						
						//Retrive  LOB vlaues from entity object and write to dest file
						
						byte[] fileImage = filRrecord.getFileImage();
						char[] fileText = filRrecord.getFileText();
						
						
						fos.write(fileImage);
						fw.write(fileText);
						System.out.println("large object are retrieved successfully");
						
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				case 3->{
					System.out.println("Tankyou...............");
					System.exit(0);
					
				}
				default ->{
					System.out.println("Invalid choice.");
				}
				}	
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
	}
}











