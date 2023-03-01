/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import HibernateDao.GenericDao;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
/**
 *
 * @author USER
 */
@Component
public class GeneraliseService {
    public void save(Object obj)throws Exception{
        new GenericDao().save(obj);
    }
    public void update(Object obj)throws Exception{
         new GenericDao().update(obj);
    }
    public void delete(Object obj)throws Exception{
        new GenericDao().delete(obj);
    }
    public ArrayList<Object> find(Object obj)throws Exception{
        ArrayList<Object>list=new GenericDao().find(obj);
        ArrayList<Object>liste=new ArrayList<Object>();
        for (int i = 0; i <list.size(); i++) {
            liste.add((Object)list.get(i));
        }
        return liste;
    }
}
