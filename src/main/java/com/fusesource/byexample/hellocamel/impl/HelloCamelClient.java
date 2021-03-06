/*
 * Copyright 2011 FuseSource
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.fusesource.byexample.hellocamel.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class HelloCamelClient {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();

        ProducerTemplate template = context.createProducerTemplate();

        context.start();

        String response = template.requestBody("jetty:http://localhost:8888/hellocamel", "Scott", String.class);

        System.out.println(response);

        context.stop();
    }
}
