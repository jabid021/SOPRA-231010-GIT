package demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String demoGet(@RequestParam(required = false) String prenom,@RequestParam(defaultValue = "1")  Integer id,Model model,HttpSession session) 
	{
		System.out.println(id+" - "+prenom);
		System.out.println("On est dans la fonction demoGet()");
		session.setAttribute("demoSession", "ca marche");
		model.addAttribute("exemple",id+" - "+prenom);
		return "/WEB-INF/demoData.jsp";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String demoPost(String prenom,Integer id) 
	{
		System.out.println(id+" - "+prenom);
		System.out.println("On est dans la fonction demoPost()");
		return "/WEB-INF/demoData.jsp";
	}
	
	@RequestMapping("/index")
	public String demo2() 
	{
		System.out.println("On est dans la fonction demo2()");
		return "/index.jsp";
	}
	
}
