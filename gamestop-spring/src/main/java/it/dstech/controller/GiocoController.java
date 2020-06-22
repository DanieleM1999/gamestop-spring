package it.dstech.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.dstech.model.Gioco;
import it.dstech.service.GiocoService;

@Controller
public class GiocoController {

    @Autowired
    private GiocoService giocoService;

    @RequestMapping("/")
    public ModelAndView home() {
        List<Gioco> listGiochi = giocoService.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listGiochi", listGiochi);
        return mav;
    }

    @RequestMapping("/new")
    public String newGiocoForm(Map<String, Object> model) {
        Gioco gioco = new Gioco();
        model.put("gioco", gioco);
        return "new_gioco";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveGioco(@ModelAttribute("gioco") Gioco gioco) {
        giocoService.save(gioco);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editGiocoForm(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("edit_gioco");
        Gioco gioco = giocoService.get(id);
        mav.addObject("Gioco", gioco);

        return mav;
    }

    @RequestMapping("/delete")
    public String deleteGiocoForm(@RequestParam Long id) {
        giocoService.delete(id);
        return "redirect:/";
    }
}