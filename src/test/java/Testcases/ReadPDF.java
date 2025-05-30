package Testcases;

import Utilities.PdfUtils;

public class ReadPDF {

	public static void main(String[] args) {
		
		System.out.println(PdfUtils.getPDFText("TestFile.pdf").contains("Azure DevOps"));
		
	}

}
