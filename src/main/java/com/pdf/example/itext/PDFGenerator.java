package com.pdf.example.itext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {
	
	private Document document;
	private final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private final Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private final Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    public PDFGenerator() {
		this.document = new Document();
	}
    
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	public void createPDF(String fileName) {
		try {
			PdfWriter.getInstance(this.document, new FileOutputStream(fileName));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void openPDF() {
		try {
			this.document.open();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void closePDF() {
		try {
			this.document.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void addMetaData(HashMap<String,String> metaData) {
		this.document.addTitle(metaData.get("title"));
		this.document.addSubject(metaData.get("subject"));
        this.document.addKeywords(metaData.get("keywords"));
        this.document.addAuthor(metaData.get("author"));
        this.document.addCreator(metaData.get("creator"));
	}
	
	public void addTitlePage(String title, String generatedBy, String description) throws DocumentException {
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		
		preface.add(new Paragraph(title, this.catFont));
		addEmptyLine(preface, 1);
		
		preface.add(new Paragraph("Report generated by: " + generatedBy + ", " + new Date 
		        (), smallBold));
		
		  addEmptyLine(preface, 3);
	      preface.add(new Paragraph(description, smallBold));
	      
	      this.document.add(preface);
	      this.document.newPage();
	}
	
	public void addTOC() throws DocumentException, IOException {
		Paragraph head = new Paragraph("Table of contents");
		Paragraph list = new Paragraph();
		list.setIndentationLeft(15);
		createList(list, 10);
		this.document.add(head);
		this.document.add(list);
		this.document.newPage();
		}
	
	public void addContent(int num) throws DocumentException,IOException {
		Anchor anchor;
		Paragraph p ;
		for(int i = 0; i<num; i++) {
		    anchor = new Anchor("Chapter " + (i+1), catFont);
	        anchor.setName("Chapter"+(i+1));     
	
	        String s = "This contents of chapter " + i + "The ideology of the PLO was formulated in the founding year 1964 in the Palestinian National Covenant.[21] The document is a combative anti-Zionist statement dedicated to the \"restoration of the Palestinian homeland\". It has no reference to religion. In 1968, the Charter was replaced by a comprehensively revised version.[22]\r\n" + 
	        		"\r\n" + 
	        		"Until 1993, the only promoted option was armed struggle. From the signing of the Oslo Accords, negotiation and diplomacy became the only official policy. In April 1996, a large number of articles, which were inconsistent with the Oslo Accords, were wholly or partially nullified.[23]\r\n" + 
	        		"\r\n" + 
	        		"At the core of the PLO's ideology is the belief that Zionists had unjustly expelled the Palestinians from Palestine and established a Jewish state in place under the pretext of having historic and Jewish ties with Palestine. They demanded that Palestinian refugees should be allowed to return to their homes. This is expressed in the National Covenant:\r\n" + 
	        		"\r\n" + 
	        		"Article 2 of the Charter states that ″Palestine, with the boundaries it had during the British mandate, is an indivisible territorial unit″,[22] meaning that there is no place for a Jewish state. This article was adapted in 1996 to meet the Oslo Accords.[23]\r\n" + 
	        		"\r\n" + 
	        		"Article 20 states: ″The Balfour Declaration, the Mandate for Palestine, and everything that has been based upon them, are deemed null and void. Claims of historical or religious ties of Jews with Palestine are incompatible with the facts of history and the true conception of what constitutes statehood. Judaism, being a religion, is not an independent nationality. Nor do Jews constitute a single nation with an identity of its own; they are citizens of the states to which they belong″.[22] This article was nullified in 1996.\r\n" + 
	        		"\r\n" + 
	        		"Article 3 reads: ″The Palestinian Arab people possess the legal right to their homeland and have the right to determine their destiny after achieving the liberation of their country in accordance with their wishes and entirely of their own accord and will″.\r\n" + 
	        		"\r\n" + 
	        		"The PLO has always labelled the Palestinian people as Arabs. This was a natural consequence of the fact that the PLO was an offshoot of the Arab League. It also has a tactical element, as to keep the backing of Arab states. Over the years, the Arab identity remained the stated nature of the Palestinian State.[24] It is a reference to the ″Arab State″ envisioned in the UN Partition Plan.\r\n" + 
	        		"\r\n" + 
	        		"Secularism versus adherence to Islam\r\n" + 
	        		"The PLO and its dominating faction Fatah are often contrasted to more religious orientated factions like Hamas and the Palestinian Islamic Jihad (PIJ). All, however, represent a predominant Muslim population. Practically the whole population of the Territories is Muslim, most of them Sunni. Only some 50,000 (ca 1%) of the 4.6 million Palestinians in the OPT is Palestinian Christian,[25][26] whereas roughly 120,000-130,000 live in Israel[25][26] and the vast majority in the Diaspora (estimated up to one half-million or more.[25][27]\r\n" + 
	        		"\r\n" + 
	        		"The National Charter has no reference to religion. Under President Arafat, the Fatah-dominated Palestinian Authority adopted the 2003 Amended Basic Law, which stipulates Islam as the sole official religion in Palestine and the principles of Islamic sharia as a principal source of legislation.[24] The draft Constitution, which never materialized, contains the same provisions.[28][29] At the time, the PLC did not include a single Hamas member. The draft Constitution was formulated by the ″Constitutional Committee″, appointed with the approval of the PLO.[30][31]";
	        
	        p = new Paragraph();
	        addEmptyLine(p, 3);
	        document.add(p);
	        p = new Paragraph(s);
	        
	        document.add(anchor);
	        document.add(p);
		}
	}

	private void addEmptyLine (Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
	
	private void createList(Paragraph p, int num) {
        List list = new List(true, false, 20);
        Chunk anc;
        for(int i= 0; i < num; i++) {
        	anc = new Chunk("Chapter " + (i+1));
        	anc.setLocalGoto("Chapter" + (i+1));
        	list.add(new ListItem(anc));
        }
        p.add(list);
        
    }

}
