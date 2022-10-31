package com.supermarket.utilities;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.supermarket.constants.Constants;

public class PdfReader {

	public HashMap<String, String> Pdf_ReadData(String fileName) {
		String pdfData = "";
		String key = "";
		String value = "";
		HashMap<String, String> data = new HashMap<String, String>();

		String path = Constants.PDF_FILE_PATH + "\\" + fileName + ".pdf";

		try {
			URL url = new URL(path);
			InputStream is = url.openStream();
			BufferedInputStream file_input = new BufferedInputStream(is);
			PDDocument document = null;
			document = PDDocument.load(file_input);
			pdfData = new PDFTextStripper().getText(document);
			// System.out.println(pdfData);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String array[] = pdfData.split("\n");
		System.out.println(array.length);
		for (int i = 0; i < array.length; i++) {
			String arr[] = array[i].split(":");
			key = arr[0];
			value = arr[1];
			data.put(key, value);
		}
		return data;
	}
}
