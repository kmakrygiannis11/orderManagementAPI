package com.order.management.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component("configuration")
@ManagedResource(objectName = "com.order.management.util:name=Configuration", description = "API Configuration variables")
public class Configuration {

	InetAddress IPaddress;

	@Value("${server.port}")
	String port = "8080";

	@Value("${spring.datasource.url}")
	String datasource;

	@Value("${spring.datasource.username}")
	String DBUserName;

	@Value("${spring.datasource.password}")
	String DBPassword;

	@ManagedAttribute(description = "Get service ip address")
	public String getIpAddress() {
		return IPaddress.getHostAddress();
	}

	@ManagedAttribute(description = "Get service port address")
	public String getPort() {
		return port;
	}

	@ManagedAttribute(description = "Set service port address")
	public void setPort(String port) {
		this.port = port;
	}

	@ManagedAttribute(description = "Get service datasource address")
	public String getDatasource() {
		return datasource;
	}

	@ManagedAttribute(description = "Set service datasource address")
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	@ManagedAttribute(description = "Get datasource username")
	public String getDbUserName() {
		return DBUserName;
	}

	@ManagedAttribute(description = "Set datasource username")
	public void setDbUserName(String dbUserName) {
		this.DBUserName = dbUserName;
	}

	@ManagedAttribute(description = "Get datasource password")
	public String getDbPassword() {
		return DBPassword;
	}

	@ManagedAttribute(description = "Set datasource password")
	public void setDbPassword(String dbPassword) {
		this.DBPassword = dbPassword;
	}

	@PostConstruct
	private void init() {
		try {
			IPaddress = InetAddress.getLocalHost();
			System.out.println("API current IP address : " + IPaddress.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}