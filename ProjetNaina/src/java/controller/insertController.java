/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Service.*;
import util.*;
import java.util.Map;
import HibernateDao.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
/**
 *
 * @author USER
 */
@Controller
public class insertController {
    @Autowired
    GeneraliseService gs;
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String inserer(Model mod,@RequestParam Map<String,String> allParams){
        try{

            Object ry=Util.traductionParameterDynamique(allParams);
            //mod.put("message", "tay");
            //Mitoto r=(Mitoto)ry;
            gs.save(ry);
        mod.addAttribute("message", "success");
        }catch(Exception e){

            mod.addAttribute("message",e.getMessage());
        }
        return allParams.get("redirect");
        
    }
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(Model mod,@RequestParam Map<String,String> allParams){
        try{

            Object ry=Util.traductionParameterDynamique(allParams);
            //mod.put("message", "tay");
            //Mitoto r=(Mitoto)ry;
            gs.update(ry);
        mod.addAttribute("message", "success");
        }catch(Exception e){

            mod.addAttribute("message",e.getMessage());
        }
        return allParams.get("redirect");
        
    }
}
