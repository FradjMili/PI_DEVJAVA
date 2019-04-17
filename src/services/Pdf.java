/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.ResultSetMetaData;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tools.MyConnection;

/**
 *
 * @author USER
 */
public class Pdf {
   Connection connection=null;  
    
    public Pdf() throws SQLException, FileNotFoundException, DocumentException {
        connection=MyConnection.getInstance().getCnx();
        
        
       Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs=st.executeQuery("select * from experiences");
        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        int col=rsmd.getColumnCount();
       rs.first();
       
        Document d = new Document();
        PdfWriter.getInstance(d,new FileOutputStream("ichrakkkkPDF.pdf"));
        PdfPTable pt = new PdfPTable(col);
        d.open();
        
        d.add( new Paragraph("bonjour ferfer"));
        pt.addCell(""+rs.getString(1));
        // pt.addCell(""+rs.getString());
        d.add(pt);
        d.close();
    } 
}
