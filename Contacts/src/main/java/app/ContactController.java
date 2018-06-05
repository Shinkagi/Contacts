package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	
    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @Autowired
    ContactRepository repository;
    
    @ModelAttribute("contacts")
    public Iterable<Contact> getContactList(){
    	return repository.findAll();
    }

}