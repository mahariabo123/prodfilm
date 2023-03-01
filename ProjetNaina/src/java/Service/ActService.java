/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import HibernateDao.GenericDao;
import entity.Act;
import entity.Scene;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import util.Util;

/**
 *
 * @author USER
 */
@Component
public class ActService {
    public ArrayList<Act> all(Act ray)throws Exception{
        ArrayList<Act>list=new ArrayList<>();
        try{
            list=Util.castAct(new GenericDao().find(ray)); 
        }catch(Exception e){
            
        }
        return list;
    }
    public ArrayList<Act> pagination(Act ra,int page,int nbPage)throws Exception{
       System.out.println("hakaida ");
       
        String str="";
       
           str="select * from Act WHERE idscene="+Integer.toString(ra.getIdscene());
       
           if(ra.getIntitule()!=null){
                  str="select * from Act WHERE  LOWER(intitule) like '%"+ra.getIntitule().toLowerCase()+"%' and idscene="+Integer.toString(ra.getIdscene());
           }
        
           
       
        ArrayList<Object>list=new GenericDao().pagination2(ra,str,page,nbPage);   
        System.out.println("taygod "+list.size());
        ArrayList<Act>liste=new ArrayList<Act>();
        for (int i = 0; i <list.size(); i++) {
            liste.add((Act)list.get(i));
        }
        return liste;
    }
    public int nombreDePage(ArrayList<Act>ray,int nbPage)throws Exception{
        int mod=(ray.size()%nbPage);
        int valiny=(int)(ray.size()/nbPage);
        if(mod==0){
            return valiny;
        }
        return valiny+1;
           
    }
}
