package controller.MemberController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDto;
import singleton.singleton;

@WebServlet("/addmem")
public class AddMem extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = req.getParameter("mem_id");		
		String mem_pw = req.getParameter("mem_pw");		
		String mem_name = req.getParameter("mem_name");		
		int mem_cell = Integer.parseInt(req.getParameter("mem_cell")); 
		String mem_birth = req.getParameter("mem_birth"); 
		int mem_addr1 = Integer.parseInt(req.getParameter("mem_addr1"));
		String mem_addr2 = req.getParameter("mem_addr2");
		String mem_addr3 = req.getParameter("addr3");
		
		System.out.println(mem_id + " " + mem_pw + " " + mem_name + " " + mem_cell + " " + mem_birth + " " + 
							mem_addr1 + " " + mem_addr2 + " " + mem_addr3);
		
		singleton s = singleton.getInstance();
						
		MemberDto dto = new MemberDto(mem_id, mem_pw, mem_name, mem_cell, mem_birth, mem_addr1,
				mem_addr2, mem_addr3, 3);
		
		req.setAttribute("dto", dto);
		
		/* requestDispatcher dispatcher = req.getRequestDispatcher(path); */
		boolean isS = s.ms.addMember(dto);
		//TODO instance, sendRedirect
		resp.sendRedirect("login.jsp");
		
	}

}
