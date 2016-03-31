/*
 *David Brady
 *x12112267
*/

import java.io.*;
import org.omg.CORBA.*;
import APIConnection.*;
import org.omg.CosNaming.* ;
import org.omg.CosNaming.NamingContextPackage.*;

public class GitHubServer {

	public static void main (String args[]) {
		try{

	   		ORB orb = ORB.init(args, null);
			GitHub helloRef = new GitHub_Tie(new GitHubServant());
			orb.connect(helloRef);

			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContext rootCtx = NamingContextHelper.narrow(objRef);
			NameComponent nc = new NameComponent("Hello", "");
			NameComponent path[] = {nc};
			rootCtx.rebind(path, helloRef);

			System.out.println("Server has been started ...");
			orb.run();

		} catch (Exception e) {
			System.err.println("Error: "+e);
			e.printStackTrace(System.out);
		}

	}
}