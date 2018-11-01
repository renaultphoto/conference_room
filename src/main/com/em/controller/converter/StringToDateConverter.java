package main.com.em.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Converter<S,T>:
 * S:source
 * T:target
 * Created by Admiral on 2018/1/18.
 */
public class StringToDateConverter implements Converter<String,Date> {
    public Date convert(String source) {
        Date date=null;
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            date=dateFormat.parse(source.trim());
            //return date;
        } catch (ParseException e) {
            try{
                dateFormat=new SimpleDateFormat("HH:mm:ss");
                date=dateFormat.parse(source.trim());
            }catch (ParseException e1){
                e1.printStackTrace();
            }
        }
        return date;
    }

    public String convertTohmsString(Date date) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
         String d =dateFormat.format(date);
        return d;
    }

    public String convertToYMDString(Date date) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String d =dateFormat.format(date);
        return d;
    }
}
