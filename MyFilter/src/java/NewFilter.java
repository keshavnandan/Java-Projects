/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author training
 */
@WebFilter(filterName = "NewFilter", servletNames = {"NewServlet"}, dispatcherTypes = {DispatcherType.REQUEST})
public class NewFilter implements Filter {
    
    private static final boolean debug = true;
    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void init(FilterConfig fg){
        
    }
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {        

        
        Throwable problem = null;
        try {
            int num = Integer.parseInt(request.getParameter("in"));
            if(num < 1000 && num > 0){
                request.setAttribute("val", num);
                chain.doFilter(request, response);
            }
            else{
                PrintWriter pw = response.getWriter();
                pw.write("<h2><font color=\"red\">Error: Number out of range</font></h2>");
                System.err.println("Number out of range");
            }
            num += 10;
            System.out.println("number = "+num);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }
    }

    @Override
    public void destroy(){
        
    }    
}