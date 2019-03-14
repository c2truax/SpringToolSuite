package org.christruax.displaydate;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class DateTimeController {
	public static void main(String[] args) {
		SpringApplication.run(DisplaydateApplication.class, args);
	}
	@RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
	@RequestMapping("/date")
    public String date(Model model) {
		Date date = new java.util.Date();
		String strDateFormat = "EEEEE, 'the' dd 'of' MMMMM, yyyy";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(date);
		model.addAttribute("dateVar", formattedDate);
        return "date.jsp";
    }
	@RequestMapping("/time")
    public String time(Model model) {
		Date date = new java.util.Date();
		String strDateFormat = "hh:mm a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedTime= dateFormat.format(date);
		model.addAttribute("timeVar", formattedTime);
        return "time.jsp";
    }
}
