package cn.how2j.grid;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import cn.how2j.grid.util.LogPrintStream;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NetUtil; 



@SpringBootApplication
@ServletComponentScan("cn.how2j.mybaby.filter")
public class Application extends SpringBootServletInitializer{
    public static void main(String[] args) throws IOException, URISyntaxException {
    	String url = "http://127.0.0.1:9981/grid1/admin_grid_list";
    	if(NetUtil.isUsableLocalPort(9981)) {
//        	FileUtil.mkdir("grid/sqlitedbfile");
        	LogPrintStream.init();
        	System. setProperty("java.awt.headless", "false");
        	SpringApplication.run(Application.class, args);
    		System.out.println(url);
    	}
		Desktop.getDesktop().browse(new URI(url));
    }
}
