/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import HibernateDao.GenericDao;
import entity.*;
import util.*;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
/**
 *
 * @author USER
 */
@Component
public class SceneService {
    public ArrayList<Scene> all(Scene ray)throws Exception{
        ArrayList<Scene>list=new ArrayList<>();
        try{
            list=Util.castScene(new GenericDao().find(ray)); 
        }catch(Exception e){
            
        }
        return list;
    }
    public ArrayList<ArrayList<Scene>> planning(Scene ray)throws Exception{
        ArrayList<ArrayList<Scene>>fin=new ArrayList<ArrayList<Scene>>();
        ArrayList<Scene>list=new ArrayList<>();
        try{
            list=Util.castScene(new GenericDao().find(ray)); 
        }catch(Exception e){
            
        }
        Horaire h=(Horaire)(new GenericDao().find(new Horaire(-1)).get(0));
        if(list.size()>0){
            long heure=(long)(h.getHeure()*3600*1000);
            long copy=(long)(h.getHeure()*3600*1000);
            System.out.println("heure "+heure);
            ArrayList<Scene>vao=new ArrayList<>();
            int i=0;
            while(i<list.size()){
                //System.out.println("i "+i);
                //System.out.println("heurescene "+Util.strToMillis(list.get(i).getDure()));
                heure=heure-Util.strToMillis(list.get(i).getDure());
                //System.out.println("heureVao2 "+heure);
                if(heure<0){
                    int j=i;
                    //System.out.println("j "+j);
                    //System.out.println("tay negatif");
                    heure=copy;
                    //System.out.println("copy "+heure);
                    i=j;
                    //System.out.println("ivao "+i);
                    fin.add(vao);
                    vao=new ArrayList<>();
                    continue;
                }else{
                    if(i==list.size()-1){
                        vao.add(list.get(i));
                        fin.add(vao);
                        vao=new ArrayList<>();
                    }else{
                        vao.add(list.get(i));
                    }
                    
                }
                i++;
            }
            
        }
        return fin;
    }
    
    public ArrayList<Scene> pagination(Scene ra,int page,int nbPage)throws Exception{
       System.out.println("hakaida ");
       
        String str="";
       
           str="select * from Scene WHERE idwatch="+Integer.toString(ra.getIdwatch());
       
           if(ra.getIntitule()!=null){
                  str="select * from Scene WHERE  LOWER(intitule) like '%"+ra.getIntitule().toLowerCase()+"%' and idwatch="+Integer.toString(ra.getIdwatch());
           }
        
           
       
        ArrayList<Object>list=new GenericDao().pagination2(ra,str,page,nbPage);   
        System.out.println("taygod "+list.size());
        ArrayList<Scene>liste=new ArrayList<Scene>();
        for (int i = 0; i <list.size(); i++) {
            liste.add((Scene)list.get(i));
        }
        return liste;
    }
    public int nombreDePage(ArrayList<Scene>ray,int nbPage)throws Exception{
        int mod=(ray.size()%nbPage);
        int valiny=(int)(ray.size()/nbPage);
        if(mod==0){
            return valiny;
        }
        return valiny+1;
           
    }
}
