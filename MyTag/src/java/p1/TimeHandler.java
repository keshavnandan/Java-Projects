package p1;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author training
 */
public class TimeHandler extends TagSupport{
    JspWriter jw = null;
    String color = null;
    public TimeHandler(){
        color = "Blue";
    }
    public void setColor(String c){
        color = c;
    }
    public String getColor(){
        return color;
    }
    @Override
    public int doStartTag(){
        Date d = new Date();
        try{
            jw = pageContext.getOut();
            jw.println("<font color = "+getColor()+">"+d+"</font>");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return SKIP_PAGE;
    }
            
}
