/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic.wicket;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;
import org.apache.wicket.spring.SpringWebApplicationFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Base configuration of Apache Wicket.
 */
@Configuration
public class WicketConfiguration {

	/**
	 * Prepare the bean with the Wicket servlet.
	 * 
	 * @return The bean with the Wicket servlet.
	 */
	@Bean
	FilterRegistrationBean<WicketFilter> getWicketFilterRegistrationBean() {
		final WicketFilter filter = new WicketFilter();
		final FilterRegistrationBean<WicketFilter> bean = new FilterRegistrationBean<>(filter);
		bean.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
		bean.addUrlPatterns("/*");
		bean.addInitParameter("applicationClassName", WicketApplication.class.getName());
		bean.addInitParameter("applicationFactoryClassName", SpringWebApplicationFactory.class.getName());
		bean.addInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
		return bean;
	}

	/**
	 * Return the Wicket web application bean.
	 * 
	 * @return The bean.
	 */
	@Bean
	WebApplication getWebApplication() {
		return new WicketApplication();
	}
}
