package com.learn.springbootkubernetes.controlador;

import com.learn.springbootkubernetes.modelo.Usuario;
import com.learn.springbootkubernetes.modelo.UsuarioCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class ControladorCrud {

	@Autowired
    private UsuarioCrud uc;
 
    @RequestMapping(value="", method = RequestMethod.GET)
    public String listaUsuarios(ModelMap mp){
        mp.put("usuarios", uc.findAll());
        return "lista";
    }
 
    @RequestMapping(value="/nuevo", method=RequestMethod.GET)
    public String nuevo(ModelMap mp){
        mp.put("usuario", new Usuario());
        return "nuevo";
    }

    @RequestMapping(value="/crear", method=RequestMethod.POST)
    public String crear(@Valid Usuario usuario,
            BindingResult bindingResult, ModelMap mp){
        if(bindingResult.hasErrors()){
            return "nuevo";
        }else{
            uc.save(usuario);
            mp.put("usuario", usuario);
            return "creado";
        }
    }
 
    @RequestMapping(value="/creado", method = RequestMethod.POST)
    public String creado(@RequestParam("usuario") Usuario usuario){
        return "/creado";
    }
}
