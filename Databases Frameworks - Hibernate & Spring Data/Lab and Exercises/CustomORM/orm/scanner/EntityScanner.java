package orm.scanner;

import annotations.Entity;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

public class EntityScanner {
    public static List<Class> getAllEntities(String startPath) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Class> result = new ArrayList<>();
        File dir = new File(startPath);
        File[] files = dir.listFiles();

        for(File file : files){
            if(file.isFile()){
                String fileName = file.getName();
                if(!fileName.endsWith(".class")){
                    continue;
                }

                try {
                    Class myClass = Class.forName(fileName.substring(0, fileName.length() - 6));
                    myClass.newInstance();

                    if(!myClass.isAnnotationPresent(Entity.class)){
                        continue;
                    }

                    result.add(myClass.getClass());

                }catch (ClassNotFoundException e ){
             //       System.out.println("Excenption for " + fileName);
                }



            }else{
               result.addAll(getAllEntities(startPath + File.separator +  file.getName()));
            }
        }
        return result;
    }
}
