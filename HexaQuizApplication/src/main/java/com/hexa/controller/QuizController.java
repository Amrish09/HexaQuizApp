package com.hexa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hexa.dao.HDAO;

import com.hexa.dao.NotFoundException;
import com.hexa.entity.QuizQuestion;
import com.hexa.entity.UserHistory;
import com.hexa.service.QSerImpl;
import com.hexa.entity.UserTable;
@Controller
public class QuizController {
	
	Logger logger = LoggerFactory.getLogger("empapp");
	
	@Autowired
	QSerImpl ser;
	
	@Autowired
	HDAO dao;
	
	
	/*@RequestMapping("/mainpage")
	public String displaMain() {
		logger.debug("Displaying the First page");
		return "ExamType";
	}*/
	
	
	@RequestMapping("/quizquestions")
	public String viewAllQuestions(@RequestParam("examid") Integer examId,Model model,HttpServletRequest req) {
		HttpSession sess = req.getSession();
		
		//For reference
		Set<QuizQuestion> set =  ser.generateQues(examId);
		List<QuizQuestion> lst = new ArrayList<>(set);
		
		sess.setAttribute("ulist", lst);
		sess.setAttribute("currid", 0);
		sess.setAttribute("ansmap", new HashMap<>());
		sess.setAttribute("examid", examId);
		model.addAttribute("ques",lst.get(0));
		/*prepareEmployee(examId,pgNo,"viewAllQuestions?",lst,model);*/
		return "QuesView";
	}
	
	@RequestMapping("/viewquiz")
	public String ViewQuizQuestions(HttpServletRequest req,Model model, @RequestParam("qid") Integer qid, @RequestParam(value="qans", required=false) String answer) {
		HttpSession sess = req.getSession();	
		Map<Integer,String> amap =(Map<Integer, String>) sess.getAttribute("ansmap");
		amap.put(qid, answer);
		
		int cidx =  (int) sess.getAttribute("currid");
		List<QuizQuestion> queslst = (List<QuizQuestion>) sess.getAttribute("ulist");
		
		if(req.getParameter("btn").equals("next")) {
			cidx = cidx +1;
		} else if(req.getParameter("btn").equals("prev")) {
			cidx = cidx -1;
		} else if(req.getParameter("btn").equals("finish")) {
			int score = ser.evaluate(amap, (int)sess.getAttribute("examid"),(UserTable)sess.getAttribute("user") );
			model.addAttribute("score", score);
			return "QuizScore";
		}
		sess.setAttribute("currid", cidx);
		model.addAttribute("ques", queslst.get(cidx));
		
		
		
		
		return "QuesView";
		
	}
	
	@RequestMapping("/login")
	public String getLogin() {
		return "LoginView";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession sess=req.getSession(false);
		sess.invalidate();
		return "LoginView";
	}
	
	@RequestMapping(value="/checkLogin",  method=RequestMethod.POST)
	public String  checkLogin(HttpServletRequest req,Model model,@RequestParam("username") String uname,
			@RequestParam("upassword") String upass) throws NotFoundException {
		
		UserTable user=dao.getLogin(uname,upass);
		if(user != null) {
			HttpSession sess=req.getSession();
			sess.setAttribute("user", user);
		}
		
				
		
		return "ExamType";
		
		
	}
	
	@RequestMapping(value="/quizhistory")
	public String quizhistory(HttpServletRequest req,Model model) {
		HttpSession sess= req.getSession();
		UserTable user = (UserTable)sess.getAttribute("user");
		List<UserHistory> hlst = dao.viewHistory(user.getUserId());
		model.addAttribute("history",hlst);
		logger.debug(hlst.toString());
		return "QuizHistory";
	}
	
	
	
	@ExceptionHandler(NotFoundException.class)
	public ModelAndView handleRequest(NotFoundException ix) {
		return new ModelAndView("MyErr","err",ix.getMessage());
	}	

	
	

}
