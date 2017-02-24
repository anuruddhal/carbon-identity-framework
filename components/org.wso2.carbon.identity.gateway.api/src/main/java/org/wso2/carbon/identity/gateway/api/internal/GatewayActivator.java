/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.gateway.api.internal;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.identity.gateway.api.request.GatewayRequestBuilderFactory;
import org.wso2.carbon.identity.gateway.api.response.GatewayResponseBuilderFactory;


@Component(
        name = "org.wso2.carbon.identity.gateway.api.internal.GatewayActivator",
        immediate = true
)
public class GatewayActivator {

    private Logger log = LoggerFactory.getLogger(GatewayActivator.class);

    @Activate
    protected void start(BundleContext bundleContext) throws Exception {
        try {
            bundleContext.registerService(GatewayRequestBuilderFactory.class, new GatewayRequestBuilderFactory(), null);
            bundleContext.registerService(GatewayResponseBuilderFactory.class, new GatewayResponseBuilderFactory(), null);
            if (log.isDebugEnabled()) {
                log.debug("org.wso2.carbon.identity.gateway.api bundle is activated");
            }
        } catch (Throwable e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Deactivate
    protected void stop() throws Exception {

    }
}
