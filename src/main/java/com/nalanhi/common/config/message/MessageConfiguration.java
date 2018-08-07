package com.nalanhi.common.config.message;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.google.common.base.Charsets;
 

/**
 * @author       임정채
 * @since        2017.01.11
 * @description  MESSAGE CONFIG
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
@Configuration
public class MessageConfiguration {

	/**
	 * MESSAGE SOURCE ACCESSOR
	 * <br><br>
	 * 
	 * @return MESSAGE SOURCE ACCESSOR INSTANCE
	 ********************************************************************************************/
    @Bean
    public MessageSourceAccessor messageSourceAccessor(){
    	
    	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/config/message/messages");
		messageSource.setDefaultEncoding(Charsets.UTF_8.name());
		
    	return new MessageSourceAccessor(messageSource); 
    }
    
    @Bean
    public LocaleResolver localeResolver() {
        
    	SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.KOREA);
        
        return sessionLocaleResolver;
    }
}