/*
* Copyright 2004 The Apache Software Foundation
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package filters;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public final class ExampleFilter implements Filter {


    private String attribute = null;


    private FilterConfig filterConfig = null;


    public void destroy() {

        this.attribute = null;
        this.filterConfig = null;

    }


    
    
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
	throws IOException, ServletException {

	// Store ourselves as a request attribute (if requested)
	if (attribute != null)
	    request.setAttribute(attribute, this);

	// Time and log the subsequent processing
	long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
	long stopTime = System.currentTimeMillis();
	filterConfig.getServletContext().log
	    (this.toString() + ": " + (stopTime - startTime) +
	     " milliseconds");

    }


    public void init(FilterConfig filterConfig) throws ServletException {

	this.filterConfig = filterConfig;
        this.attribute = filterConfig.getInitParameter("attribute");

    }


    public String toString() {

	if (filterConfig == null)
	    return ("InvokerFilter()");
	StringBuffer sb = new StringBuffer("InvokerFilter(");
	sb.append(filterConfig);
	sb.append(")");
	return (sb.toString());

    }


}

