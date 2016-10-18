package com.lingjoin.keywordExtractor;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CKeywordExtractorLibrary extends Library{

	CKeywordExtractorLibrary Instance=(CKeywordExtractorLibrary) Native.loadLibrary("KeyExtract", CKeywordExtractorLibrary.class);
	
	public boolean KeyExtract_Init(String sDataPath,int encode,String sLicenceCode);
	
	public String KeyExtract_GetKeyWords(String sLine,int nMaxKeyLimit,boolean bWeightOut);
	
	public String KeyExtract_GetFileKeyWords(String sFilename,int nMaxKeyLimit,boolean bWeightOut);
	
	public boolean KeyExtract_ImportUserDict(String sFilename,boolean bOverwrite);
	
	public boolean KeyExtract_ImportKeyBlackList(String sFilename);
	
	public String KeyExtract_GetLastErrorMsg();
	
	public boolean KeyExtract_Exit();
}
