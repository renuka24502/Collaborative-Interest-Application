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

package listeners;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public final class ContextListener
    implements ServletContextAttributeListener, ServletContextListener {


    
   
    private ServletContext context = null;


    public void attributeAdded(ServletContextAttributeEvent event) {

	log("attributeAdded('" + event.getName() + "', '" +
	    event.getValue() + "')");

    }


   
    public void attributeRemoved(ServletContextAttributeEvent event) {

	log("attributeRemoved('" + event.getName() + "', '" +
	    event.getValue() + "')");

    }


    public void attributeReplaced(ServletContextAttributeEvent event) {

	log("attributeReplaced('" + event.getName() + "', '" +
	    event.getValue() + "')");

    }


    public void contextDestroyed(ServletContextEvent event) {

	log("contextDestroyed()");
	this.context = null;

    }


   
    public void contextInitialized(ServletContextEvent event) {

	this.context = event.getServletContext();
	log("contextInitialized()");

    }


    private void log(String message) {

	if (context != null)
	    context.log("ContextListener: " + message);
	else
	    System.out.println("ContextListener: " + message);

    }


    
    private void log(String message, Throwable throwable) {

	if (context != null)
	    context.log("ContextListener: " + message, throwable);
	else {
	    System.out.println("ContextListener: " + message);
	    throwable.printStackTrace(System.out);
	}

    }


}
