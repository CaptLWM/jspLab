package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

public class ControllerUsingURI extends HttpServlet {

    // <커맨드, 핸들러인스턴스> 매핑 정보 저장
    private Map<String, CommandHandler> commandHandlerMap = 
    		new HashMap<>();
    //{"/hello.do":HelloHandler 객체}
    //{"/simple.do":HelloHandler 객체}
    public void init() throws ServletException {
        String configFile = getInitParameter("configFile");
        //"/WEB-INF/commandHandlerURI.properties"
        Properties prop = new Properties(); // list, set, map: {String key: String value}
        String configFilePath = getServletContext().getRealPath(configFile);
        // D:\dev\workspace\git\jsp\chap18\WebContent\WEB-INF\commandHandler
        try (FileReader fis = new FileReader(configFilePath)) {
            prop.load(fis);
            //{"/hello.do":"mvc.hello.HelloHandler"}
        } catch (IOException e) {
            throw new ServletException(e);
        }
        Iterator keyIter = prop.keySet().iterator();//map을 셋으로
        while (keyIter.hasNext()) {
            String command = (String) keyIter.next();
            //"/hello.do"
            String handlerClassName = prop.getProperty(command);
            //"mvc.hello.HelloHandler
            try {
                Class<?> handlerClass = Class.forName(handlerClassName);
                //HelloHandler 객체를 생성한다.
                CommandHandler handlerInstance = 
                        (CommandHandler) handlerClass.newInstance();
                commandHandlerMap.put(command, handlerInstance);
            } catch (ClassNotFoundException | InstantiationException 
            		| IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI();
		// "/chap18/hello.do"
		if (command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
			// "/hello.do
		}
        CommandHandler handler = commandHandlerMap.get(command);
        // HelloHandler 객체
        if (handler == null) {
            handler = new NullHandler();
        }
        String viewPage = null;
        try {
        	// "/hello.do" => HelloHandler.process() 실행한다.
            viewPage = handler.process(request, response);
            // "/WEB-INF/view/hello.jsp"
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        if (viewPage != null) {
        	// viewPage로 forwarding 한다
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        dispatcher.forward(request, response);
        }
    }
}
