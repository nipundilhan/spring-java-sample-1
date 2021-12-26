package com.example.TestExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

@RestController
@RequestMapping("/upload-file-sftp")
public class FileUploadSftpController {
	
    @Autowired
    ResourceLoader resourceLoader;
	
	@PostMapping("/upload")
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file){
		try {
			
			String fileName = file.getOriginalFilename();
			
		    ChannelSftp channelSftp = setupJsch();
		    channelSftp.connect();
		 
		   
		    String remoteDir = "/test/";
		 
		    channelSftp.put(file.getInputStream(), remoteDir + fileName);
		 
		    channelSftp.exit();
		    System.out.println("uploaded");
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return ResponseEntity.ok("file uploaded successfully");
		
	}
	
	@GetMapping("/download")
	public ResponseEntity<Object> downloadFile() {
	    ChannelSftp channelSftp;
	    
	    ResponseEntity<Object> responseEntity = null;
		try {
			channelSftp = setupJsch();
		    channelSftp.connect();
			 
		    String remoteFile = "/test/prn_devage.txt";
		    String localDir = "C:\\Users\\INOVA\\Desktop\\downloadsftp\\" ;
		 

		    
		    InputStream inputStream = channelSftp.get(remoteFile);
			channelSftp.get(remoteFile, localDir + "jschFile.txt");

			

		 
		    channelSftp.exit();
		    
		    return responseEntity;

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseEntity;

	}
	
	
	@GetMapping("/download2")
	public ResponseEntity<Object> downloadFile2() {
	    ChannelSftp channelSftp;
	    
	    ResponseEntity<Object> responseEntity = null;
		try {
			channelSftp = setupJsch();
		    channelSftp.connect();
			 
		    String remoteFile = "/test/prn_devage.txt";
		    String localDir = "src/main/resources/sample.txt";
			//channelSftp.get(remoteFile, localDir);
			InputStream inputStream = channelSftp.get(remoteFile);
		    
		    Resource resource1 = new ClassPathResource("sample.txt");
			//Resource resource1 = resourceLoader.getResource("classpath:sample.txt");
			File file = resource1.getFile();
			
			InputStreamResource resource = new InputStreamResource(inputStream);
			//InputStreamResource resource = new InputStreamResource
			System.out.println("file name "+ file.getName());
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition",
					String.format("attachment; filename=\"%s\"", file.getName()));
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");

			responseEntity = ResponseEntity.ok().headers(headers)
					.contentLength(file.length())
					.contentType(MediaType.parseMediaType("application/txt")).body(resource);
			

		 
			channelSftp.exit();


			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception occurs");
			e.printStackTrace();
		}
		
		return responseEntity;

	}
	
	
	private ChannelSftp setupJsch() throws JSchException {
	    JSch jsch = new JSch();
	 
	    Session jschSession = jsch.getSession("nipun", "192.168.43.109", 22);
	    jschSession.setConfig("StrictHostKeyChecking", "no");
	    jschSession.setPassword("nipun");
	    jschSession.connect();
	    return (ChannelSftp) jschSession.openChannel("sftp");
	}

}
