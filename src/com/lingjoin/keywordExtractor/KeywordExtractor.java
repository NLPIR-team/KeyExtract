package com.lingjoin.keywordExtractor;

public class KeywordExtractor {

	public static boolean state=false;

	public static boolean init(String arg){
		state=CKeywordExtractorLibrary.Instance.KeyExtract_Init(arg, 1, "");
		if(state){
			return true;
		}else{
			System.out.println("初始化失败："+CKeywordExtractorLibrary.Instance.KeyExtract_GetLastErrorMsg());
			return false;
		}
	}

	public static String getKeyWords(String sLine,int nMaxKeyLimit,boolean bWeightOut){
		if(state){
			return CKeywordExtractorLibrary.Instance.KeyExtract_GetKeyWords(sLine, nMaxKeyLimit, bWeightOut);
		}else
			return null;
	}

	public static String getFileKeywords(String sFilename,int nMaxKeyLimit,boolean bWeightOut){
		if(state){
			return CKeywordExtractorLibrary.Instance.KeyExtract_GetFileKeyWords(sFilename, nMaxKeyLimit, bWeightOut);
		}else
			return null;
	}
	
	public static boolean importUserDict(String sFilename,boolean bOverwrite){
		if(state)
		    return CKeywordExtractorLibrary.Instance.KeyExtract_ImportUserDict(sFilename, bOverwrite);
		else
			return false;
	}
	
	public static boolean importKeyBlackList(String sFilename){
		if(state)
			return CKeywordExtractorLibrary.Instance.KeyExtract_ImportKeyBlackList(sFilename);
		else
			return false;
	}
	
	public static boolean exit(){
		return CKeywordExtractorLibrary.Instance.KeyExtract_Exit();
	}
	
	public static String getLastErrorMsg(){
		return CKeywordExtractorLibrary.Instance.KeyExtract_GetLastErrorMsg();
	}
}
