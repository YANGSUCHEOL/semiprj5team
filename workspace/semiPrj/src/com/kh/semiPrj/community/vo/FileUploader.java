package com.kh.semiPrj.community.vo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.Part;

public class FileUploader {

	public static AttachmentVo uploadFile(Part f, String rootPath) throws IOException {
		
		// 0. 준비
		String originName = f.getSubmittedFileName();
		String ext = originName.substring(originName.lastIndexOf("."), originName.length());
		String changeName = "GetEatVegan" + System.currentTimeMillis() + ext;
		
		// 1. 파일 객체 준비 (경로 + 파일명)
		String filePath = "upload/community/img";
		String path = rootPath + filePath + "/";
		File target = new File(path + changeName);
		
		// 2. 데이터 넣기	
		BufferedInputStream bis = new BufferedInputStream(f.getInputStream()); //BufferedInputStream == bis
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target)); //BufferedOutputStream == bos
		
		byte[] buf = new byte[1024];

		int size = 0;
		while((size = bis.read(buf)) != -1) {
			bos.write(buf, 0, size);					
		}
		
		bos.flush();
		bis.close();
		bos.close();
			
		AttachmentVo vo = new AttachmentVo();
		vo.setChangeName(changeName);
		vo.setOriginName(originName);
		vo.setFilePath(filePath);
		
		return vo;
		
	}
	
	
	
}
