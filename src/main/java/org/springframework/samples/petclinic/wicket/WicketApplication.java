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

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.samples.petclinic.wicket.pages.WelcomePage;

/**
 * Wicket application.
 * 
 * @author stefv
 */
public class WicketApplication extends WebApplication {

	@Override
	protected void init() {
		super.init();

		getCspSettings().blocking().disabled();

		mountPage("/welcome2", WelcomePage.class);
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return null;
	}

	@Override
	public RuntimeConfigurationType getConfigurationType() {
		return RuntimeConfigurationType.DEPLOYMENT;
	}
}
