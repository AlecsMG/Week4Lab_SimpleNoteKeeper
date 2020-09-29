/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 831690
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/NoteServlet"})
public class NoteServlet extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    String edit = request.getParameter("edit");

    String path = getServletContext().getRealPath("/WEB-INF/note.txt");
    BufferedReader br = new BufferedReader(new FileReader(new File(path)));
    
    String title = br.readLine();
    String contents = br.readLine();
    
    
    Note note = new Note(title, contents);
    
    br.close();
    
    if (edit != null) {
        
        String editTitle = note.getTitle();
        String editContents = note.getContents();
        
        request.setAttribute("editTitle", editTitle);
        request.setAttribute("editContents", editContents);
        
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").
                forward(request, response);
        
        
    }
    
    request.setAttribute("note", note);
    
    getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").
                forward(request, response);
    
    

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");    
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        
        String title = request.getParameter("editTitle");
        String contents = request.getParameter("editContents");
        
        pw.println(title);
        pw.print(contents);

        pw.close();
        
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
     
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").
                forward(request, response);
        
    }
}
