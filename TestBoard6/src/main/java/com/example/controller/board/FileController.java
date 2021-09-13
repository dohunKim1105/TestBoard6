package com.example.controller.board;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import com.example.dto.board.*;
import com.example.service.*;

@Controller
@RequestMapping(value="/bbs")
public class FileController {
    
	@Autowired
	private FileService fileService;
	
	@Autowired
	private BoardService boardService;
	
    @RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
    public String dragAndDrop(Model model) {
        System.out.println("controller : dragAndDrop");
        
        return "fileUpload";
    }
    
    @RequestMapping(value = "/fileUpload/post") //ajax에서 호출하는 부분
    @ResponseBody
    public String upload(MultipartHttpServletRequest multipartRequest) { //Multipart로 받는다.
    	System.out.println("controller : upload");
    	
        Iterator<String> itr =  multipartRequest.getFileNames();
        
        
        int nextNum = boardService.boardNextNum();
        
        //서버에 저장될 파일 경로 지정
        String filePath = "C:/Users/forensic05/Downloads/boardTest"; //설정파일로 뺀다.

        while (itr.hasNext()) { //받은 파일들을 모두 돌린다.
            MultipartFile mpf = multipartRequest.getFile(itr.next());
            
            String originalFilename = mpf.getOriginalFilename(); //파일명
            String fileFullPath = filePath + "/" + originalFilename; //파일 전체 경로
            
            try {
                //파일 저장
                mpf.transferTo(new File(fileFullPath)); //파일저장 실제로는 service에서 처리
                
                FileDto fileDto = new FileDto();
                fileDto.setFilePath(filePath + "/");
                fileDto.setFileName(originalFilename);
                fileDto.setBoardNum(nextNum);
                
				int fileInsertResult = fileService.fileUplaod(fileDto );
				
				if(fileInsertResult == 1) {
					System.out.println("File Insert Result : " + fileInsertResult);
				}else {
					System.out.println("File Insert Result : " + fileInsertResult);
				}
				
                System.out.println("originalFilename => "+originalFilename);
                System.out.println("fileFullPath => "+fileFullPath);
     
            } catch (Exception e) {
                System.out.println("postTempFile_ERROR======>"+fileFullPath);
                e.printStackTrace();
            }
       }
       return "success";
    }
    
    @PostMapping("/fileDownload")
    public void fileDownloadPost() {
    	System.out.println("controller : filedownload POST");
    }
    
    @GetMapping(value="/fileDownload")
//    public void fileDownload( HttpServletResponse response, HttpServletRequest request, @RequestParam Map<String, String> paramMap) {
    public void fileDownload( HttpServletResponse response, HttpServletRequest request, @RequestParam(value="fileName") String fileName) {
    	System.out.println("controller : fileDownload");
    	
//    	String savePath = "C:/Users/forensic05/Downloads/boardTest/";
//    	String filename = "EnCase.pdf";
//    	String orgfilename = "EnCase.pdf";
    	
//        String path = paramMap.get("filePath"); //full경로
//        String fileName = paramMap.get("fileName"); //파일명
        String path = "C:/Users/forensic05/Downloads/boardTest/";
//        fileName = "free-icon-instagram-220607.png";
        System.out.println("path : " + path);
        System.out.println("fileName: " + fileName);
     
        File file = new File(path + fileName);
        
        FileInputStream fileInputStream = null;
     
        ServletOutputStream servletOutputStream = null;
        try{
            String downName = null;
            String browser = request.getHeader("User-Agent");
            //파일 인코딩
            if(browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")){//브라우저 확인 파일명 encode  
                
                downName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");	//한글파일명 깨지지 않도록
                
            }else{
                
                downName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
                
            }
            
            response.setHeader("Content-Disposition","attachment;filename=\"" + downName+"\"");             
            response.setContentType("application/octer-stream");
            response.setHeader("Content-Transfer-Encoding", "binary;");
     
            fileInputStream = new FileInputStream(file);
            servletOutputStream = response.getOutputStream();
     
            byte b [] = new byte[1024];
            int data = 0;
     
            while((data=(fileInputStream.read(b, 0, b.length))) != -1){
                
                servletOutputStream.write(b, 0, data);
                
            }
     
            servletOutputStream.flush();//출력
            
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(servletOutputStream!=null){
                try{
                    servletOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fileInputStream!=null){
                try{
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    @GetMapping(value = "/fileDelete")
    public String fileDelete(
    		@RequestParam(value="fileName") String fileName,
    		@RequestParam(value="boardNum") int boardNum
    		) {
    	System.out.println("controller : fileDelete");

    	FileDto fileDto = new FileDto(fileName, boardNum);
    	int result = fileService.fileDelete(fileDto);
    	
		if(result == 1) {
			String path = "C:/Users/forensic05/Downloads/boardTest/";
			File file = new File(path + fileName);
			
	    	if( file.exists() ){
	    		if(file.delete()){ 
	    			System.out.println("파일삭제 성공");
	    		}else{ 
	    			System.out.println("파일삭제 실패"); 
	    		} 
	    	}else{
	    		System.out.println("파일이 존재하지 않습니다.");
	    	}
	    	
			System.out.println("file delete success : Query");
		}else {
			System.out.println("file delete fail : Query");
		}
		    	
    	return "redirect:/bbs/detail?num=" + boardNum;
    }
}