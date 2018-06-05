package app;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
    @Autowired
    ContactRepository repository;
	
    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @GetMapping("/ajouter")
    public String ajouter(Model model) {
    	model.addAttribute(new Contact("",""));
        return "form";
    }
    
    @PostMapping("/save")
    public String add(@Valid Contact contact) {
    	repository.save(contact);
    	return "redirect:/contacts";
    }

    @GetMapping("/modifier/{id}")
    public String modifier(@PathVariable("id") Long id, Model model) {
    	Contact contact = repository.findById(id);
    	model.addAttribute("contact", contact);
        return "form";
    }
    
    @GetMapping("/supprimer/{id}")
    public String supprimer(@PathVariable("id") Long id) {
    	repository.delete(id);
        return "redirect:/contacts";
    }
    
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    
    @ModelAttribute("contacts")
    public Iterable<Contact> getContactList(){
    	return repository.findAll();
    }

}