/*

   Derby - Class nserverdemo.NsSampleClientThread

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package network;

import network.NsSample;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.PrintWriter;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.Random;

/**
 * NsSampleClientThread thread to perform the NsSampleWork
 */
public class NsSampleClientThread extends Thread {

	protected int thread_id;
	protected Properties properties;
	protected PrintWriter pw;
	protected String dbUrl;

  NsSampleClientThread(int id,String dbUrl, Properties properties,PrintWriter pw) {
		this.thread_id=id;
		this.dbUrl = dbUrl;
		this.properties = properties;
		this.pw = pw;
	}

   public void run() {
	 System.out.println("[NsSampleClientThread] Thread id - "+this.thread_id + "; started.");
	 NsSampleWork w = new NsSampleWork(this.thread_id,dbUrl,properties,pw);
	 w.doWork();  // do all the NsSampleWork
	 pw.println("[NsSampleClientThread] Thread id - "+this.thread_id+"; finished all tasks.");
   }
}




