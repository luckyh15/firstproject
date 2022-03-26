package com.semi.flix.common;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	 
	static String filePath= CommonConst.FilePath;
	
	
	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		FileUploadUtil.filePath = filePath;
	}


	public static void upload(String contextPath, List<MultipartFile> fileList,
			List<String> fileNameList)
	{
	
		String filePath = contextPath + CommonConst.FilePath;
		System.out.println("�쁽�옱寃쎈줈 : " + filePath);
		//java.io.File
		File file = new File(filePath);
		if( !file.exists())
		{

			file.mkdir();
		}
		
		//System.out.println("filesize : " + fileList.size());
		
		if( fileList!=null && fileList.size()>0)
		{
			 for(MultipartFile multipartFile : fileList)
			 {		
				 if( multipartFile.getOriginalFilename().length()==0)//�뙆�씪�씠 �뾾�떎  
					   break;
				
				 
				 String orifilename = multipartFile.getOriginalFilename(); //�뾽濡쒕뱶�맂 �뙆�씪紐낆쓣 媛��졇�삩�떎 
	             
	             //�뙆�씪紐낆씠 以묐났�릺�뒗嫄� 諛⑹��븯湲곗쐞�빐�꽌 , 1. �궇吏쒖떆媛꾨텇珥� +�옖�뜡媛� �빐�꽌 �뙆�씪紐낆쓣 留뚮뱺�떎
	             //                             2. a(1).jpg, a(2).jpg ........
	             //�뙆�씪紐낃낵 �솗�옣�옄瑜� 遺꾨━�빐�빞 �븳�떎  
				 
				 int pos = orifilename.lastIndexOf(".");       //留⑤뮘履쎌쓽 . �쐞移섎�� �뙆�븙�븳�떎. 
				 String ext = orifilename.substring(pos+1);    //�솗�옣�옄
				 String oriFile = orifilename.substring(0, pos); //�뙆�씪紐낅쭔
							 
				 String filename = multipartFile.getOriginalFilename(); //�깉濡쒕쭔�뱾 �뙆�씪紐�
				
				 File newFile = new File(filePath+"/" +filename); //�썝�옒 �뙆�씪紐� 
				 int i=1;
				 while(newFile.exists())  //�씠誘몄〈�옱�븯硫�   a(1).jpg, a(2).jpg
				 {
					
					 filename = oriFile + "("+i+")." + ext;  //�깉濡쒖슫 �뙆�씪紐낆쓣 留뚮뱾�뼱�꽌 
					 i++;
					 newFile = new File(filePath+"/" +filename);
					 
				 }
				 
				 System.out.println("filename : " + filename);
				 fileNameList.add(filename); //�솗�젙�맂 �뙆�씪紐낆쓣 由ъ뒪�듃�뿉 ���옣�빐�꽌 蹂대궦�떎. �뵒鍮꾩뿉 ���옣�빐�빞 �릺�꽌  
		            
	             //�솗�젙�맂 �뙆�씪紐낆쑝濡� �엫�떆���옣�냼�뿉�꽌 �뾽濡쒕뱶 ���옣�냼濡� �삷湲대떎. 
				 String newFileName   = filePath + "/" + filename;
				 try
				 {
					 System.out.println(newFileName);
					 multipartFile.transferTo( new File(newFileName));
					 
				 }
				 catch(Exception e)
				 { 
					 e.printStackTrace();
				 } 
			 }
		}
		
		
	}
}
