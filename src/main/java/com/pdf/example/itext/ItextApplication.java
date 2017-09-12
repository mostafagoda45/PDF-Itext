package com.pdf.example.itext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import ch.qos.logback.core.util.FileUtil;

@SpringBootApplication
public class ItextApplication {

	   private static String FILE = "hello.pdf";
	    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	public static void main(String[] args) throws IOException, DocumentException {
		
		SpringApplication.run(ItextApplication.class, args);

//		try {
//		PDFGenerator pdf = new PDFGenerator();
//		pdf.createPDF("test.pdf");
//		pdf.openPDF();
//		pdf.addTOC();
//		pdf.addContent(10);
//		pdf.closePDF();
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
		

		
//		CreatePdf("test2.pdf","test.pdf");
		
		
	}
	
    private static void createTable(Section subCatPart) throws BadElementException {
        PdfPTable table = new PdfPTable(3);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);
        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 2"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 3"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell("1.0");
        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");

        subCatPart.add(table);
    }
//    public static void CreatePdf(String OUTPUTFILE, String INPUTFILE) throws IOException, DocumentException
//    {
//    	Document doc = new Document();
//    	PdfCopy writer = new PdfCopy(doc,new FileOutputStream(OUTPUTFILE));
//    	doc.open();
//    	PdfReader reader = new PdfReader(INPUTFILE);
//    	int n = reader.getNumberOfPages();
//    	System.out.println("No. of Pages :" +n);
//    	for (int i = 1; i <= n; i++) {
//    	        if (i == 1) {            
//    	               // removed code for clarity
//    	               PdfImportedPage page = writer.getImportedPage(reader, i);
//
//    	               writer.addPage(page);
//    	            }
//    	}
//    	doc.close();
//    }
 
}
