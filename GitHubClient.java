/*
 *David Brady
 *x12112267
*/

import APIConnection.*;
import java.io.*;
import java.lang.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.* ;
import org.omg.CosNaming.NamingContextPackage.*;

import java.net.*;

public class GitHubClient {
    public static void main(String args[]){

	try{
	    ORB orb = ORB.init(args, null);

		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContext rootCtx = NamingContextHelper.narrow(objRef);
		NameComponent nc = new NameComponent("Hello", "");
		NameComponent path[] = {nc};
		
		GitHub api = GitHubHelper.narrow(rootCtx.resolve(path));

		Client callback = new Client_Tie(new ClientImpl()) ;

		//Below each of the five methods will be called using Dynamic Invocation
		//The Parameters to be passed to the methods are hardcoded

		System.out.println("Getting Basic Data");
		String userName1 = ("dbdev138");
		Request request1 = api._request("getBasicUserData"); 
		Any arg1_1 = request1.add_in_arg();
		Any arg2_1 = request1.add_in_arg();
		arg1_1.insert_string(userName1);
		arg2_1.insert_Object(callback);
		request1.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
		request1.invoke();

		System.out.println("Getting  Repo Details");
		String userName2 = ("dbdev138");
		String repoName2 = ("DEV-FYP-Process-Controller-Service");
		Request request2 = api._request("getRepoDetails"); 
		Any arg1_2 = request2.add_in_arg();
		Any arg2_2 = request2.add_in_arg();
		Any arg3_2 = request2.add_in_arg();
		arg1_2.insert_string(userName2);
		arg2_2.insert_string(repoName2);
		arg3_2.insert_Object(callback);
		request2.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
		request2.invoke();

		System.out.println("Getting  Developer Languages");
		String userName3 = ("dbdev138");
		String repoName3 = ("FYP-Client-UI");
		Request request3 = api._request("getDeveloperLanguages"); 
		Any arg1_3 = request3.add_in_arg();
		Any arg2_3 = request3.add_in_arg();
		Any arg3_3 = request3.add_in_arg();
		arg1_3.insert_string(userName3);
		arg2_3.insert_string(repoName3);
		arg3_3.insert_Object(callback);
		request3.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
		request3.invoke();

		System.out.println("Getting the number of repos");
		String userName4 = ("dbdev138");
		Request request4 = api._request("getRepoCount"); 
		Any arg1_4 = request4.add_in_arg();
		Any arg2_4 = request4.add_in_arg();
		arg1_4.insert_string(userName4);
		arg2_4.insert_Object(callback);
		request4.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
		request4.invoke();

		System.out.println("Getting the Clone Url: ");
		String userName5 = ("dbdev138");
		String repoName5 = ("FYP-Client-UI");
		Request request5 = api._request("getCloneUrl"); 
		Any arg1_5 = request5.add_in_arg();
		Any arg2_5 = request5.add_in_arg();
		Any arg3_5 = request5.add_in_arg();
		arg1_5.insert_string(userName5);
		arg2_5.insert_string(repoName5);
		arg3_5.insert_Object(callback);
		request5.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
		request5.invoke();

	} catch (Exception e) {
		   e.printStackTrace();
	}
  }
}

class ClientImpl implements ClientOperations {
	
	public void receiveBasicUserData(String info) {
		System.out.println("The Given Users basic info: \n" + info) ;
	}

	public void receiveRepoDetails(String info) {
		System.out.println("Below Is a Repo Summary: \n" + info) ;
	}

	public void receiveDeveloperLanguages(String info) {
		System.out.println(info);
	}

	public void receiveRepoCount(String info) {
		System.out.println("The user has : \n " + info) ;
	}

	public void receiveCloneUrl(String info) {
		System.out.println(info) ;
	}
}