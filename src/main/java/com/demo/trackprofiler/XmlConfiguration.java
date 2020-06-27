package com.demo.trackprofiler;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Bean configuration for application
 */
@Configuration
@ImportResource({"classpath*:beans.xml"})
public class XmlConfiguration {
}
