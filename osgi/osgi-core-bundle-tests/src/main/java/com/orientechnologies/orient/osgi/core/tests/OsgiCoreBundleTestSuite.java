/*
 *
 *  *  Copyright 2016 OrientDB LTD (info(at)orientdb.com)
 *  *
 *  *  Licensed under the Apache License, Version 2.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtain a copy of the License at
 *  *
 *  *       http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *  Unless required by applicable law or agreed to in writing, software
 *  *  distributed under the License is distributed on an "AS IS" BASIS,
 *  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  See the License for the specific language governing permissions and
 *  *  limitations under the License.
 *  *
 *  * For more information: http://www.orientdb.com
 */

package com.orientechnologies.orient.osgi.core.tests;

import junit.framework.Test;
import org.apache.felix.ipojo.junit4osgi.OSGiTestSuite;
import org.osgi.framework.BundleContext;

/**
 * @author Sergey Sitnikov
 */
public class OsgiCoreBundleTestSuite {

  public static Test suite(BundleContext context) {
    OSGiTestSuite suite = new OSGiTestSuite("OrientDB OSGi Core Bundle Test Suite", context);
    suite.addTestSuite(DiscoverabilityTest.class);
    suite.addTestSuite(GraphTest.class);
    return suite;
  }

}