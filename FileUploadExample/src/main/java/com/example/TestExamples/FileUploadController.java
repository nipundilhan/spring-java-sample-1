package com.example.TestExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.TestExamples.ExcelReader.RowConverter;

@RestController
@RequestMapping("/upload-file")
public class FileUploadController {
	
	@PostMapping("/upload")
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file){
		try {
		String fileName = file.getOriginalFilename();
	
		file.transferTo(new File("E:\\SprintBoot\\TestUploads\\"+fileName));
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return ResponseEntity.ok("file uploaded successfully");
		
	}
	
	@GetMapping(value = "/download")
	public ResponseEntity<Object> downloadFile() throws IOException
	{
		
		String filename = "E:\\SprintBoot\\TestDownloads\\Capture.JPG";
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition",
				String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}
	
	
	@GetMapping("/test")
	public String test(){
		return "test";
		
		
	}
	
	
	@PostMapping("/read-csv")
	public ResponseEntity<?> readcsv(@RequestParam("file") MultipartFile file){
		try {
		String fileName = file.getOriginalFilename();
		List<EnfBuTestItemRequest> memberList = readExcellFile(file);
		
		
		for(EnfBuTestItemRequest item : memberList) {
			System.out.print(" name - "+item.getName()+"  , nic -  ");
			System.out.println(item.getNicNo());
			
			
		}
		
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return ResponseEntity.ok("csv read successfully");
		
	}
	
	
	private List<EnfBuTestItemRequest> readExcellFile(MultipartFile file) {
		ExcelReader<EnfBuTestItemRequest> reader;
		RowConverter<EnfBuTestItemRequest> converter = row -> new EnfBuTestItemRequest(
				(String) row[0],
				(String) row[1]);

		reader = ExcelReader.builder(EnfBuTestItemRequest.class).converter(converter).withHeader()
				.csvDelimiter(',').sheets(1).build();
		List<EnfBuTestItemRequest> list = null;
		try {
			list = reader.read(file.getInputStream(),2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
