//package com.vectoritcgroup.rastreo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.vectoritcgroup.rastreo.model.Objeto;
//import com.vectoritcgroup.rastreo.service.ObjetoService;
//
//
//@Controller
//public class ObjetoController {
//	
//	@Autowired
//    private ObjetoService objetoService;
//    
//    @RequestMapping("/objetos")
//    public String listaObjetos(Model model){
//    	List<Objeto> objetos = objetoService.listAll();
//        model.addAttribute("objetos", objetos);
//        return "objetos/list";
//    }
//    
//    @RequestMapping("/objetosByName")
//    public String objetosByName(@ModelAttribute("listForm") Objeto objeto, Model model){
//    	List<Objeto> objetos = objetoService.getByNombre(objeto.getNombre());
//        model.addAttribute("objetos", objetos);
//        return "objetos/list";
//    }
//    
//    @RequestMapping("/objeto/show/{id}")
//    public String getObjeto(@PathVariable String id, Model model){
//    	Objeto objeto = objetoService.getById(Long.valueOf(id));
//        model.addAttribute("objeto", objeto);        
//        return "objetos/show";
//    }
//
//    @RequestMapping("objeto/edit/{id}")
//    public String edit(@PathVariable String id, Model model){
//    	Objeto objeto = objetoService.getById(Long.valueOf(id));
//        model.addAttribute("objeto", objeto);
//        return "objetos/form";
//    }
//
//    @RequestMapping("/objeto/new")
//    public String add(Model model){
//    	Objeto objeto = new Objeto();
//        model.addAttribute("objetoForm", objeto);
//       return "objetos/form";
//    }
//    
//    @RequestMapping(value = "/objeto", method = RequestMethod.POST)
//    public String saveOrUpdate(@ModelAttribute("objetoForm") Objeto objeto){
//	    Objeto newObjeto = objetoService.saveObjeto(objeto);
//        return "redirect:/objeto/show/" + newObjeto.getIdObjeto();
//    }
//
//    @RequestMapping("/objeto/delete/{id}")
//    public String delete(@PathVariable String id){
//        objetoService.deleteObjetoById(Long.valueOf(id));
//        return "redirect:/objetos/lista";
//    }
//	
//    
//}
