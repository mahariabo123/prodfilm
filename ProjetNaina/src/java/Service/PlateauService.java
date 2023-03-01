/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import HibernateDao.GenericDao;
import entity.*;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import util.Util;

/**
 *
 * @author USER
 */
@Component
public class PlateauService {
    public ArrayList<Plateau> all()throws Exception{
        Plateau ray=new Plateau(null);
        ArrayList<Plateau>list=new ArrayList<>();
        try{
            list=Util.castPlateau(new GenericDao().find(ray));
            
        }catch(Exception e){
            
        }
        return list;
    }
}
