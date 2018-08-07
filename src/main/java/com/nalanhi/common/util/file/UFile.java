package com.nalanhi.common.util.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @author       임정채
 * @since        2014.08.20
 * @description  FILE 유틸
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2014.08.20      임정채              최초생성	
 *****************************************************************************************************/
public final class UFile {

	
	/**
	 * 해당 디렉토리의 모든 파일 목록을 가져온다.
	 * <br><br>
	 * 
	 * @param resourcePath 디렉토리
	 * @param extension    확장자
	 * @return             파일 목록
	 ********************************************************************************************/
	public static List<File> getFileList(File resourcePath, String extension) {
		
		List<File> result       = new ArrayList<File>();
		File[]     filesAndDirs = resourcePath.listFiles();
		List<File> filesDirs    = Arrays.asList(filesAndDirs);
		
		for (File file : filesDirs) {
			
			if( null == extension ){
				result.add(file); 
			}
			else{
				if( -1 != file.getName().indexOf(extension)){
					result.add(file); 
				}
			}
			
			if (!file.isFile()) {
				List<File> deeperList = getFileList(file, extension);
				result.addAll(deeperList);
			}
		}
		
		return result;
	}

	/**
	 * 확장자 정보를 반환한다.
	 * <br><br>
	 * 
	 * @param fileName 파일명
	 * @return         확장자
	 ********************************************************************************************/
	public static String getFileExtenstion(String fileName){
		
		return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
	}
	
	/**
	 * 파일을 삭제한다.
	 * <br><br>
	 * 
	 * @param  filePath 파일 경로
	 * @return          파일을 정상적으로 삭제 했다면 true 오류가 발생했다면 false
	 ********************************************************************************************/
	public static boolean deleteFile(String filePath){

		File originalFile = new File(filePath);
		
		// 원본 파일이 존재 한다면 삭제
		if( true == originalFile.exists() ) {
			return originalFile.delete();
		}
		
		return false;
	}
}
